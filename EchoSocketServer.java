import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoSocketServer {
	//static EchoSocketServer lesen = new EchoSocketServer();

	public static void main(String[] args) throws IOException {

		// EchoSocketServer lesen = new EchoSocketServer();
		// Der dienst wird auf dem port 1565 gestartet
		ServerSocket server = new ServerSocket(1565);
		// warte solange bis ein client eine verbindung herstellt
		
			Socket socket = server.accept();
			// erzeuge kommunkationsendpunkt um daten zulesen

			BufferedReader bufRead = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			System.out.println("Client schickt:\n");
			String temp;
			while ((temp = bufRead.readLine()) != null) {

				System.out.println(temp);
			}
			
			System.out.println("client vollstaendig empfangen");
			socket = server.accept();
			PrintWriter printW = new PrintWriter(socket.getOutputStream());
			// daten werden an den client geschickt

			File file = new File("serverdatei.txt");
			Scanner scanner = null;
			try {
				scanner = new Scanner(file);
				String tmp = "";
				while (scanner.hasNext()) {
					tmp = scanner.nextLine();
					printW.println(tmp);
					printW.flush();
				}
				printW.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");

			}
		

		

	}

	
}
