package com.placamas.seguridad;
import java.util.Random;

public class ManejadorDeContraseñas {
    
    private Random numeroAleatorio = new Random(4);
    private final int num = 1+numeroAleatorio.nextInt(10);
    

    public String encriptarContraseña(String contraseña){
   
        char arreglo[] = contraseña.toCharArray();
        for (int i = 0; i < arreglo.length; i++) {
            
            arreglo[i] = (char)(arreglo[i]+(char)num);
            
        }
        String encriptado = String.valueOf(arreglo);
        
        return encriptado;
    }
   
    public String desentriptarContraseña(String contraseña){
        char arreglo[] = contraseña.toCharArray();
        
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (char)(arreglo[i]-(char)num);
        }
        String desencriptado = String.valueOf(arreglo);
        
        return desencriptado;
    }
    
    public static void main(String args[]){
       ManejadorDeContraseñas man =  new ManejadorDeContraseñas();
        System.out.println(""+man.encriptarContraseña("null"));;
        System.out.println(""+man.desentriptarContraseña(man.encriptarContraseña("null")));

    }
   
     
}
