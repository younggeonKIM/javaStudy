package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Socket socket = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter =null;
		BufferedReader bufferedReader =null;
		BufferedWriter bufferedWriter = null;
		
		try {
			socket = new Socket(host:"localhost", port:"1234");
			
			inputStreamReader = new InputStreamReader(socket.getInputStream());
			outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
			
			bufferedReader = new BufferedReader(inputStreamReader);
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				String msgToSend = sc.nextLine();
				
				bufferedWriter.write(msgToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				
				System.out.println("server: "+bufferedReader.readLine());
				
			}
			
		}
		
	}
}
