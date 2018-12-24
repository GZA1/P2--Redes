/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.redes;



import java.io.*;
import java.net.*;

/**
 *
 * @author gseno
 */
public class P2Redes implements Runnable{

    private Socket s = null;
    private InputStream in;
    private OutputStream out;
    
    
    public P2Redes(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
      try{
          
        out = s.getOutputStream();
        in = s.getInputStream();
        byte[] buff = new byte[64];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int nb = -1;
        while(nb>0){
            nb = in.read(buff, 0, 64);
            baos.write(buff);   
        }
        
        
        parseMsg(baos);
      }catch(Exception ex){System.out.println(ex.getMessage());}
      
        
    }
    
    private void parseMsg(ByteArrayOutputStream baos){
        
        
    }
    private void logON(){
        
    }
    private void logOUT(){
        
        
    }
    private void heartBeat(){
        
        
    }
    
    
    
}
