import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static void main (String[] args) {
		
		String s = "Methods from Server: "; 
		
		
		do {
			
			switch (s) {
		
			case "directoryListing": 
			
				System.out.println (""); 
				break; 
			
			case "renameDirectory": 
			
				System.out.println("");
				break; 
			
			case "renameFile": 
			
				System.out.println("");
				break; 
			
			case "addDirectory": 
			
				System.out.println("");
				break; 
			
			case "addFile": 
			
				System.out.println("");
				break; 
			
			case "appendToFile": 
			
				System.out.println("");
				break; 
			
			case "getFile": 
			
				System.out.println("");
				break; 
			
			case "closeProgram": 
			
				System.out.println("");
				break; 
			
			default: 
			
				System.out.println("No method found by this name.");	
			}
		}while(closeProgram); 
		
			
	}

}
