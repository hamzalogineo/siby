/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utpasibycenter;

import frontend.Conexion;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 *
 * @author HAMZA
 */



public class UtpaSibyCenter {

    public static File f ;
    public static FileChannel channel ;
   public static FileLock lock ;
    
    public static void main(String[] args) {
        
              //  Conexion cn = new Conexion() ;
                //    cn.setVisible(true) ;
                    
                    
        
        try{
            
            f = new File("key") ;
            
            if(f.exists()){
                f.delete() ;
            }
            
            channel = new RandomAccessFile(f, "rw").getChannel() ;
            lock = channel.tryLock() ;
            
            if(lock == null){
                
                channel.close();
                throw new RuntimeException("Only one instance of this programme can used at time thank") ;
                
            }
            
            Thread shutdown = new Thread(new Runnable()
            {
              @Override
              public void run(){
                  
                    unlock() ;
                  
                   
              }
                
            
            });
            
            Runtime.getRuntime().addShutdownHook(shutdown) ;
            
            System.out.println("This programm is running ..... ..") ;
            
             
                    Conexion cn = new Conexion() ;
                    cn.setVisible(true) ;
            
            
            
            while(true){
                
            }
            
            
        }catch(IOException ex){
            
            throw new RuntimeException("UNE INSTANCE EST DEJA EN COURS : " , ex) ;
            
        }
        
    
        
      
        
         
    
    }  // end main
    
    
    
    public static void unlock(){
        try{
            
            if(lock != null){
                
                lock.release() ;
                channel.close() ;
                f.delete() ;
                
            }
            
            
        }catch(IOException ex){
            ex.printStackTrace() ;
             throw new RuntimeException("UNE INSTANCE EST DEJA EN COURS unlock : " , ex) ;
        }
    }
    
} // end class





/*

public class UtpaSibyCenter {
      public static void main(String[] args) {
          
          Conexion cn = new Conexion() ;
                   cn.setVisible(true) ;
          
      }
    
    
}


*/