package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Scanner;
import javax.imageio.ImageIO;




public class Menu {
	private static Scanner s =  new Scanner(System.in);

	BufferedImage inputimage = null;
	double[][] theChoice2 = null;
	
	public Menu() {
		
	}

	public void start() throws IOException  {
		header();
		boolean keepRunning = true;
		while (keepRunning) {
			showOptions();
			int choice = enterInput();
//			BufferedImage inputimage = null;
//			double[][] theChoice2 = null;
			switch (choice) {
			  case 1:
				  try {
					inputimage = ImageIO.read(FileFinder.getFile());
						
					} catch (Exception e) {
						System.out.println("No file here!! Please try again");
					}
				    break;
				  case 2:
					 
					 System.out.println("Please select a Kernel");
					//Printing list of kernels. (haven't sorted the numbering after...)
					 Arrays.asList(Kernel.indexKernels).stream().forEach(i -> System.out.println(i));
					 
					 //User input selection..
					 int kernelSelection = enterInput();
					 //Selectin a Kernel object from the array...
					 Kernel theChoice = Kernel.indexKernels[kernelSelection-1];
					 theChoice2 = theChoice.getKernel();
					 //Just testing to see if it is considering it an array type and printing it! 
					 printdblarray(theChoice2);
				    break;
				  case 3:
					  printdblarray(theChoice2);
				    System.out.println("Processing..");
				    
				    try {
				    	
				   ImageConvolution.convolution(inputimage, theChoice2);
				    }
				    catch(Exception e) {
				    	System.out.println("Error wih your Kernel!");
				    }
				    break;
				  case 4:
					  CreateYourOwnFilter.userKernel();
					  System.out.println("If this filter is ok, then click ENTER to apply to your image");
					  
					  break;
				  case 5:
					  printdblarray(theChoice2);
//					 double[][] arr = Kernel.SHARPEN.getKernel();
//					 inputimage = ImageIO.read(new File("C:\\Users\\Fez\\eclipse-workspace\\AssignmentOOP\\bin\\image.png"));
//					 ImageConvolution.convolution(inputimage, arr);
					  break;  
				  case 6:
				    System.out.println("Shutting down now, I hope you had fun");
				    
				    keepRunning=false;
				    break;
				
			}

		}
	}

	private void showOptions() {
		
		System.out.println("1) Enter Image Name"); // Ask user to specify the file to process. Do NOT hardcode paths or
													// file names
		System.out.println("2) Select a Filter");
		System.out.println("3) Apply your selected filter"); // Add as many options to the menu as you like and feel
		System.out.println("4) Create your own filter");
		System.out.println("5)Apply your selected Filter");
		System.out.println("6) Quit"); // Terminate
		System.out.println("\nSelect Option [1-4]>");
		
	}
	private void header() {
		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		System.out.println(ConsoleColour.RESET);
	}
	private static int enterInput() {
		int choice = 0;
		try {
			choice = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException e) {
			
		}
		return choice;
	}// End GetInput Method
	
	
public static void printdblarray(double[][] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("");
			for (int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j]+" ");
			}
		}
	}
	
}

