from PIL import ImageTk, Image
from PIL import Image, ImageDraw
from PIL import ImageFont

def quitarMarca(imagen, out):
    rgb = imagen.convert('RGB')
    pixels = out.load()    
    print()
    for i in range(imagen.size[0]):
        for j in range(out.size[1]):
            r,g,b = rgb.getpixel((i,j))
            nr = (r - g)
            if(nr < 10):
                pass
            else:
                prom = (int)((1.3540)*((r+g+b)/3))
                pixels[i,j] = (prom,prom,prom,0)
    return out


def ponerMarca(imagen, out, texto):
   base = imagen.convert('RGBA')
   print(base)
   # Hacer una imagen en blanco para el texto, inicializada a texto transparente color
   txt = Image.new('RGBA', base.size, (255,255,255,0))

   print(base.size)
   # Se da el font
   fnt = ImageFont.truetype('/usr/share/fonts/truetype/ttf-dejavu/DejaVuSerif.ttf', 20)

   d = ImageDraw.Draw(txt)

   d.text((0,50), texto , font=fnt, fill=(255,25, 55,50))

   out = Image.alpha_composite(base, txt)

   return out
