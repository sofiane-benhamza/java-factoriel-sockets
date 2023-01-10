import java.io.*;
import java.net.*;
import java.util.*;
public class Client{
private static InetAddress host;
private static final int PORT = 2843;
public static void main(String[] args){
 try{
      host = InetAddress.getLocalHost();
    		  // ip address of the server
}catch(UnknownHostException uhEx){
      System.out.println("Host ID not found!");  
      System.exit(1);
}
accessServer();
}    //finish main

private static void accessServer(){
Socket link = null;
//Step 1.
try{
link = new Socket(host,PORT);
System.out.println("connection established");
//Step 1.
Scanner input =new Scanner(link.getInputStream());
//Step 2.
PrintWriter output =new PrintWriter(link.getOutputStream(),true);
//Step 2.
//Set up stream for keyboard entry...
      System.out.println("\t --- Factoriel Calculator ---\n");
Scanner userEntry = new Scanner(System.in);
long number , response;

do{   
      System.out.print("Enter message: ");
      number = userEntry.nextLong();
      output.println(number);
//Step 3.
      response = input.nextLong(); //Step 3.
       System.out.println("\nSERVER> "+response);
}while ( number != -1);
}catch(IOException ioEx){
ioEx.printStackTrace();
}finally{
	try{
                System.out.println("\n* Closing connection... *");
                link.close();
//Step 4.
      }catch(IOException ioEx){
            System.out.println("Unable to disconnect!");
            System.exit(1);
     }
}
}
}
