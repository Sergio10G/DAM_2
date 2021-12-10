package com.sergio10g.photo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	static BufferedImage image;
	
	public static void main(String[] args) {
		File ficheroImagen = new File("D:\\Users\\Campus FP\\Pictures\\demigod.png");
		try {
			image = ImageIO.read(ficheroImagen);
			int width = image.getWidth();
			int height = image.getHeight();
			int[][] greyScaleMatrix = new int[height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					Color color = new Color(image.getRGB(j, i));
					greyScaleMatrix[i][j] = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
				}
			}
			int factor = 2;
			int[][] scaledMatrix = scale(greyScaleMatrix, width, height, factor);
			int finalWidth = width / factor;
			int finalHeight = height / factor;

			FileWriter myWriter = new FileWriter("out.txt");
			for (int i = 0; i < finalHeight; i++) {
				for (int j = 0; j < finalWidth; j++) {
					myWriter.write(translateToAscii(scaledMatrix[i][j]));
					myWriter.write(translateToAscii(scaledMatrix[i][j]));
				}
				myWriter.write('\n');
			}
      		myWriter.close();
			//System.out.println(ImageIO.write(image, "jpg", new File("D:\\Users\\Campus FP\\Pictures\\nihao2.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int[][] scale(int[][] matrix, int width, int height, int factor) {
		int newWidth = width / factor;
		int newHeight = height / factor;
		int[][] newMatrix = new int[newHeight][newWidth];
		int sum;

		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {
				sum = 0;
				for (int y = 0; y < factor; y++) {
					for (int x = 0; x < factor; x++) {
						sum += matrix[i * factor + y][j * factor + x];
					}
				}
				newMatrix[i][j] = sum / factor;
			}
		}
		return newMatrix;
	}

	public static char translateToAscii(int val) {
		char ascii = ' ';
		switch (Math.round(val * 4 / 255)){
			case 0:
				ascii = '█';
				break;
			case 1:
				ascii = '▓';
				break;
			case 2:
				ascii = '▒';
				break;
			case 3:
				ascii = '░';
				break;
		}
		return ascii;
	}
}
