package parityChecker;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("waiting for a connexion\n");
			Socket s=ss.accept();
			InputStream is=s.getInputStream();//it allows receiving the message from the client
			OutputStream os=s.getOutputStream();// it allows sending message to the client
			int nb=is.read();
			System.out.println("I received the number \t"+nb);
			int res=checkParity(nb);//call the method check parity to check if the number is odd or not
			os.write(res);
			s.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	private static int checkParity(int nb) {
		if (nb%2==0)
			return 1;
		return 0;
	}

}
