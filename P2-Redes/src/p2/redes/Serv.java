/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.redes;

import java.net.*;
import java.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author gseno
 */
public class Serv {
    private int port = 6969;
    private String ipAdrr= "";
    private Socket s = null;
    private ServerSocket ss;
    private InputStream in;
    private OutputStream out;
        private BlockingQueue<Runnable> listaTareas ;
    private ThreadPoolExecutor executor;
    
    
    public Serv(String address, int puerto){
        try{
            
            
            listaTareas = new LinkedBlockingDeque<>(17);
            executor = new ThreadPoolExecutor(7, 7, 50, TimeUnit.SECONDS, listaTareas);
            ss = new ServerSocket(puerto);
            s=null;
            while(true){
                this.s = ss.accept();
                this.out = new ObjectOutputStream(s.getOutputStream());
                this.in = new ObjectInputStream(s.getInputStream());
                
                executor.execute(new P2Redes(s));
            }
        }catch(IOException ex){System.out.println(ex.getMessage());
        }finally{
            try{
                if(this.out!=null) this.out.close();
                if(this.in!=null) this.in.close();
                if(this.s!=null) this.s.close();
                this.out=null;
                this.in=null;
                this.s=null;
            }catch(IOException ex){System.out.println(ex.getMessage());}
        }
        
    }
    
    public void main(){
       
        
    }
    
   
        
        
        
}
    
    
    
    
    
    
    

