package logicafix;

import java.util.ArrayList;
import java.util.HashMap;

public class Mensaje {
    private HashMap<Integer,String> hashmap;
    private static Mensaje instancia = null;
    
    public static Mensaje getInstance(){
        if(instancia==null)
            instancia = new Mensaje();
        return instancia;
    }

    public Mensaje() {
        hashmap = new HashMap<>();
    }
    
    public Mensaje(String tipo){
        
    }
    
}
