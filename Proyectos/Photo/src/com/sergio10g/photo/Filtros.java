package com.sergio10g.photo;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;

import javax.imageio.ImageIO;

public class Filtros {

	static BufferedImage image;
	public static void main(String[] args) {
		File ficheroImagen = new File("D:\\Users\\Campus FP\\Pictures\\demigod.png");
		//File ficheroImagen = new File("D:\\Users\\Campus FP\\Documents\\Sergio Díez García\\Proyectos\\Photo\\bosque_invert.jpg");
		try {
			image = ImageIO.read(ficheroImagen);
			BufferedImage out = invert(image);
			ImageIO.write(out, "jpg", new File("./evilmario.jpg"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage gaussianBlur(BufferedImage image, int radius) {
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage out = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int cellCount = 0;
				int red = 0;
				int green = 0;
				int blue = 0;
				for (int y = 0; y < radius; y++) {
					if (i + y - (radius / 2) >= height || i + y - (radius / 2) < 0)
							continue;
					for (int x = 0; x < radius; x++) {
						if (j + x - (radius / 2) >= width || j + x - (radius / 2) < 0)
							continue;
						red += (new Color(image.getRGB(j + x - (radius / 2), i + y - (radius / 2)))).getRed();
						green += (new Color(image.getRGB(j + x - (radius / 2), i + y - (radius / 2)))).getGreen();
						blue += (new Color(image.getRGB(j + x - (radius / 2), i + y - (radius / 2)))).getBlue();
						cellCount++;
					}
				}
				out.setRGB(j, i, (new Color(red / cellCount, green / cellCount, blue / cellCount)).getRGB());
			}
		}
		return out;
	}

	public static BufferedImage invert(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage out = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int red = (new Color(image.getRGB(j, i))).getRed();
				int green = (new Color(image.getRGB(j, i))).getGreen();
				int blue = (new Color(image.getRGB(j, i))).getBlue();
				out.setRGB(j, i, (new Color(255 - red, 255 - green, 255 - blue)).getRGB());
			}
		}
		return out;
	}

	public static BufferedImage getRed(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage out = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int red = (new Color(image.getRGB(j, i))).getRed();
				out.setRGB(j, i, (new Color(red, 0, 0)).getRGB());
			}
		}
		return out;
	}

	public static BufferedImage getGreen(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage out = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int green = (new Color(image.getRGB(j, i))).getGreen();
				out.setRGB(j, i, (new Color(0, 255 - green, 0)).getRGB());
			}
		}
		return out;
	}

	public static BufferedImage getBlue(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage out = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int blue = (new Color(image.getRGB(j, i))).getBlue();
				out.setRGB(j, i, (new Color(0, 0, 255 - blue)).getRGB());
			}
		}
		return out;
	}
	
}
