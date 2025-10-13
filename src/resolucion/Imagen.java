package resolucion;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagen {
	Pixel[][] pixels;
	int alto;
	int ancho;
	
	Imagen(String archivo)
	{
		File file= new File(archivo);
		try {
			BufferedImage image = ImageIO.read(file);
			ancho = image.getWidth();
			alto = image.getHeight();
			pixels = new Pixel[alto][ancho];
			for(int i=0; i<alto; i++)
			{
				for(int j=0; j<ancho; j++)
				{
					pixels[i][j]=new Pixel(image.getRGB(j, i));
				}
			}
		} catch (IOException e) {
			System.err.println("No se encontr� el archivo " + archivo);
			System.exit(0);
		}
	}


	/**
	 * Guarda la imagen en un archivo seg�n el formato indicado
	 * @param archivo El nombre de archivo, e.g., "lena.bmp"
	 * @param formato El formato de imagen: "bmp", "png", "jpg", etc. 
	 */
	void guardar(String archivo, String formato)
	{
		BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		for(int i=0; i<alto; i++)
		{
			for(int j=0; j<ancho; j++)
				image.setRGB(j,i, pixels[i][j].aInt());
		}
		
		try {
			ImageIO.write(image, formato, new File(archivo));
		} catch (IOException e) {
			System.err.println("Error al guardar en el archivo " + archivo);
			e.printStackTrace();
		}
	}
	
	public void enrojecer(int cant) {
		for (int i = 0; i < pixels.length;i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				Pixel punto = pixels[i][j];
				punto.rojo += cant;
				if (punto.rojo > 255) {
					punto.rojo = 255;
				}
			}
		}
	}
	
	void aumentarBrillo(int cant) {
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				Pixel aumentar = pixels[i][j];
				aumentar.rojo += cant;
				aumentar.verde += cant;
				aumentar.azul += cant;
				if (aumentar.rojo > 255) {
					aumentar.rojo = 255;
				}
				if (aumentar.verde > 255) {
					aumentar.verde = 255;
				}
				if (aumentar.azul > 255) {
					aumentar.azul = 255;
				}
			}
		}
	}
	
	void aGrises() {
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				Pixel grises = pixels[i][j];
				int gris = (int)(grises.rojo * 0.3 + grises.verde * 0.6 + grises.azul * 0.1);
				grises.rojo = gris;
				grises.verde = gris;
				grises.azul = gris;
			}
		}
	}
	
	void invertir() {
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				Pixel escala = pixels[i][j];
				escala.rojo = 255 - escala.rojo;
				escala.verde = 255 - escala.verde;
				escala.azul = 255 - escala.azul;
				}
		}
	}
	
	void espejar() {
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length / 2; j++) {
				Pixel punto = pixels[i][j];
				pixels[i][j] = pixels[i][pixels[i].length - 1 - j];
				pixels[i][pixels[i].length - 1 - j] = punto;
			}
		}
	}
	
	void girarDerecha() {
		int alto = pixels.length;
		int ancho = pixels[0].length;
		Pixel[][] matriz = new Pixel[ancho][alto];
		
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				matriz[j][alto - 1 - i] = pixels[i][j];
			}
		}
		
		pixels = matriz;
	}
	
}
