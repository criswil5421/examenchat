/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.*; 
import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        ServerSocket socket;
        
          
        socket = new ServerSocket(6000);  
        Socket socket_cli = socket.accept();  
        
        DataInputStream in =
        new DataInputStream(socket_cli.getInputStream()); 
        
        DataOutputStream out =
        new DataOutputStream(socket_cli.getOutputStream());  

        String mencli1="";
        String mencli2="";
            
            String Final = null;
            
        
        
            while(!mencli1.equals("Fin")){  
                
                System.out.println("Envie mensaje: ");
                
                mencli1=in.readUTF(); 
                
                System.out.println("recibiendo mensaje: "+mencli1);  
                
                mencli2=br.readLine();  
                out.writeUTF(mencli2);  
                out.flush();  
                
                
                
                if(Final == null){
                    
                    Final = "Mensaje cliente: "+mencli1+"\n"+"Mensaje Servidor: "+mencli2+"\n";
                    
                }else{
                    
                    Final = Final +"Mensaje cliente: "+mencli1+"\n"+"Mensaje Servidor: "+mencli2+"\n";
                  
                }
            }
        
        
        int i = 1;
        String ruta = "C:/Users/Pc/Documents/NetBeansProjects/chat"+ i +".txt";
        File file = new File(ruta); 
        
        
        if (!file.exists()) {
            file.createNewFile();
        }
       
        FileWriter escribir = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(escribir);
        escribir.write(Final);
        bw.write(Final);
        
        try {                       //Cierra instancias de FileWriter y BufferedWriter
            if (bw != null)
                bw.close();
            if (escribir != null)
                escribir.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        i++;

        //FileWriter fw = new FileWriter(file);
        
        //PrintWriter wr = new PrintWriter(bw);     
        in.close();  
        socket.close();  
        socket_cli.close();
            
       
    }
    
}
