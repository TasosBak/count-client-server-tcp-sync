import java.net.*;
import java.io.*;

public class MultithreadedCountServerTCP {
	private static final int PORT = 1234;
	public static Count n = new Count();
	public static Integer clientCount = 0;

	public static void main(String args[]) throws IOException {

		ServerSocket connectionSocket = new ServerSocket(PORT);

		while (true) {

			System.out.println("Server is listening to port: " + PORT);
			Socket dataSocket = connectionSocket.accept();
			clientCount++;

			System.out.println("Received request from " + dataSocket.getInetAddress());
			System.out.println("Clients#: " + clientCount);

			ServerThread sthread = new ServerThread(dataSocket, n);
			sthread.start();
		}

	}
}
