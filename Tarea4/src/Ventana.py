import types
from tkinter import filedialog
from tkinter import *
from PIL import ImageTk, Image
import os
from Imagen import *
from MarcasAgua import *


class Interfaz(Frame):

    #Variable global que usaremos para crea un objeto de la clase Imagen
    global image

    """
    Constructor de la clase
    Manda a llamar el constructor de la clase Frame
    Se inicializan las variables imagen y aplicar para asignarles las imagenes
    Se crean los canvas y el menu
    """
    def __init__(self, parent):
        Frame.__init__(self,parent)
        self.pack(fill=BOTH, expand=True)
        self.imagen = None
        self.out = None
        self.ruta = None
        self.creaCanvas()
        self.creaMenu()

    """    
    Funcion para crear las pestanas del menu
    Se definen tres pestanas
    La primera es para abrir una imagen
    La segunda es la que nos da la opcion de aplicar filtros
    La tercera es para salir del programa
    """
    def creaMenu(self):

        self.menuBar = Menu(self)
        
        self.archivoMenu = Menu(self.menuBar, tearoff=0)

        self.archivoMenu.add_command(label="Abrir", command=self.escogerImagen)

        self.archivoMenu.add_command(label="Guardar", command=self.guardarImagen)
        
        self.menuBar.add_cascade(label="Imagen", menu=self.archivoMenu)

        self.menuBar.add_command(label="Poner",  command = lambda: self.aplicaFiltro(2))

        self.menuBar.add_command(label="Quitar",  command = lambda: self.aplicaFiltro(1))

        self.menuBar.add_command(label="Salir", command = self.salir)

        root.config(menu=self.menuBar)

    """
    Funcion para crear los canvas
    Se crea un canvas izquierdo y derecho 
    """
    def creaCanvas(self):

        self.originalVentana = Canvas(self, bg="black",width=600,height=600)
        self.originalVentana.pack(side=LEFT, fill=BOTH, expand=True)
        
        self.filtroVentana = Canvas(self,bg ="black",width=600,height=600 )
        self.filtroVentana.pack(side=RIGHT, fill=BOTH, expand=True)

    """
    Funcion para salir del programa
    """
    def salir(self):
        os._exit(0)

    """
    Funcion para guardar la imagen ya con filtros
    """
    def guardarImagen(self):
        self.top = Toplevel()
        self.nuevaImagen.save(filedialog.asksaveasfilename())
        self.top.destroy()
   
    """
    Funcion para colocar las imagenes en los canvas
    Se abre la ventana para la seleccion de la
    Se colocan dos imagenes iguales
    En el canvas izquierdo se va a mantener la imagen original
    En el canvas derecho se coloca la imagen que se le aplicaran los filtros
    """
    def escogerImagen(self):
        
        self.ruta = filedialog.askopenfilename()
        image = Imagen(self.ruta)
        self.imagen = image.getImagen()
        self.out = image.getOut()
        
        imageFile = ImageTk.PhotoImage(self.imagen)
        imageAplica = ImageTk.PhotoImage(self.out)

        self.originalVentana.image = imageFile
        self.originalVentana.create_image(imageFile.width()/2, imageFile.height()/1.5, anchor=CENTER, image=imageFile, tags="bg_img")

        self.filtroVentana.image = imageAplica
        self.filtroVentana.create_image(imageAplica.width()/2, imageAplica.height()/1.5, anchor=CENTER, image=imageAplica, tags="bg_img")

        print(self.imagen)
    """
    Funcion para seleccionar que filtro aplicar
    Dado un entero se decide que filtro aplicaremos a la imagen
    """
    def aplicaFiltro(self,opcion):

        if self.filtroVentana.find_all() != ():
            if opcion == 1:
                self.nuevaImagen = quitarMarca(self.imagen,self.out)
            elif opcion == 2:
            	self.nuevaImagen = ponerMarca(self.out, self.out, "Procesamiento Digital De imagenes")
            imageAplica = ImageTk.PhotoImage(self.nuevaImagen)
            self.filtroVentana.image = imageAplica
            self.filtroVentana.create_image(imageAplica.width()/2, imageAplica.height()/1.5, anchor=CENTER, image=imageAplica, tags="bg_img")
        else:
            tkMessageBox.showwarning("Error","Escoge una imagen antes de aplicar un filtro")
        
"""
Funcion main
Se crea un objeto de la clase Tk
Le ponemos titulo a la ventana
Creamos un objeto de nuestra clase Filtros
Y se ejecuta el programa
"""        
if __name__  == "__main__":
    root = Tk()
    root.title("MARCAS DE AGUA")
    root.wm_state("normal")
    app = Interfaz(root)
    root.mainloop()