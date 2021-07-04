package ie.gmit.dip;
import java.io.File;
import java.util.Scanner;

public class FileFinder {
	private final static Scanner sc = new Scanner(System.in);
	
	public static File getFile() throws Exception {
		System.out.println("Enter File Name. Please enter full directory and ensure it is a PNG file!");
		String userPath = sc.next();
		File f = new File(userPath);
		if (f.exists()){
			System.out.println("Image uploaded succesfully.");
		    return f;
		  }else{
		    throw new Exception("Invalid file name...!");
		  }
		
	}
	
	

}
