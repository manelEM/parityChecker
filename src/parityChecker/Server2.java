package parityChecker;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 extends Thread {
	

	public static void main(String[] args) 
	{
	
		new Server2().start();
	}
	public void run()
	{ 
		int nbClient=0;
	
		try {
			 ServerSocket ss=new ServerSocket(1234);
			 System.out.println("waiting for a connexion\n");
					while(true)
					{
						Socket s=ss.accept();
						nbClient++;
						new Conversation(s, nbClient).start();
					}
			}
							
				 catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		
	}
	
	
}
