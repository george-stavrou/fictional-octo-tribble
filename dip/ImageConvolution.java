package ie.gmit.dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageConvolution {
	


	public static BufferedImage convolution(BufferedImage input, double[][] kernel) throws IOException {
		BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
		// getting length and height of image
		int WIDTH = input.getWidth();
		int HEIGHT = input.getHeight();

		// Loop Input image
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
					
				
				float red = 0f, green = 0f, blue = 0f;
				// loop kernel
				for (int i = 0; i < kernel.length; i++) {
					for (int j = 0; j < kernel.length; j++) {

						// Calculating X and Y coordinates of the pixel to be multiplied
						// with current kernel element
						// In case of edges of image the '% WIDTH' wraps the image and
						// the pixel from opposite edge is used
						int imageX = (x - (kernel.length - 1) / 2 + i + WIDTH) % WIDTH;
						int imageY = (y - (kernel.length - 1) / 2 + j + HEIGHT) % HEIGHT;

						int RGB = input.getRGB(imageX, imageY);
						int R = (RGB >> 16) & 0xff; // Red Value
						int G = (RGB >> 8) & 0xff; // Green Value
						int B = (RGB) & 0xff; // Blue Value

						// The RGB is multiplied with current kernel element and added
						// on to the variables red, blue and green
						red += (R * kernel[i][j]);
						green += (G * kernel[i][j]);
						blue += (B * kernel[i][j]);
					}
				}
				int outR, outG, outB;
				// The value is truncated to 0 and 255 if it goes beyond
				outR = Math.min(Math.max((int) (red), 0), 255);
				outG = Math.min(Math.max((int) (green), 0), 255);
				outB = Math.min(Math.max((int) (blue), 0), 255);
				// Pixel is written to output image
				output.setRGB(x, y, new Color(outR, outG, outB).getRGB());
			}
		}
		try {
			ImageIO.write(output, "PNG", new File("output.png"));
		} catch (IOException e) {
			System.out.println(ConsoleColour.RED);
			System.out.println("Error Writing the File");
			System.out.println(ConsoleColour.RESET);
		}
		
		return output;
	}

}
