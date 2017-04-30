/*Author: Treasure Muchenagumbo
 * Contact: muchenagumbosteam@gmail.com
 * Date: 04/29/17
 * 
 * During the Spring 2017 CUNY Hackathon, my team and I
 * worked on a project that allows for safer online purchasing
 * using TouchID. This code is the local server for the product's
 * prototype.
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

class Server{
	
	//PORT, SERVER SOCKET, AND SOCKET FOR CLIENT CONNECTION AND SERVER START-UP
	//isRunning IS TRUE ONCE THE SERVER IS UP AND RUNNING
	private final int port = 6027;
	private ServerSocket socket;
	private Socket client;
	private boolean isRunning = false;
	
	//DATA STREAMS
	private DataInputStream fromClient;
	private DataOutputStream toClient;
	
	
	
	//DEFAULT CTOR
	public Server(){
		StartServer();
		Communicate();
	}
	
	//THIS METHOD GETS THE SERVER STARTED AT PORT=6027
	private void StartServer(){
		
		try{
			socket = new ServerSocket(port);
		}catch(IOException e){
			e.printStackTrace();
			return;
		}
		
		isRunning = true;
		
	}
	
	//THIS METHOD ALLOWS FOR ANY COMMUNICATION BETWEEN THE SERVER AND CLIENT
	private void Communicate(){
		//THIS IS THE SERVER'S MAIN THREAD
		new Thread(new Runnable(){
			public void run(){
				DebugLog("The server has started...");
				while(isRunning){	//WHILE THE SERVER IS UP AND RUNNING
					DebugLog("Waiting for a client to connect...");
					try{
						client = socket.accept();	//LISTEN FOR A CLIENT'S CONNECTION AND ACCEPT IT
						DebugLog("A client has connected...");
						
						toClient = new DataOutputStream(client.getOutputStream());
						fromClient = new DataInputStream(client.getInputStream());
						
						
					}catch(IOException e){
						DebugLog("The client has disconnected.");
						e.printStackTrace();
						return;
					}
				}
			}
		}).start();
	}
	
	//THIS IS A METHOD USED FOR DEBUGGING PURPOSES
	//BY PRINTING MESSAGES TO THE CONSOLE
	private void DebugLog(String message){
		System.out.println(message);
	}
}



public class Payment_Service_Server {

	public static void main(String[] args) {
		Server pss = new Server();

	}

}
