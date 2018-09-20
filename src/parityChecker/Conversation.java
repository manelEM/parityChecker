package parityChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Conversation extends Thread {
	private Socket socket;
	private int number;
	
	
	public Conversation(Socket socket, int number) {
		super();
		this.socket = socket;
		this.number = number;
	}
	

	@Override
	public void run() {
		try {
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os,true);
			
			System.out.println("connection of the client number"+number);
			
			while(true)
			{
				String message=br.readLine();
				System.out.println("the client number " +number+ "send this message :"+message);
;
				}
			
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
