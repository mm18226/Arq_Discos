/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class form_tiempo_busqueda extends javax.swing.JFrame {

    /**
     * Creates new form formPrincipal
     */
    public form_tiempo_busqueda() {
        initComponents();

    }
    
    //Declaracion variables publicas para enviar al form simulacion busqueda
    public static String cantPD="";
    public static String cantC="";
    public static String velR="";
    public static String dirI="";
    public static String dirF="";
    public static String cantSD="";
    public static String tbD="";
    //Variables para uso de calculos de resultado
    public static int secC=0,cantHeads=0,cantP=0,cantS=0,dirD1=0,dirD2=0,headD1=0,headD2=0,secD1=0,secD2=0,d1=0,d2=0;
    public static int cD1=0,cD2=0,resD1=0,resD2=0,tBP=0,tB=0,cantSR=0,secD1Mov=0,secXR=0,totSecR=0,secRest=0,cantVueltas=0;
    public static double x=0,tR=0,tTotRS=0,tTotD1D2=0;
    //conocer si es un dato RPM o RPS
    public static boolean rpsT=false;
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGVelR = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rBRPM = new javax.swing.JRadioButton();
        rBRPS = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCantD = new javax.swing.JTextField();
        txtCantC = new javax.swing.JTextField();
        txtDirI = new javax.swing.JTextField();
        txtVelR = new javax.swing.JTextField();
        txtDirF = new javax.swing.JTextField();
        btnTB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtcantS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTB = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(34, 40, 49));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(83, 187, 180));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DiscosXD");
        jLabel2.setOpaque(true);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 40));

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

        jLabel3.setBackground(new java.awt.Color(34, 40, 49));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Planificacion.png"))); // NOI18N
        jLabel3.setText("Algoritmo planificación");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 510));

        jPanel3.setBackground(new java.awt.Color(83, 184, 187));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 730, 40));

        jLabel4.setText("Tiempo de búsqueda total de una direccion a otra en un disco duro en base a sus datos.");

        jLabel5.setText("Cantidad de platos del disco*:");

        jLabel6.setText("Cantidad de cilindros que contiene*:");

        jLabel7.setText("Velocidad de giro*:");

        bGVelR.add(rBRPM);
        rBRPM.setText("RPM");
        rBRPM.setName("radBRPM"); // NOI18N
        rBRPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBRPMActionPerformed(evt);
            }
        });

        bGVelR.add(rBRPS);
        rBRPS.setText("RPS");
        rBRPS.setName("radBRPS"); // NOI18N
        rBRPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBRPSActionPerformed(evt);
            }
        });

        jLabel8.setText("Dirección inicial*:");

        jLabel9.setText("Dirección final*:");

        txtCantD.setName(""); // NOI18N

        txtCantC.setName(""); // NOI18N

        txtDirI.setName(""); // NOI18N

        txtVelR.setName(""); // NOI18N

        txtDirF.setName(""); // NOI18N

        btnTB.setText("Calcular tiempo de busqueda");
        btnTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTBActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad de sectores por pista*:");

        txtcantS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantSActionPerformed(evt);
            }
        });

        jLabel10.setText("Tiempo de búsqueda*:");

        jLabel13.setText("ms");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(72, 72, 72)
                                        .addComponent(txtCantD, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDirF, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDirI, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtCantC, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtcantS, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtVelR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rBRPM)
                                        .addGap(18, 18, 18)
                                        .addComponent(rBRPS))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(btnTB)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCantC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rBRPM)
                            .addComponent(rBRPS)
                            .addComponent(txtVelR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDirI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDirF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnTB)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 660, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        formPrincipal form= new formPrincipal();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setBackground(new Color (83,187,180));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jLabel11.setBackground(new Color (34,40,49));
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        //Vacio
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setBackground(new Color (83,187,180));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setBackground(new Color (34,40,49));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        form_algoritmo_planificacion form= new form_algoritmo_planificacion();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setBackground(new Color (83,187,180));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setBackground(new Color (34,40,49));
    }//GEN-LAST:event_jLabel3MouseExited

    private void rBRPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBRPSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBRPSActionPerformed

    private void rBRPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBRPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBRPMActionPerformed

    private void btnTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTBActionPerformed
        // TODO add your handling code here:
        //captura valores de los textbox
        cantPD=txtCantD.getText();
        cantC=txtCantC.getText();
        velR=txtVelR.getText();
        dirI=txtDirI.getText();
        dirF=txtDirF.getText();
        cantSD=txtcantS.getText();
        tbD=txtTB.getText();
        //variable si el recorrdio es mayor a los sectores de un cilindro
        int secCIfM=0;

        // asignar un decimalFormat para el tiempo de rotación
        DecimalFormat df=new DecimalFormat("#.00");
        //valida si RPS checkbox fue marcado
        if(rBRPS.isSelected()){
            rpsT=true;
        }
        //valida si los datos fueron ingresados correctamente
        if(validarTB(cantPD, cantC, velR,dirI,dirF,cantSD,tbD)){
            //validar que la direccion final o inicial no sobrepasen las direcciones maximas que puede tener el disco duro
               //calcula la cantidad de cabezas por la cantidad de platos que se ingresaron
               //captura cantidad de sectores
               cantS=Integer.parseInt(cantSD);
               //cantidad de platos y calculo de cabezas
                cantP=Integer.parseInt(cantPD);
                cantHeads=cantP*2;
                
               //Calcular sectores del cilindro
                secC=cantHeads*cantS;
               
                int cantMax;
                int cantCC=Integer.parseInt(cantC);
                
                cantMax=secC * cantCC;
                
             if(Integer.parseInt(dirI)>cantMax ||Integer.parseInt(dirF)>cantMax){
                 JOptionPane.showMessageDialog(null,"La direccion inicial o final sobrepasa el maximo que puede tener el disco duro especificado");
             }
             else{
            //proceso si fue marcado rpm
            if(rpsT==false){
                 
                //capturar tiempo de busqueda 
                tB=Integer.parseInt(tbD);
                //captura la velocidad ingresada en rpm
                int rpm=Integer.parseInt(velR);
                //calcula el tiempo rotacional en ms
                x=((60*1.0)/rpm)*1000;
                tR=x/cantS;
                //capturar direcciones
                d1=Integer.parseInt(dirI);
                d2=Integer.parseInt(dirF);
                //calcular cilindro donde se ubica direccion inicial y guardamos su residuo
                cD1=d1/secC;
                resD1=d1%secC;
                //calcular cabeza y sector direccion inicial
                headD1=resD1/cantS;
                secD1=resD1%cantS;
                //calcular cilindro donde se ubica direccion Final y guardamos su residuo
                cD2=d2/secC;
                resD2=d2%secC;
                //calcular cabeza y sector direccion FINAL
                headD2=resD2/cantS;
                secD2=resD2%cantS;
               // JOptionPane.showMessageDialog(null,"D1: "+d1+" cilindo D1: "+cD1+" Head D1: "+headD1+" Sec D1: "+secD1+"D2: "+d2+" cilindo D2: "+cD2+" Head D1: "+headD2+" Sec D1: "+secD2+" Tiempo de rotacion:"+df.format(tR));
            //Calcular tiempo de busqueda de petición
            tBP=Math.abs((cD1-cD2))*tB;
           // JOptionPane.showMessageDialog(null,"Tiempo de busqueda: "+tBP);
            //Calcular cantidad de sectores recorridos
            cantSR=(int) (tBP/tR);
           // JOptionPane.showMessageDialog(null,"sectores recorridos"+cantSR);
            //Calcular el sector al que se recorrio la Direccion inicial
            secD1Mov=secD1+cantSR;
            //Comparar si los sectores recorridos no sobrepasan los sectores maximos de un cilindro
            if(secD1Mov>cantS){
                for(int i=secD1Mov;i>cantS;i-=cantS){
                   secCIfM=i; 
                   cantVueltas++;
                }
                //realiza ultima resta que no hizo el ciclo for al ser ya menor
               secRest=secCIfM-cantS; 
               cantVueltas++;
              // JOptionPane.showMessageDialog(null,"ubicacion sector actual"+secD1Mov);
               //Verificar si quedo arriba o abajo del sector de destino
            if(secRest>secD2){
                //calcular sectores que faltan por recorrer para volver a la posicion 1
                secXR=cantS-secRest;
                //calcular total de sectores recorridos
                totSecR=secXR+secD2;
                //Calcular tiempo total por recorrer estos sectores
                tTotRS=totSecR*tR;
                tTotD1D2=tBP+tTotRS;
               // JOptionPane.showMessageDialog(null,"tiempo total de busqueda fue mayor: "+tTotD1D2);
            }
            if(secRest<secD2){
                totSecR=secD2-secRest;
                 tTotRS=totSecR*tR;
                tTotD1D2=tBP+tTotRS;
               // JOptionPane.showMessageDialog(null,"tiempo total de busqueda fue menor: "+tTotD1D2);
            }
            if(secRest==secD2){
               // JOptionPane.showMessageDialog(null,"tiempo total de busqueda: "+tR);
               tTotD1D2=tR;
            }
                }//Sino era mayor el recorrido al maximo de cilindros
            else{
            //Verificar si quedo arriba o abajo del sector de destino
            if(secD1Mov>secD2){
                //calcular sectores que faltan por recorrer para volver a la posicion 1
                secXR=cantS-secD1Mov;
                //calcular total de sectores recorridos
                totSecR=secXR+secD2;
                //Calcular tiempo total por recorrer estos sectores
                tTotRS=totSecR*tR;
                tTotD1D2=tBP+tTotRS;
               // JOptionPane.showMessageDialog(null,"tiempo total de busqueda: "+tTotD1D2);
            }
            if(secD1Mov<secD2){
                totSecR=secD2-secD1Mov;
                 tTotRS=totSecR*tR;
                tTotD1D2=tBP+tTotRS;
               // JOptionPane.showMessageDialog(null,"tiempo total de busqueda: "+tTotD1D2);
            }
            if(secD1Mov==secD2){
               // JOptionPane.showMessageDialog(null,"tiempo total de busqueda: "+tR);
               tTotD1D2=tR;
            }
            }
                
            }//proceso si fue marcado rps
            else{
                //capturar tiempo de busqueda 
                tB=Integer.parseInt(tbD);
                //captura la velocidad ingresada en rps
                int rps=Integer.parseInt(velR);
                //calcula el tiempo rotacional en ms
                x=((1*1.0)/rps)*1000;
                tR=x/cantS;
                //capturar direcciones
                d1=Integer.parseInt(dirI);
                d2=Integer.parseInt(dirF);
                //calcular cilindro donde se ubica direccion inicial y guardamos su residuo
                cD1=d1/secC;
                resD1=d1%secC;
                //calcular cabeza y sector direccion inicial
                headD1=resD1/cantS;
                secD1=resD1%cantS;
                //calcular cilindro donde se ubica direccion Final y guardamos su residuo
                cD2=d2/secC;
                resD2=d2%secC;
                //calcular cabeza y sector direccion FINAL
                headD2=resD2/cantS;
                secD2=resD2%cantS;
                //JOptionPane.showMessageDialog(null,"D1: "+d1+" cilindo D1: "+cD1+" Head D1: "+headD1+" Sec D1: "+secD1+"D2: "+d2+" cilindo D2: "+cD2+" Head D1: "+headD2+" Sec D1: "+secD2+" Tiempo de rotacion:"+df.format(tR));
            //Calcular tiempo de busqueda de petición
            tBP=Math.abs((cD1-cD2))*tB;
            //JOptionPane.showMessageDialog(null,"Tiempo de busqueda: "+tBP);
            //Calcular cantidad de sectores recorridos
            cantSR=(int) (tBP/tR);
            //JOptionPane.showMessageDialog(null,"sectores recorridos"+cantSR);
            //Calcular el sector al que se recorrio la Direccion inicial
            secD1Mov=secD1+cantSR;
            //Comparar si los sectores recorridos no sobrepasan los sectores maximos de un cilindro
            if(secD1Mov>cantS){
                for(int i=secD1Mov;i>cantS;i-=cantS){
                   secCIfM=i; 
                   cantVueltas++;
                }
                //realiza ultima resta que no hizo el ciclo for al ser ya menor
               secRest=secCIfM-cantS; 
               cantVueltas++;
               //JOptionPane.showMessageDialog(null,"ubicacion sector actual"+secD1Mov);
               //Verificar si quedo arriba o abajo del sector de destino
            if(secRest>secD2){
                //calcular sectores que faltan por recorrer para volver a la posicion 1
                secXR=cantS-secRest;
                //calcular total de sectores recorridos
                totSecR=secXR+secD2;
                //Calcular tiempo total por recorrer estos sectores
                tTotRS=totSecR*tR;
                tTotD1D2=tBP+tTotRS;
                //JOptionPane.showMessageDialog(null,"tiempo total de busqueda fue mayor: "+tTotD1D2);
            }
            if(secRest<secD2){
                totSecR=secD2-secRest;
                 tTotRS=totSecR*tR;
                tTotD1D2=tBP+tTotRS;
                //JOptionPane.showMessageDialog(null,"tiempo total de busqueda fue menor: "+tTotD1D2);
            }
            if(secRest==secD2){
                //JOptionPane.showMessageDialog(null,"tiempo total de busqueda: "+tR);
                tTotD1D2=tR;
                
            }
                }//Sino era mayor el recorrido al maximo de cilindros
            else{
            //Verificar si quedo arriba o abajo del sector de destino
            if(secD1Mov>secD2){
                //calcular sectores que faltan por recorrer para volver a la posicion 1
                secXR=cantS-secD1Mov;
                //calcular total de sectores recorridos
                totSecR=secXR+secD2;
                //Calcular tiempo total por recorrer estos sectores
                tTotRS=totSecR*tR;
                tTotD1D2=tBP+tTotRS;
               // JOptionPane.showMessageDialog(null,"tiempo total de busqueda: "+tTotD1D2);
            }
            if(secD1Mov<secD2){
                totSecR=secD2-secD1Mov;
                 tTotRS=totSecR*tR;
                tTotD1D2=tBP+tTotRS;
               // JOptionPane.showMessageDialog(null,"tiempo total de busqueda: "+tTotD1D2);
            }
            if(secD1Mov==secD2){
                //JOptionPane.showMessageDialog(null,"tiempo total de busqueda: "+tR);
                tTotD1D2=tR;
            }
            }
            //mostrar simulacion del proceso
            form_simulacion_busqueda form= new form_simulacion_busqueda();
            form.setVisible(true);
            dispose();
           }
        }
        }else{
            JOptionPane.showMessageDialog(null,"Asegurese de ingresar y marcar todos los datos correctamente, deben ser enteros POSITIVOS");
        }
    }//GEN-LAST:event_btnTBActionPerformed

    
    private void txtcantSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantSActionPerformed

    public static boolean validarTB(String cadena,String cadena2, String cadena3, String cadena4, String cadena5, String cadena6, String cadena7 ){       
        return cadena.matches("[0-9,]*")& cadena2.matches("[0-9]*")& cadena3.matches("[0-9]*")& cadena4.matches("[0-9]*")& cadena5.matches("[0-9]*")& cadena6.matches("[0-9]*")& cadena7.matches("[0-9]*")&!cadena.equals("")&!cadena2.equals("")&!cadena3.equals("")&!cadena4.equals("")&!cadena5.equals("")&!cadena6.equals("")&!cadena7.equals("");
    }
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
            java.util.logging.Logger.getLogger(form_tiempo_busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_tiempo_busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_tiempo_busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_tiempo_busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>    
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_tiempo_busqueda().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGVelR;
    private javax.swing.JButton btnTB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton rBRPM;
    private javax.swing.JRadioButton rBRPS;
    private javax.swing.JTextField txtCantC;
    private javax.swing.JTextField txtCantD;
    private javax.swing.JTextField txtDirF;
    private javax.swing.JTextField txtDirI;
    private javax.swing.JTextField txtTB;
    private javax.swing.JTextField txtVelR;
    private javax.swing.JTextField txtcantS;
    // End of variables declaration//GEN-END:variables
}
