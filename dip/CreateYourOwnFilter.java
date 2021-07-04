package ie.gmit.dip;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.System.out;

public class CreateYourOwnFilter {
	private static Scanner s =  new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static float[][] userKernel() {
		System.out.println("Enter Kernel dimension:");
		int order = enterInput();
		float sum_of_elements =0;
		float[][] userKernel = new float[order][order];
		// Getting the Kernel Matrix as input from the user
				for(int i=0; i < order; i++)
				for(int j=0; j < order; j++)
				{
					out.print(i+","+j+":");
					userKernel[i][j] = enterInput2();
				}
				
				out.println("\nThe Kernel Matrix is:\n");
				
				//Printing homemade kernel
				for(int i=0; i < order; i++)
				{
					for(int j=0; j < order; j++)
					{
						out.print("\t"+userKernel[i][j]);
						sum_of_elements += userKernel[i][j];
					}
					out.println();
				}
				
				out.println("\nThe sum of matrix elements is: "+sum_of_elements);
//		if(order%2 ==0) {
//			System.out.println("Your Kernel must be odd numbered! Try 3, 5 or 7 ");
//		}
		return userKernel;
		
	}
	
	public static void printUserKernel() {
		
	}
	private static int enterInput() {
		int choice = 0;
		try {
			choice = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException e) {
			
		}
		return choice;
	}
	private static float enterInput2() {
		float choice = 0;
		try {
			choice = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException e) {
			
		}
		return choice;
	}

	
}
