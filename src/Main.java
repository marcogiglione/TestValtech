import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import commands.AbstractCommand;
import commands.CommandFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));
		String strCommand;
		System.out.println("Hello, welcome to system developed from Marco Giglione");
		System.out.println("Insert a command and press enter (exit for close):");
		try {
			do {
				System.out.print(">");
				strCommand = bufferRead.readLine().trim();
				AbstractCommand command = CommandFactory.getInstance()
						.buildCommand(strCommand);
				System.out.println(command.execute());
			} while (!strCommand.equals("exit"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
