package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		Socket socket = null;
		InputStreamReader inputStreamReader =null;
		OutputStreamWriter outputStreamWriter =null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter =null;
		ServerSocket serverSocket =null;
		
		try {
			serverSocket = new ServerSocket(1234);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		while (true) {
			
			try {

				
				
				socket = serverSocket.accept();
				
				inputStreamReader = new InputStreamReader(socket.getInputStream());
				outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
				
				bufferedReader = new BufferedReader(inputStreamReader);
				bufferedWriter = new BufferedWriter(outputStreamWriter);
				
				while(true) {
					
					String msgFromClient = bufferedReader.readLine();
					
					System.out.println("Client: "+msgFromClient);
					
					bufferedWriter.write("MSG Received.");
					bufferedWriter.newLine();
					bufferedWriter.flush();
					
					if(msgFromClient.equalsIgnoreCase("BYE")) {
						
						break;
					}
				}
				socket.close();
				inputStreamReader.close();
				outputStreamWriter.close();
				bufferedReader.close();
				bufferedWriter.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
		
	}

}
