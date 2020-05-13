/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.*;
import java.io.*;
/**
 *
 * @author Pc
 */
public class Chat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
        Socket socket;
        
        String mencli1="";
        String mencli2="";  
        
               
        socket = new Socket("localhost",6000);  
        
        DataInputStream in =
        new DataInputStream(socket.getInputStream());  
        
        DataOutputStream out =
        new DataOutputStream(socket.getOutputStream()); 
    
        
        
        while(!mencli1.equals("Fin")){ 
            
            System.out.println("Envie mensaje: ");
            
            mencli1=br.readLine();
            
            out.writeUTF(mencli1); 
            
            out.flush();  
            
            mencli2=in.readUTF();  
            
            System.out.println("recibiendo mensaje: "+mencli2); 

        }  
        
        out.close(); 
        socket.close(); 
              
    } 

}

