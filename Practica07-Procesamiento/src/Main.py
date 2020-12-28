import tkFileDialog
import types
from Tkinter import *
import tkMessageBox
from PIL import ImageTk, Image
import os
from Imagen import *
from TonosGris import *
from FiltroMosaico import *
from Letras import *
from Recursiva import *
from Dithering import *
from Esteganografia import *

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
        self.aplica = None
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
        self.archivoMenu.add_command(label="Guardar", command=self.preguntaGuardar)

        self.menuBar.add_cascade(label="Imagen", menu=self.archivoMenu)

        self.filtroMenu = Menu(self.menuBar, tearoff=0)

        self.filtroMenu.add_command(label="Filtro mosaico", command = lambda: self.aplicaMosaico(1))
        self.filtroMenu.add_command(label="Recursiva gris", command = lambda: self.aplicaMosaico(2))
        self.filtroMenu.add_command(label="Recursiva color", command = lambda: self.aplicaMosaico(3))

        self.filtroMenu.add_command(label="Filtro Sepia", command = self.aplicaSepia)
        self.filtroMenu.add_command(label="Dithering", command = lambda: self.aplicaFiltro(18))

        self.estegano = Menu(self.filtroMenu, tearoff=0)
        self.estegano.add_command(label="Cifrar", command=self.aplicaCifrado)
        self.estegano.add_command(label="Descifrar", command= self.obtenDescifrado)
        self.filtroMenu.add_cascade(label="Esteganografia", menu=self.estegano)

        self.letraMenu = Menu(self.menuBar, tearoff=0)
        self.letraMenu.add_command(label="Colores", command = lambda: self.aplicaLetra(1))
        self.letraMenu.add_command(label="Gris", command = lambda: self.aplicaLetra(2))
        self.letraMenu.add_command(label="Simbolos", command = lambda: self.aplicaLetra(8))
        self.letraMenu.add_command(label="SimbolosGris", command = lambda: self.aplicaLetra(3))
        self.letraMenu.add_command(label="SimbolosColor", command = lambda: self.aplicaLetra(4))
        self.letraMenu.add_command(label="Palabra", command = self.aplicaPalabra)
        self.letraMenu.add_command(label="Naipes", command = lambda: self.aplicaLetra(5))
        self.letraMenu.add_command(label="Domino Negro", command = lambda: self.aplicaLetra(6))
        self.letraMenu.add_command(label="Domino Blanco", command = lambda: self.aplicaLetra(7))

        self.menuBar.add_cascade(label="Filtros", menu=self.filtroMenu)

        self.menuBar.add_cascade(label="Letras", menu=self.letraMenu)

        self.menuBar.add_command(label="Salir", command = self.salir)

        root.config(menu=self.menuBar)

    """
    Funcion para crear los canvas
    Se crea un canvas izquierdo y derecho
    """
    def creaCanvas(self):

        self.originalVentana = Canvas(self, bg="white",width=500,height=400)
        self.originalVentana.pack(side=LEFT, fill=BOTH, expand=True)

        self.filtroVentana = Canvas(self,bg ="white",width=500,height=400 )
        self.filtroVentana.pack(side=RIGHT, fill=BOTH, expand=True)

    """
    Funcion para salir del programa
    """
    def salir(self):
        os._exit(0)

    """
    Ventana emergente para mostrar los formatos en el que se puede guardar la imagen
    """
    def preguntaGuardar(self):
        if self.filtroVentana.find_all() != ():
            self.top = Toplevel()

            self.label = Label (self.top, text= "Puedes guardar la imagen en formato jpg o png")
            self.label.pack()

            self.buttontext = StringVar()
            self.buttontext.set("Guardar")
            self.button = Button(self.top, textvariable=self.buttontext, command= self.guardarImagen).pack()
        else:
            tkMessageBox.showwarning("Error","No hay imagen")

    """
    Funcion para guardar la imagen con el filtro aplicado
    """
    def guardarImagen(self):
        self.nuevaImagen.save(tkFileDialog.asksaveasfilename())
        self.top.destroy()

    """
    Funcion para colocar las imagenes en los canvas
    Pregunta por la imagen que se desea abrir
    Se colocan dos imagenes iguales
    En el canvas izquierdo se va a mantener la imagen original
    En el canvas derecho se coloca la imagen que se le aplicaran los filtros
    """
    def escogerImagen(self):

        ruta = tkFileDialog.askopenfilename()
        image = Imagen(ruta)
        self.imagen = image.getImagen()
        self.aplica = image.getAplica()

        imageFile = ImageTk.PhotoImage(self.imagen)
        imageAplica = ImageTk.PhotoImage(self.aplica)

        self.originalVentana.image = imageFile
        self.originalVentana.create_image(imageFile.width()/2, imageFile.height()/2, anchor=CENTER, image=imageFile, tags="bg_img")

        self.filtroVentana.image = imageAplica
        self.filtroVentana.create_image(imageAplica.width()/2, imageAplica.height()/2, anchor=CENTER, image=imageAplica, tags="bg_img")

        self.originalVentana.create_text((250,380),text="Imagen original")
        self.filtroVentana.create_text((250,380),text="Imagen con filtro")

    """
    Funcion para seleccionar que filtro aplicar
    Dado un entero se decide que filtro aplicaremos a la imagen
    """
    def aplicaFiltro(self,opcion):

        if self.filtroVentana.find_all() != ():
            if opcion == 4:
                self.nuevaImagen = filtroGris1(self.imagen,self.aplica)
            elif opcion == 5:
                self.nuevaImagen = filtroGris2(self.imagen,self.aplica)
            elif opcion == 6:
                self.nuevaImagen = filtroGris3(self.imagen,self.aplica)
            elif opcion == 7:
                self.nuevaImagen = filtroGris4(self.imagen,self.aplica)
            elif opcion == 8:
                self.nuevaImagen = filtroGris5(self.imagen,self.aplica)
            elif opcion == 9:
                self.nuevaImagen = filtroGris6(self.imagen,self.aplica)
            elif opcion == 10:
                self.nuevaImagen = filtroGris7(self.imagen,self.aplica)
            elif opcion == 11:
                self.nuevaImagen = filtroGris8(self.imagen,self.aplica)
            elif opcion == 18:
                self.nuevaImagen = dithering(self.imagen,self.aplica)
            imageAplica = ImageTk.PhotoImage(self.nuevaImagen)
            self.filtroVentana.image = imageAplica
            self.filtroVentana.create_image(imageAplica.width()/2, imageAplica.height()/2, anchor=CENTER, image=imageAplica, tags="bg_img")
        else:
            tkMessageBox.showwarning("Error","Escoge una imagen antes de aplicar un filtro")


    """
    Ventana emergente para aplicar la cantidad de brillo a la imagen al aplicar el filtro brillo
    """
    def aplicaBrillo(self):
        if self.filtroVentana.find_all() != ():
            self.top = Toplevel()

            self.label = Label (self.top, text= "Introduce la cantidad de brillo que quieres\nTiene que ser un valor entre -128 y 128.")
            self.label.pack()

            self.entrytext = IntVar()
            Entry(self.top, textvariable=self.entrytext).pack()

            self.buttontext = StringVar()
            self.buttontext.set("Aplica Brillo")
            self.button = Button(self.top, textvariable=self.buttontext, command= lambda: self.sacaValor(self.entrytext)).pack()
        else:
            tkMessageBox.showwarning("Error","Escoge una imagen antes de aplicar un filtro")

    """
    Al colocar un valor en la pantalla emergente para el brillo
    Ese valor se le pasa a la funcion de filtroBrillo
    """
    def sacaValor(self,valor):

        self.entrytext = valor.get()
        self.nuevaImagen = filtroBrillo(self.imagen,self.aplica,self.entrytext)
        imageAplica = ImageTk.PhotoImage(self.nuevaImagen)
        self.filtroVentana.image = imageAplica
        self.filtroVentana.create_image(imageAplica.width()/2, imageAplica.height()/2, anchor=CENTER, image=imageAplica, tags="bg_img")
        self.top.destroy()


    """
    Ventana emergente para dar el tamanio del mosaico para el filtro mosaico
    """
    def aplicaMosaico(self,opcion):
        if self.filtroVentana.find_all() != ():

            self.top = Toplevel()

            self.label = Label (self.top, text= "Introduce el tamanio del mosaico\nDa dos valores positivos para (x,y) ")
            self.label.pack()

            self.entraX

    """
    Al colocar los dos valores en la ventana emergente de aplicaMosaico
    Esos valores se le pasan a la funcion filtroMosaico
    """
    def obtenMosaico(self,valorX,valorY,opcion):
        self.entraX = valorX.get()
        self.entraY = valorY.get()
        if(opcion == 1):
            self.nuevaImagen = filtroMosaico(self.imagen,self.aplica,self.entraX,self.entraY)
        elif(opcion == 2):
            generaImagenesGris(self.imagen,self.aplica)
            self.nuevaImagen = aplicaRecursivaGris(self.imagen,self.aplica,self.entraX,self.entraY)
            eliminaImagenesGris()
        elif(opcion == 3):
            self.nuevaImagen = aplicaRecursivaColor(self.imagen,self.aplica,self.entraX,self.entraY)
        imageAplica = ImageTk.PhotoImage(self.nuevaImagen)
        self.filtroVentana.image = imageAplica
        self.filtroVentana.create_image(imageAplica.width()/2, imageAplica.height()/2, anchor=CENTER, image=imageAplica, tags="bg_img")
        self.top.destroy()

    """
    Ventana emergente para dar el tamanio del mosaico para el filtro de letras
    """
    def aplicaLetra(self,opcion):
        if self.filtroVentana.find_all() != ():

            self.top = Toplevel()

            self.label = Label (self.top, text= "Introduce el tamanio del mosaico\nDa dos valores positivos para (x,y) ")
            self.label.pack()

            self.entraX = IntVar()
            Entry(self.top, textvariable=self.entraX).pack()

            self.entraY = IntVar()
            Entry(self.top, textvariable=self.entraY).pack()

            self.text = Label (self.top, text="Dar un nombre al archivo html que se va a generar")
            self.text.pack()

            self.nombre = StringVar()
            Entry(self.top, textvariable=self.nombre).pack()

            self.buttontext = StringVar()
            self.buttontext.set("Genera imagen")

            self.button = Button(self.top, textvariable=self.buttontext, command= lambda: self.obtenLetra(self.entraX,self.entraY,self.nombre,opcion)).pack()
        else:
            tkMessageBox.showwarning("Error","Escoge una imagen antes de aplicar un filtro")

    """
    Con los valores de la ventana emergente y el nombre
    Se les pasa a alguna funcion de los filtros de letras
    """
    def obtenLetra(self,valorX,valorY,nombreA,opcion):
        self.entraX = valorX.get()
        self.entraY = valorY.get()
        self.nombre = nombreA.get()
        if(opcion == 1):
            letraColor(self.imagen,self.aplica,self.entraX,self.entraY,self.nombre)
        elif(opcion == 2):
            letraGris(self.imagen,self.aplica,self.entraX,self.entraY,self.nombre)
        elif(opcion == 3):
            simbolosGris(self.imagen,self.aplica,self.entraX,self.entraY,self.nombre)
        elif(opcion == 4):
            simbolosColor(self.imagen,self.aplica,self.entraX,self.entraY,self.nombre)
        elif(opcion == 5):
            naipes(self.imagen,self.aplica,self.entraX,self.entraY,self.nombre)
        elif(opcion == 6):
            dominoN(self.imagen,self.aplica,self.entraX,self.entraY,self.nombre)
        elif(opcion == 7):
            dominoB(self.imagen,self.aplica,self.entraX,self.entraY,self.nombre)
        elif(opcion == 8):
            simbolos(self.imagen,self.aplica,self.entraX,self.entraY,self.nombre)
        self.top.destroy()

    """
    Ventana emergente para dar el tamanio del mosaico para el filtro de una cadena
    """
    def aplicaPalabra(self):
        if self.filtroVentana.find_all() != ():

            self.top = Toplevel()

            self.label = Label (self.top, text= "Introduce el tamanio del mosaico\nDa dos valores positivos para (x,y) ")
            self.label.pack()

            self.entraX = IntVar()
            Entry(self.top, textvariable=self.entraX).pack()

            self.entraY = IntVar()
            Entry(self.top, textvariable=self.entraY).pack()

            self.peticion = Label(self.top, text="Da una cadena para el filtro")
            self.peticion.pack()

            self.cadena = StringVar()
            Entry(self.top, textvariable=self.cadena).pack()

            self.text = Label (self.top, text="Dar un nombre al archivo html que se va a generar")
            self.text.pack()

            self.nombre = StringVar()
            Entry(self.top, textvariable=self.nombre).pack()

            self.buttontext = StringVar()
            self.buttontext.set("Genera imagen")

            self.button = Button(self.top, textvariable=self.buttontext, command= lambda: self.obtenPalabra(self.entraX,self.entraY,self.nombre,self.cadena)).pack()
        else:
            tkMessageBox.showwarning("Error","Escoge una imagen antes de aplicar un filtro")

    """
    Con los valores de la ventana emergente,el nombre y la cadena
    Se le pasa a la funcion palabra
    """
    def obtenPalabra(self,valorX,valorY,nombreA,cadenaA):
        self.entraX = valorX.get()
        self.entraY = valorY.get()
        self.nombre = nombreA.get()
        self.cadena = cadenaA.get()
        palabra(self.imagen,self.aplica,self.entraX,self.entraY,self.nombre,self.cadena)
        self.top.destroy()

    """
    Ventana emergente para dar un valor al aplicar el filtro sepia
    """
    def aplicaSepia(self):
        if self.filtroVentana.find_all() != ():
            self.top = Toplevel()

            self.label = Label (self.top, text= "Introduce la cantidad de brillo que quieres\nTiene que ser un valor entre 0 y 255.")
            self.label.pack()

            self.entrytext = IntVar()
            Entry(self.top, textvariable=self.entrytext).pack()

            self.buttontext = StringVar()
            self.buttontext.set("Aplica Sepia")
            self.button = Button(self.top, textvariable=self.buttontext, command= lambda: self.sacaSepia(self.entrytext)).pack()
        else:
            tkMessageBox.showwarning("Error","Escoge una imagen antes de aplicar un filtro")

    """
    Al colocar un valor en la pantalla emergente para el brillo
    Ese valor se le pasa a la funcion de filtroBrillo
    """
    def sacaSepia(self,valor):

        self.entrytext = valor.get()
        self.nuevaImagen = filtroSepia(self.imagen,self.aplica,self.entrytext)
        imageAplica = ImageTk.PhotoImage(self.nuevaImagen)
        self.filtroVentana.image = imageAplica
        self.filtroVentana.create_image(imageAplica.width()/2, imageAplica.height()/2, anchor=CENTER, image=imageAplica, tags="bg_img")
        self.top.destroy()

    """
    Ventana emergente para dar el mensaje a ocultar y el nuevo nombre de la imagen generada
    """
    def aplicaCifrado(self):
        if self.filtroVentana.find_all() != ():
            self.top = Toplevel()

            self.label = Label (self.top, text= "Introduce el mensaje que quieres ocultar")
            self.label.pack()

            self.entrytext = StringVar()
            Entry(self.top, textvariable=self.entrytext).pack()

            self.label2 = Label (self.top, text = "Introduce el nombre de la nueva imagen que se va a generar")
            self.label2.pack()

            self.nombre = StringVar()
            Entry(self.top,textvariable=self.nombre).pack()

            self.buttontext = StringVar()
            self.buttontext.set("Cifrar mensaje")
            self.button = Button(self.top, textvariable=self.buttontext, command= lambda: self.sacaCifrado(self.entrytext,self.nombre)).pack()
        else:
            tkMessageBox.showwarning("Error","Escoge una imagen antes de aplicar un filtro")

    """
    Se oculta el mensaje en la imagen
    """
    def sacaCifrado(self,valor,nombre):

        self.entrytext = valor.get()
        self.nombre = nombre.get()
        self.nuevaImagen = cifrar(self.imagen,self.entrytext,self.nombre)
        imageAplica = ImageTk.PhotoImage(self.nuevaImagen)
        self.filtroVentana.image = imageAplica
        self.filtroVentana.create_image(imageAplica.width()/2, imageAplica.height()/2, anchor=CENTER, image=imageAplica, tags="bg_img")
        self.top.destroy()

    """
    Advierte que puede tardar el descifrado
    """
    def obtenDescifrado(self):
        if self.filtroVentana.find_all() != ():
            self.top2 = Toplevel()
            self.label2 = Label(self.top2, text="Puede tardar un poco en descrifrar el mensaje")
            self.label2.pack()
            self.buttontext = StringVar()
            self.buttontext.set("Descifrar mensaje")
            self.button = Button(self.top2, textvariable=self.buttontext, command= self.sacaDescifrado).pack()
        else:
            tkMessageBox.showwarning("Error","Escoge una imagen antes de aplicar un filtro")

    """
    Obtiene el mensaje oculto de la imagen dada
    """
    def sacaDescifrado(self):
        cadena = descifrar(self.imagen)
        self.top = Toplevel()
        self.top.geometry("%dx%d%+d%+d" % (300, 200, 500, 250))
        self.label = Label(self.top, text="El mensaje oculto es " + cadena)
        self.label.pack()
        self.top2.destroy()


    """
    Genera el archivo de texto que se llamara imagenes.txt con la informacion de las imagenes a usar
    """
    def generaArchivoImg(self,archivo):
        self.nombre = archivo.get()
        carpeta = tkFileDialog.askdirectory()
        guardaImagenes(carpeta,self.nombre)
        self.top.destroy()

"""
Funcion main
Se crea un objeto de la clase Tk
Le ponemos titulo a la ventana
Creamos un objeto de nuestra clase Filtros
Y se ejecuta el programa
"""
if __name__  == "__main__":
    root = Tk()
    root.title("Proceso Digital de Imagenes")
    root.wm_state("normal")
    app = Interfaz(root)
    root.mainloop()
