package parityChecker;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println("connectiong to the server..");
			Socket s=new Socket("localhost", 1234);
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			Scanner scanner=new Scanner(System.in);
			System.out.print("write a number");
			int nb=scanner.nextInt();
			os.write(nb);//sending the number
			System.out.println("waiting for the answer");
			int answer=is.read();
			String parity=ConevertAnswer(answer);
			System.out.println("this number is "+parity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String ConevertAnswer(int answer) {
		String res="odd";
		if (answer==1)
			res="even";
			
		return res;
	}

}
