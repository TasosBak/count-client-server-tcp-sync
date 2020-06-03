import java.net.*;
import java.io.*;

public class ServerProtocol {

	private Count counter;

	public ServerProtocol(Count c) {

		counter = c;
	}

	public String processRequest(String theInput) {

		String theOutput;
		if (theInput.equals("INC ")) {

			counter.increment();
			theOutput = counter.getThreadName() + " - " + theInput + counter.print();
			counter.printThreadName();
		} else
			theOutput = theInput;
		return theOutput;
	}
}