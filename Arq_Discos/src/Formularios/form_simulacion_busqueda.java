/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class form_simulacion_busqueda extends javax.swing.JFrame {

    /**
     * Creates new form formPrincipal
     */
    public form_simulacion_busqueda() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/diskIcon.png")).getImage());
        //inicialiar componentes 
         tableDatosD.setVisible(true);
        tableDatosD.setEnabled(false);
        lblPivote.setVisible(false);
        //crear instancia de form tiempo de busqueda para traer datos
        form_tiempo_busqueda datosFB=new form_tiempo_busqueda();
        //llamado a funcion para mostrar proceso al usuario
        mostrarSimulacion(datosFB);
        
        
                        
        // pack();
    }
    
    
//mensaje a ir mostrando durante la carga
        String mensaje="";

    //funcion para mostrar datos
    private  void mostrarSimulacion(form_tiempo_busqueda datosFB){

        //valida que datos usar si fueron para datos rps
            
            cargarBarraRPS(datosFB);

        //si son datos con calculo en rpm
        
       
    }
    
    //Funcion para mostrar mensaje de accion realizada actualmente
    private void mostrarMensaje(String mensaje){
        //lblProcesoAct.setText(mensaje);

               lblProcesoAct.setText(mensaje);     
    }
    //Funcion para mover barra de carga
    private  void cargarBarraRPS(form_tiempo_busqueda datosFB){
        
        //Creacion de hilo para que se visualize carga de barra
            Thread hilo1 = new Thread(){
            @Override
            public void run(){
                DecimalFormat df=new DecimalFormat("#.0000");
                for(int i=1;i<=100;i++){
                    try{
                        Thread.sleep(300);
                        progressB.setValue(i);
                        
                    }catch (InterruptedException ex){
                        Logger.getLogger(form_simulacion_busqueda.class.getName()).log(Level.SEVERE,null,ex);
                    }
                    if(progressB.getValue()<=10){
                        //tiempo de rotacion en ms
                    mensaje="El tiempo de rotacion= "+df.format(datosFB.tR)+"ms";
                    mostrarMensaje(mensaje);
                    }
                    if(progressB.getValue()>10&progressB.getValue()<=20){
                      
                    //sectores por cilindro
                    mensaje="El cálculo de sectores por cilindro= "+datosFB.secC+" Sectores/cilindro";
                    mostrarMensaje(mensaje);
                    }
                    if(progressB.getValue()>20&progressB.getValue()<=25){
                        //Cilindro donde se encuentra la direccioón1
                    mensaje="El cilindro donde se encuentra la dirección inicial "+datosFB.dirI+" es: "+datosFB.cD1;
                    mostrarMensaje(mensaje);
                    }
                    if(progressB.getValue()>25&progressB.getValue()<=30){
                        //La cabeza donde se encuentra la direccioón1
                    mensaje="La cabeza donde se encuentra la dirección inicial "+datosFB.dirI+" es: "+datosFB.headD1;
                    mostrarMensaje(mensaje);
                    }
                    if(progressB.getValue()>30&progressB.getValue()<=35){
                        //El sector donde se encuentra la direccioón1
                    mensaje="El sector donde se encuentra la dirección inicial "+datosFB.dirI+" es: "+datosFB.secD1;
                    mostrarMensaje(mensaje);
                    }
                    //Colocar datos direccion inicial en la tabla
                    if(progressB.getValue()==36){
                       //Colocar datos en tabla
                    insertarDatosTableD1(datosFB);
                    }
                    
                    //realizar mismo proceso direccion de destion
                    if(progressB.getValue()>36&progressB.getValue()<=40){
                        //Cilindro donde se encuentra la direccioón2
                    mensaje="El cilindro donde se encuentra la dirección destino "+datosFB.dirF+" es: "+datosFB.cD2;
                    mostrarMensaje(mensaje);
                    }
                    if(progressB.getValue()>40&progressB.getValue()<=45){
                        //La cabeza donde se encuentra la direccioón2
                    mensaje="La cabeza donde se encuentra la dirección destino "+datosFB.dirF+" es: "+datosFB.headD2;
                    mostrarMensaje(mensaje);
                    }
                    if(progressB.getValue()>45&progressB.getValue()<=50){
                        //El sector donde se encuentra la direccioón2
                    mensaje="El sector donde se encuentra la dirección destino "+datosFB.dirF+" es: "+datosFB.secD2;
                    mostrarMensaje(mensaje);
                    }
                    
                    //Colocar datos direccion destino en la tabla
                    if(progressB.getValue()==80){
                       //Colocar datos en tabla
                    insertarDatosTableD2(datosFB);
                   
                    
                    }
                    //dibujar cabeza inicial
                    if(progressB.getValue()==55){
                        dibujarCabezaInicial(datosFB);
                    }
                    //Dibujar cilindro inicial
                    if(progressB.getValue()==60){
                        dibujarCilindroInicial(datosFB);
                                          
                    }
                    //Mostrar Pista 1
                    if(progressB.getValue()==85){
                        
                           dibujarCabezaFinal(datosFB);                                 
                    }
                    if(progressB.getValue()==90){
                        
                           dibujarCilindroFinal(datosFB);                                 
                    }
                    if(progressB.getValue()==95){
                        
                           lblTT.setText("Tiempo total para cumplir el pedido:");  
                           lblFormula.setText("T=tiempo de cilindro a cilindro+ recorrido de sectores"); 
                    }
                    if(progressB.getValue()==100){
                        
                           lblResultado.setText("T= "+datosFB.tBP+"ms +"+datosFB.tTotRS+"ms = "+datosFB.tTotD1D2+"ms");
                    }
                    
                }
            }
            
        };
        hilo1.start();
    }
    
    private void insertarDatosTableD1(form_tiempo_busqueda datosFB){
        DefaultTableModel modelo = (DefaultTableModel) tableDatosD.getModel();  

        Object [] fila1=new Object[4]; 
         fila1[0]=datosFB.dirI; 
        fila1[1]=datosFB.cD1;
        fila1[2]=datosFB.headD1; 
        fila1[3]=datosFB.secD1; 
        modelo.addRow(fila1); 
        
        this.tableDatosD.setModel(modelo); 
        //mostrar Pista direccion inicial
         this.mostrarPista1.setLayout(new BorderLayout());
          this.mostrarPista1.add(new TestPaneI(datosFB));
        
  
        
    }
    private void insertarDatosTableD2(form_tiempo_busqueda datosFB){
        DefaultTableModel modelo = (DefaultTableModel) tableDatosD.getModel();  
        Object [] fila2=new Object[4]; 
         fila2[0]=datosFB.dirF; 
        fila2[1]=datosFB.cD2;
        fila2[2]=datosFB.headD2; 
        fila2[3]=datosFB.secD2; 
        modelo.addRow(fila2); 
        this.tableDatosD.setModel(modelo); 
                //mostrar Pista direccion inicial
         this.mostrarPista2.setLayout(new BorderLayout());
          this.mostrarPista2.add(new TestPaneII(datosFB));
    }
    //dibujar representacion de cabeza Inicial
    private void dibujarCabezaInicial( form_tiempo_busqueda datosFB){
        Graphics2D cabeza=(Graphics2D)this.mostrarCabeza.getGraphics();
        cabeza.setStroke(new BasicStroke(10.f));
        cabeza.setPaint(Color.green);
        cabeza.fillOval(10, 2, 60, 60);//orden xpanel,ypanel,grande segun radio,igual al anterior
        lblUH.setText("Al iniciar la dirección "+datosFB.dirI+" se encuentra en la cabeza "+datosFB.headD1);
    }
    //Dibujar Cilindro direccion Inicial
        private void dibujarCilindroInicial(form_tiempo_busqueda datosFB ){
        Graphics2D cabeza=(Graphics2D)this.cilindroP.getGraphics();
        cabeza.setStroke(new BasicStroke(10.f));
        cabeza.setPaint(Color.blue);
        cabeza.drawOval(10, 5, 50, 50);//orden xpanel,ypanel,grande segun radio,igual al anterior
        lblUC.setText("En la cabeza "+datosFB.headD1+" la direccion se encuentra en su cilindro "+datosFB.cD1);
                
        }
        
            //dibujar representacion de cabeza Final
    private void dibujarCabezaFinal( form_tiempo_busqueda datosFB){
        Graphics2D cabeza=(Graphics2D)this.mostrarCabeza.getGraphics();
        cabeza.setStroke(new BasicStroke(10.f));
        cabeza.setPaint(Color.pink);
        cabeza.fillOval(10, 2, 60, 60);//orden xpanel,ypanel,grande segun radio,igual al anterior
        lblUH.setText("Al iniciar la dirección "+datosFB.dirF+" se encuentra en la cabeza "+datosFB.headD2);
    }
    //Dibujar Cilindro direccion Final
        private void dibujarCilindroFinal(form_tiempo_busqueda datosFB ){
        Graphics2D cabeza=(Graphics2D)this.cilindroP.getGraphics();
        cabeza.setStroke(new BasicStroke(10.f));
        cabeza.setPaint(Color.green);
        cabeza.drawOval(10, 5, 50, 50);//orden xpanel,ypanel,grande segun radio,igual al anterior
        lblUC.setText("En la cabeza "+datosFB.headD2+" la direccion se encuentra en su cilindro "+datosFB.cD2);
                
        }
        
        //Dibujar pista con sectores
 

        public class TestPaneI extends JPanel {

        public TestPaneI(form_tiempo_busqueda datosFB) {
            
                Thread hilo2 = new Thread(){
            @Override
            public void run(){
                //bandera para cambio al moverse demasiados sectores
                boolean cambio=false;
                            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
                for (int row = 0; row < 1; row++) {
                    try{
                for (int col = 0; col < datosFB.cantS; col++) {
                    
                        Thread.sleep(50);
                        gbc.gridx = col;
                        gbc.gridy = row;

                    CellPane cellPane = new CellPane(datosFB);
                    Border border = null;
                    if (row < 0) {
                        if (col < datosFB.cantS-1) {
                            border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                        }
                    } else {
                        if (col < datosFB.cantS-1) {
                            border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                        }
                    }
                    
                    
                    //validar si el recorrdio mientras cambia de cilindro se desbordo
                    if(datosFB.secD1Mov>datosFB.cantS){
                        //pintar y mostrar el total de recorrido
                        //colocar donde se encuentra el sector 1
                         if (col==datosFB.secD1-1&cambio==false){                        
                            cellPane.setBackground(Color.BLUE);
                            lblDatosP1.setText("<html>(AZUL) El sector("+datosFB.secD1+") actual de "+datosFB.dirI+", <br>(ROJO) sectores movidos("+datosFB.cantSR+") al pasar al cilindo de la dirección "+datosFB.dirF+", <br>(AMARILLO) sector nuevo de cabeza R/W("+datosFB.secRest+"), Al sobrepasar el maximo de sectores que podia recorrer esto equivalio a dar "+datosFB.cantVueltas+" vuelta/s al disco antes de llegar al nuevo cilindro</html>");
                        lblPivote.setText(""+col);
                         }   
                    
                        if(cambio==false){
                            if(col>datosFB.secD1-1){
                                if(col==datosFB.cantS-1){
                                cellPane.setBackground(Color.RED);
                                
                                col=-1;
                                cambio=true;
                                lblPivote.setText(""+col);
                            }else{
                                cellPane.setBackground(Color.RED);
                           // lblDatosP1.setText("El sector actual donde se encuentra la direccion "+datosFB.dirI+" es: "+datosFB.secD1+" (AZUL), (ROJO) representa sectores movidos al pasar al cilindo de la direccion "+datosFB.dirF+" (AMARILLO) es el sector donde termian luego de este movimiento");
                                }
                                
                                } 
                            
                              
                        }else{
                           if(cambio==true){     
                         if(col==datosFB.secRest-1){     
                        cellPane.setBackground(Color.yellow);
                         //lblDatosP1.setText("El sector actual donde se encuentra la direccion "+datosFB.dirI+" es: "+datosFB.secD1+" (AZUL), (ROJO) representa sectores movidos al pasar al cilindo de la direccion "+datosFB.dirF+" (AMARILLO) es el sector donde termian luego de este movimiento");
                        }
                             if(col<datosFB.secRest-1||col==datosFB.cantS){ 
                                 cellPane.setBackground(Color.RED);
                                 lblPivote.setText(""+col);
                             }
                             /*if(col==datosFB.secD1-1){ 
                                 Color defaultBackground = getBackground();
                                 cellPane.setBackground(defaultBackground);
                                 
                             }*/

                             
                             
                         
                       } 
                        }
                       //Si no se desborda
                    }else{
                        if (col==datosFB.secD1-1){                        
                        cellPane.setBackground(Color.BLUE);
                        lblDatosP1.setText("<html>(AZUL) El sector("+datosFB.secD1+") actual de "+datosFB.dirI+", <br>(ROJO) sectores movidos("+datosFB.cantSR+") al pasar al cilindo de la dirección "+datosFB.dirF+", <br>(AMARILLO) sector nuevo de cabeza R/W("+datosFB.secD1Mov+")</html>");
                    }
                        //si el recorrido era menor
                    if(col>=datosFB.secD1&col<datosFB.secD1Mov){
                        cellPane.setBackground(Color.RED);
                        //lblDatosP1.setText("Mientras la cabeza R/W pasaba del cilindro "+datosFB.cD1+" al "+datosFB.cD2+" se recorrieron "+datosFB.cantSR+" sectores"+"(ROJO)");
                    }
                    if(col==datosFB.secD1Mov-1){
                        cellPane.setBackground(Color.yellow);
                         //lblDatosP1.setText("Por lo tanto el nuevo sector donde se encuentra la cabeza R/W es "+datosFB.secD1Mov+"(AMARILLO)");
                    }
                    }
                    
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                        
                    }
                    }catch (InterruptedException ex){
                        Logger.getLogger(form_simulacion_busqueda.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            }
                };
                hilo2.start();   
            
        }
    } 
        //Insertar pista 2
         public class TestPaneII extends JPanel {

        public TestPaneII(form_tiempo_busqueda datosFB) {
            
                Thread hilo3 = new Thread(){
            @Override
            public void run(){
                //Bandera para conocer si ya se encontraron el sector al que se quiere llegar y en el que se estaba
                boolean encontrados=false;
                            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
                for (int row = 0; row < 1; row++) {
                    try{
                for (int col = 0; col < datosFB.cantS; col++) {
                    
                        Thread.sleep(10);
                        gbc.gridx = col;
                        gbc.gridy = row;

                    CellPane cellPane = new CellPane(datosFB);
                    Border border = null;
                    if (row < 0) {
                        if (col < datosFB.cantS-1) {
                            border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                        }
                    } else {
                        if (col < datosFB.cantS-1) {
                            border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                        }
                    }
                    //Mostrar sector donde se encuentra
                    if (col==datosFB.secD2-1){                        
                        cellPane.setBackground(Color.BLUE);
                        //lblDatosP2.setText("El sector actual donde se encuentra la direccion "+datosFB.dirF+" es: "+datosFB.secD2+"(AZUL)");
                    }
                    //Validar si deben usarse variable desbordada o no
                    if(datosFB.secD1Mov>datosFB.cantS){
                            //Validar si debe pintarse hacia adelante o hacia atras
                            //si el DF esta adelante del DI
                    if(datosFB.secRest>datosFB.secD2){
                        
                        if(encontrados==false){
                            if(col==datosFB.secRest-1){
                                cellPane.setBackground(Color.yellow);
                                lblDatosP2.setText("<html>(AMARILLO) Sector ("+datosFB.secRest+") donde se encuentra la cabeza R/W, <br> (VERDE) cantidad de sectores ("+datosFB.totSecR+")por moverse la cabeza R/W para llegar al destino, <br> (AZUL) sector de destino donde se encuentra la direccion "+datosFB.dirF+" </html>");
                                
                            }else{
                                if(col==datosFB.cantS-1){
                                col=-1;
                                 encontrados=true;
                            }
                                //lblDatosP2.setText("Mientras la cabeza R/W pasaba del cilindro "+datosFB.cD1+" al "+datosFB.cD2+" se recorrieron "+datosFB.secD1Mov+" sectores");
                            }
                        }else{
                            if(encontrados==true){
                                if(col>=datosFB.secRest||col<datosFB.secD2-1){
                                    cellPane.setBackground(Color.green);
                                   // lblDatosP2.setText("El color verde representa los sectores que recorrio hasta llegar al destino: "+datosFB.totSecR+"(AMARILLO)");
                                lblPivote.setText(""+col);
                                } 
                                if(col==datosFB.secRest-1){
                                    cellPane.setBackground(Color.yellow);
                                    lblPivote.setText(""+col);
                                }
                            }
                            
                        }
                    }
                    //si el DF esta detras del DI
                    if(datosFB.secRest<datosFB.secD2){
                        if(encontrados==false){
                            if(col==datosFB.secRest-1){
                                cellPane.setBackground(Color.yellow);
                                lblDatosP2.setText("<html>(AMARILLO) Sector ("+datosFB.secRest+") donde se encuentra la cabeza R/W, <br> (VERDE) cantidad de sectores ("+datosFB.totSecR+")por moverse la cabeza R/W para llegar al destino, <br> (AZUL) sector de destino donde se encuentra la direccion "+datosFB.dirF+" </html>");//lblDatosP2.setText("La cantidad de sectores por moverse la cabeza R/W para llegar al destino son: "+datosFB.totSecR);
                                lblPivote.setText(""+col);
                            }else{
                                if(col==datosFB.cantS-1){
                                col=-1;
                                 encontrados=true;
                            }
                                //lblDatosP2.setText("Mientras la cabeza R/W pasaba del cilindro "+datosFB.cD1+" al "+datosFB.cD2+" se recorrieron "+datosFB.secD1Mov+" sectores"+"(VERDE)");
                            }
                        }else{
                            if(encontrados==true){
                                if(col>=datosFB.secRest&col<datosFB.secD2-1){
                                    cellPane.setBackground(Color.green);
                                   // lblDatosP2.setText("El color verde representa los sectores que recorrio hasta llegar al destino: "+datosFB.totSecR+"(AMARILLO)");
                                lblPivote.setText(""+col);
                                }
                                if(col==datosFB.secRest-1){
                                    cellPane.setBackground(Color.yellow);
                                    lblPivote.setText(""+col);
                                }
                            }
                            
                        }
                    }
                    //Si estan en la misma dirección
                    if(datosFB.secRest==datosFB.secD2){
                        if(col==datosFB.secRest-1){
                                cellPane.setBackground(Color.PINK);
                                lblDatosP2.setText("(PINK)Ambas direcciones estan en el mismo sector asi que no hay mas movimiento");
                    lblPivote.setText(""+col);
                        }
                    
                    }
                    //Sino se desbordo
                    }else{
                        //Validar si debe pintarse hacia adelante o hacia atras
                            //si el DF esta adelante del DI
                    if(datosFB.secD1Mov>datosFB.secD2){
                        
                        if(encontrados==false){
                            if(col==datosFB.secD1Mov-1){
                                cellPane.setBackground(Color.yellow);
                                lblDatosP2.setText("<html>(AMARILLO) Sector ("+datosFB.secD1Mov+") donde se encuentra la cabeza R/W, <br> (VERDE) cantidad de sectores ("+datosFB.totSecR+") por moverse la cabeza R/W para llegar al destino, <br> (AZUL) sector de destino donde se encuentra la direccion "+datosFB.dirF+"</html>");
                                lblPivote.setText(""+col);
                            }else{
                                if(col==datosFB.cantS-1){
                                col=-1;
                                 encontrados=true;
                            }
                                //lblDatosP2.setText("Mientras la cabeza R/W pasaba del cilindro "+datosFB.cD1+" al "+datosFB.cD2+" se recorrieron "+datosFB.secD1Mov+" sectores"+"(VERDE)");
                            }
                        }else{
                            if(encontrados==true){
                                if(col>=datosFB.secD1Mov||col<datosFB.secD2-1){
                                    cellPane.setBackground(Color.green);
                                    //lblDatosP2.setText("El color verde representa los sectores que recorrio hasta llegar al destino: "+datosFB.totSecR+"(AMARILLO)");
                                lblPivote.setText(""+col);
                                }
                                if(col==datosFB.secD1Mov-1){
                                    cellPane.setBackground(Color.yellow);
                                    lblPivote.setText(""+col);
                                }
                            }
                            
                        }
                    }
                    //si el DF esta detras del DI
                    if(datosFB.secD1Mov<datosFB.secD2){
                        if(encontrados==false){
                            if(col==datosFB.secD1Mov-1){
                                cellPane.setBackground(Color.yellow);
                                lblDatosP2.setText("<html>(AMARILLO) Sector ("+datosFB.secD1Mov+") donde se encuentra la cabeza R/W, <br> (VERDE) cantidad de sectores ("+datosFB.totSecR+") por moverse la cabeza R/W para llegar al destino, <br> (AZUL) sector de destino donde se encuentra la direccion "+datosFB.dirF+"</html>");
                                
                            }else{
                                if(col==datosFB.cantS-1){
                                col=-1;
                                 encontrados=true;
                            }
                                //lblDatosP2.setText("Mientras la cabeza R/W pasaba del cilindro "+datosFB.cD1+" al "+datosFB.cD2+" se recorrieron "+datosFB.secD1Mov+" sectores");
                            }
                        }else{
                            if(encontrados==true){
                                if(col>=datosFB.secD1Mov&col<datosFB.secD2-1){
                                    cellPane.setBackground(Color.green);
                                   // lblDatosP2.setText("El color verde representa los sectores que recorrio hasta llegar al destino: "+datosFB.totSecR);
                                lblPivote.setText(""+col);
                                }
                                if(col==datosFB.secD1Mov-1){
                                    cellPane.setBackground(Color.yellow);
                                    lblPivote.setText(""+col);
                                }
                            }
                            
                        }
                    }
                    //Si estan en la misma dirección
                    if(datosFB.secD1Mov==datosFB.secD2){
                        if(col==datosFB.secD1Mov-1){
                                cellPane.setBackground(Color.PINK);
                                lblDatosP2.setText("(PINK) Ambas direcciones estan en el mismo sector asi que no hay mas movimiento");
                    lblPivote.setText(""+col);
                        }
                    }
                    }
                    
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                        
                    }
                    }catch (InterruptedException ex){
                        Logger.getLogger(form_simulacion_busqueda.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            }
                };
                hilo3.start();   
            
        }
    }
    
         
         public class CellPane extends JPanel {

        private Color defaultBackground;

        public CellPane(form_tiempo_busqueda datosFB) {
                    /*defaultBackground = getBackground();
                    setBackground(Color.BLUE);
                    setBackground(defaultBackground);*/
      
        }
        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(20, 20);
        }
    
         }
         

         

         

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        progressB = new javax.swing.JProgressBar();
        lblProcesoAct = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDatosD = new javax.swing.JTable();
        cilindroP = new javax.swing.JPanel();
        mostrarCabeza = new javax.swing.JPanel();
        lblUH = new javax.swing.JLabel();
        lblUC = new javax.swing.JLabel();
        mostrarPista1 = new javax.swing.JPanel();
        lblDatosP1 = new javax.swing.JLabel();
        mostrarPista2 = new javax.swing.JPanel();
        lblDatosP2 = new javax.swing.JLabel();
        lblPivote = new javax.swing.JLabel();
        lblTT = new javax.swing.JLabel();
        lblFormula = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(34, 40, 49));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(34, 40, 49));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Planificacion.png"))); // NOI18N
        jLabel2.setText("Algoritmo planificación");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 50));

        jLabel10.setBackground(new java.awt.Color(83, 187, 180));
        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Selección de opciones");
        jLabel10.setOpaque(true);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 40));

        jLabel11.setBackground(new java.awt.Color(34, 40, 49));
        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/team-work_88989.png"))); // NOI18N
        jLabel11.setText("Equipo");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 250, 50));

        jLabel12.setBackground(new java.awt.Color(34, 40, 49));
        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Disco.png"))); // NOI18N
        jLabel12.setText("Tiempo de busqueda");
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 250, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 510));

        jPanel3.setBackground(new java.awt.Color(83, 184, 187));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1010, 40));

        progressB.setStringPainted(true);

        tableDatosD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Direcciones", "Cilindro", "Cabeza", "Sector"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDatosD.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableDatosD);
        if (tableDatosD.getColumnModel().getColumnCount() > 0) {
            tableDatosD.getColumnModel().getColumn(0).setResizable(false);
            tableDatosD.getColumnModel().getColumn(1).setResizable(false);
            tableDatosD.getColumnModel().getColumn(2).setResizable(false);
            tableDatosD.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout cilindroPLayout = new javax.swing.GroupLayout(cilindroP);
        cilindroP.setLayout(cilindroPLayout);
        cilindroPLayout.setHorizontalGroup(
            cilindroPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        cilindroPLayout.setVerticalGroup(
            cilindroPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mostrarCabezaLayout = new javax.swing.GroupLayout(mostrarCabeza);
        mostrarCabeza.setLayout(mostrarCabezaLayout);
        mostrarCabezaLayout.setHorizontalGroup(
            mostrarCabezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        mostrarCabezaLayout.setVerticalGroup(
            mostrarCabezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mostrarPista1Layout = new javax.swing.GroupLayout(mostrarPista1);
        mostrarPista1.setLayout(mostrarPista1Layout);
        mostrarPista1Layout.setHorizontalGroup(
            mostrarPista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mostrarPista1Layout.setVerticalGroup(
            mostrarPista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        lblDatosP1.setAutoscrolls(true);

        javax.swing.GroupLayout mostrarPista2Layout = new javax.swing.GroupLayout(mostrarPista2);
        mostrarPista2.setLayout(mostrarPista2Layout);
        mostrarPista2Layout.setHorizontalGroup(
            mostrarPista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mostrarPista2Layout.setVerticalGroup(
            mostrarPista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        lblDatosP2.setAutoscrolls(true);

        lblPivote.setText("jLabel3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(642, 642, 642)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressB, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProcesoAct, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTT, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(lblFormula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(mostrarCabeza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(cilindroP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPivote)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblUH, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                        .addComponent(lblUC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostrarPista1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mostrarPista2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblDatosP1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblDatosP2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(progressB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPivote))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblProcesoAct, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDatosP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblTT, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFormula, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(mostrarCabeza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUC, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mostrarPista1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(lblDatosP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(cilindroP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(mostrarPista2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(587, 587, 587)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 1010, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setBackground(new Color (34,40,49));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setBackground(new Color (83,187,180));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setBackground(new Color (83,187,180));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
       jLabel11.setBackground(new Color (34,40,49));
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
      jLabel12.setBackground(new Color (83,187,180));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setBackground(new Color (34,40,49));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
      //Vacio. 
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        form_tiempo_busqueda form= new form_tiempo_busqueda();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
         form_algoritmo_planificacion form= new form_algoritmo_planificacion();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_simulacion_busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_simulacion_busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_simulacion_busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_simulacion_busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_simulacion_busqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cilindroP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDatosP1;
    private javax.swing.JLabel lblDatosP2;
    private javax.swing.JLabel lblFormula;
    private javax.swing.JLabel lblPivote;
    private javax.swing.JLabel lblProcesoAct;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTT;
    private javax.swing.JLabel lblUC;
    private javax.swing.JLabel lblUH;
    private javax.swing.JPanel mostrarCabeza;
    private javax.swing.JPanel mostrarPista1;
    private javax.swing.JPanel mostrarPista2;
    private javax.swing.JProgressBar progressB;
    private javax.swing.JTable tableDatosD;
    // End of variables declaration//GEN-END:variables
}
