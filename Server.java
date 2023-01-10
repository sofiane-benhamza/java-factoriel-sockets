// Le serveur
import java.io.*;
import java.net.*;
import java.util.*;
public class Server{
	
private static ServerSocket serverSocket;
private static final int PORT = 2843;

public static void main(String[] args){
	
System.out.println("Opening port...\n");
try{
           serverSocket = new ServerSocket(PORT);//Step 1.

}catch(IOException ioEx){
	       System.out.println("Unable to attach to port!");   
               System.exit(1);
}

do{
handleClient();
}while (true);

} //finish main

private static void handleClient(){
Socket link = null;
//Step 2.
try{
      link = serverSocket.accept();
//Step 2.
      Scanner input = new Scanner(link.getInputStream());//Step 3.
      PrintWriter output = new PrintWriter(link.getOutputStream(),true); //Step 3.

       int nbr = input.nextInt();
//Step 4.
       while (true){
       System.out.println("Integer received.");
       output.println(fact(nbr)); //Step 4. 
       nbr = input.nextInt(); 
       }
     }catch(IOException ioEx){
          ioEx.printStackTrace();
      }finally{
              try {
                     System.out.println("\n* Closing connection... *");
                     link.close();
//Step 5.
                    }catch(IOException ioEx){
                     System.out.println("Unable to disconnect!");
                    System.exit(1);
                  }
                }
}

public static long fact(int n) {
	if(n == 1) {
		return 1;
    }else {
    	return n*fact(n-1);
    }
}
}
