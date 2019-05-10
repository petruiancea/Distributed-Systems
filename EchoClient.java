import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
	
		try {
			// verbinde mit dem rechner unter der ip adresse
			// 127.0.0.1 auf dem port 1565
			Socket socket = new Socket("127.0.0.1", 1565);
			// erzeuge kommunikationsendpunkt um daten zu schicken
			PrintWriter printW = new PrintWriter(socket.getOutputStream());
			File file = new File("clientdatei.txt");
			Scanner scanner = null;
			try {
				scanner = new Scanner(file);
				String tmp="";
				while (scanner.hasNext()) {
					tmp =  scanner.nextLine();
					printW.println(tmp);
					
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");

			}
			printW.println();
			printW.flush();
			printW.close();
			socket.close();
			
			socket = new Socket("127.0.0.1", 1565);
			// erzeuge kommunikationsendpunkt um daten zu lesen
			BufferedReader bufRead = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			System.out.println("Server antwortet:\n");
			String temp1;
			while ((temp1=bufRead.readLine())!= null) {
				
				System.out.println(temp1);
			}
		} catch (IOException e) {
			System.out.println("Keine Server-Verbindung!");
			System.exit(1);

		}
	}
}