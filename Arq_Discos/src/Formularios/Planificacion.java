/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Planificacion {
    
    
    public Planificacion(){
              
    }
    
    //COMPLETADO
public int[] FCFS(int cola[],int cabeza){
     int result []= new int[(cola.length)+1];
     result[0]= cabeza; 
     for (int i=1;i<(cola.length)+1;i++){
         result[i]=cola[i-1];
     }
     /*for (int numero:result)
  System.out.println(numero);*/
     
     return result; 
}
//COMPLETADO
public int[] SCAN (int cola[],int cabeza, boolean x,int cantidad){
    int tamaño= cola.length;
    
    int result []= new int[(cola.length)+2];
    
      if(x)
    {
        result[0]= cabeza; 
         result[1]=cantidad;
    }
    else{
         result[0]= cabeza; 
         result[1]=1;
    }
     
     for (int i=2;i<(cola.length)+2;i++){
         result[i]=cola[i-2];
     }
     Arrays.sort(result);
     
     int posicion=0;
     for(int i=0;i<result.length;i++){
         if(result[i]==cabeza){
         posicion=i; 
         }}  
     int contenedor= 0;
 
     if (x){        
         int [] parte1 = new int [posicion];
         int [] parte2= new int [result.length-posicion];
          parte2[0]=result[posicion];
           for(int i=1;i<result.length-posicion;i++){
                parte2[i]=result[posicion+i];
                contenedor=i;
           }
           int y=posicion-1; 
           for(int i=0;i<posicion;i++)
           {
               parte1[i]=result[y-i];
           }
             int fin []= new int[parte1.length+parte2.length];
             System.arraycopy(parte2, 0, fin, 0, parte2.length);
             System.arraycopy(parte1, 0, fin, parte2.length, parte1.length);
              /*for (int numero:fin)
              System.out.println(numero);*/
     
             return fin; 
           
     }
     else {
         int [] parte1 = new int [posicion+1];
         int [] parte2= new int [result.length-posicion-1];
         parte1[0]=result[posicion];
         int conta=1;
         for(int i=0;i<result.length-posicion-1;i++){
                parte2[i]=result[posicion+conta+i];
                contenedor=i;
           }
           int y=posicion-1; 
           for(int i=1;i<=posicion;i++)
           {
               parte1[i]=result[posicion-i];
           } 
            int fin []= new int[parte1.length+parte2.length];
            System.arraycopy(parte1, 0, fin, 0, parte1.length);
            System.arraycopy(parte2, 0, fin, parte1.length, parte2.length);
            /* for (int numero:fin)
            System.out.println(numero);*/
     
            return fin; 
     }
}
//COMPLETADO
public int[] CSCAN(int [] cola,int cabeza, boolean x, int cantidad){
 
     int tamaño= cola.length;    
    int result []= new int[(cola.length)+3];
        result[0]=cabeza; 
        result[1]=cantidad;
        result[2]=1; 
             
     for (int i=3;i<(cola.length)+3;i++){
         result[i]=cola[i-3];
     }
     Arrays.sort(result);
     int posicion=0;
     for(int i=0;i<result.length;i++){
         if(result[i]==cabeza){
         posicion=i; 
         }}  
     
     int contenedor= 0;
      if (x){        
         int [] parte1 = new int [posicion];
         int [] parte2= new int [result.length-posicion];
          parte2[0]=result[posicion];
          //System.out.println(parte2[0]);
           for(int i=1;i<result.length-posicion;i++){
                parte2[i]=result[posicion+i];
                //System.out.println(parte2[i]);
                contenedor=i;
           }
           int y=posicion-1; 
           for(int i=0;i<posicion;i++)
           {
               parte1[i]=result[i];
               //System.out.println(parte1[i]);
           }
             int fin []= new int[parte1.length+parte2.length];
             System.arraycopy(parte2, 0, fin, 0, parte2.length);
             System.arraycopy(parte1, 0, fin, parte2.length, parte1.length);
              /*for (int numero:fin)
              System.out.println(numero);*/
             return fin; 
           
     }
     else {
         int [] parte1 = new int [posicion+1];
         int [] parte2= new int [result.length-posicion-1];
         parte1[0]=result[posicion];
         //System.out.println(parte1[0]);
         int conta=1;
          int y=posicion-1; 
           for(int i=1;i<=posicion;i++)
           {
               parte1[i]=result[posicion-i];
               //System.out.println(parte1[i]);
           } 
           for(int i=0;i<result.length-posicion-1;i++){
                parte2[i]=result[result.length-1-i];
                //System.out.println(parte2[i]);
                contenedor=i;
           }
            int fin []= new int[parte1.length+parte2.length];
            System.arraycopy(parte1, 0, fin, 0, parte1.length);
            System.arraycopy(parte2, 0, fin, parte1.length, parte2.length);
            /* for (int numero:fin)
            System.out.println(numero); */
            return fin; 
     }
}
//COMPLETADO
public int[] CLOOK (int [] cola,int cabeza, boolean x, int cantidad){

    int result []= new int[(cola.length)+1];
       
        result[0]= cabeza; 
     for (int i=1;i<(cola.length)+1;i++){
         result[i]=cola[i-1];
     }
     Arrays.sort(result);
     
     int posicion=0;
     for(int i=0;i<result.length;i++){
         if(result[i]==cabeza){
         posicion=i; 
         }}  
     int contenedor= 0;
 
     if (x){        
         int [] parte1 = new int [posicion];
         int [] parte2= new int [result.length-posicion];
          parte2[0]=result[posicion];
          //System.out.println(parte2[0]);
           for(int i=1;i<result.length-posicion;i++){
                parte2[i]=result[posicion+i];
               // System.out.println(parte2[i]);
                contenedor=i;
           }
           int y=posicion-1; 
           for(int i=0;i<posicion;i++)
           {
               parte1[i]=result[i];
              // System.out.println(parte1[i]);
           }
             int fin []= new int[parte1.length+parte2.length];
             System.arraycopy(parte2, 0, fin, 0, parte2.length);
             System.arraycopy(parte1, 0, fin, parte2.length, parte1.length);
              /*for (int numero:fin)
              System.out.println(numero);*/
     
             return fin; 
           
     }
     else {
         int [] parte1 = new int [posicion+1];
         int [] parte2= new int [result.length-posicion-1];
         parte1[0]=result[posicion];
         //System.out.println(parte1[0]);
         int conta=1;
         int y=posicion-1; 
           for(int i=1;i<=posicion;i++)
           {
               parte1[i]=result[posicion-i];
               //System.out.println(parte1[i]);
           } 
         for(int i=0;i<result.length-posicion-1;i++){
                parte2[i]=result[result.length-1-i];
                //System.out.println(parte2[i]);
                contenedor=i;
           }
           
            int fin []= new int[parte1.length+parte2.length];
            System.arraycopy(parte1, 0, fin, 0, parte1.length);
            System.arraycopy(parte2, 0, fin, parte1.length, parte2.length);
             /*for (int numero:fin)
            System.out.println(numero);*/
     
            return fin; 
     }  
}

public int[] SSTF (int[] cola,int cabeza){
    int result []= new int[(cola.length)+1];      
        result[0]= cabeza; 
     for (int i=1;i<(cola.length)+1;i++){
         result[i]=cola[i-1];
     }
     Arrays.sort(result);
     
     int posicion=0;
     for(int i=0;i<result.length;i++){
         if(result[i]==cabeza){
         posicion=i; 
         }}  
     
     int fin[]=new int[result.length];
     
     fin[0]=result[posicion];
//     System.out.println(fin[0]);
     int x= calculo(result[posicion],cola);
     
     
   for (int i=1;i<result.length;i++)
     {
      fin[i]=calculo(fin[i-1],cola);
       for (int p=0;p<cola.length;p++)
       {if(fin[i]==cola[p]){
       cola[p]=Integer.MAX_VALUE;
       }
       }
      //System.out.println(fin[i]);
     }
     
     return fin; 
}

public int calculo (int x,int [] cola){
 
     int cercano = 0;
        int diferencia = Integer.MAX_VALUE; //inicializado valor máximo de variable de tipo int
        for (int i = 0; i < cola.length; i++) {
            if (cola[i] == x) {
                return cola[i];
            } else {
                if(Math.abs(cola[i]-x)<diferencia){
                    cercano=cola[i];
                    diferencia = Math.abs(cola[i]-x);
                }
            }
        }
        return cercano;
      
}
    
}