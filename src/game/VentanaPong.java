package game;
import java.awt.Point;
import javax.swing.JOptionPane;

public class VentanaPong extends javax.swing.JFrame {

    int dx = 20;
    int dy = 20;
    
    boolean enJuego = true;
    
    public boolean choque(){
        if (jPanel2.getY() >= jPanel1.getY() &&
            jPanel2.getY() <= jPanel1.getY() + jPanel1.getHeight() ){
            if (jPanel2.getX()<= jPanel1.getX()+jPanel1.getWidth()
               && jPanel2.getX()>= jPanel1.getX()  )
            dx = -dx;
        }
        //JPANEL2: pelota
        //JPANEL3: oponente
        if (jPanel2.getY() >= jPanel3.getY() &&
            jPanel2.getY() <= jPanel3.getY() + jPanel3.getHeight() ){
            if (jPanel2.getX()+jPanel2.getWidth() <= jPanel3.getX() + jPanel3.getWidth()
               && jPanel2.getX()+jPanel2.getWidth() >= jPanel3.getX()  )
            dx = -dx;
        }

        return false;
    }
    
    
    
    public VentanaPong() {
        initComponents(); 
        
        //Evento temporal, se ejecuta cada 500 milisegundos
        Thread hilo = new Thread(){            
            public void run(){                
                int contadorJugador2 = 0;
                
                while(enJuego){
                    try{
                        
                        if(jPanel3.getX()<600){
                            jPanel3.setLocation(600
                            ,200);                             
                            jLabel2.setLocation(450,50);
                        }
                        Thread.sleep(100);
                        choque();
                        Point p = jPanel2.getLocation();
                        
                        
                        
                        jPanel2.setLocation((int) p.getX() + dx,
                                            (int) p.getY() + dy);
                        if (jPanel2.getY()>450){
                            dy = -dy;                                                        
                        }
                        if (jPanel2.getY()<0){
                            dy = -dy;
                        }
                        //PERDIO EL PUNTO EL JUGADOR 2
                        if (jPanel2.getX()>650){
                            //dx = -dx;                            
                            contadorJugador2++;
                            jLabel2.setText(""+contadorJugador2);
                            Thread.sleep(1000);
                            jPanel2.setLocation(100,100);                            
                        }
                        //COLICION DE LA PELOTA EN EL EXTREMO IZQUIERO DEL AREA DE JUEGO
                        //PUNTO PARA EL JUGADOR 2
                        if (jPanel2.getX()<30){
                            dx = -dx;
                        }
                        
                        
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            }            
        };
        hilo.start();
        
        //HILO PARA CONTROLAR EL OPONENTE
        Thread oponente = new Thread(){            
            public void run(){
                int dy = 10;
                
                while (enJuego){
                    try{
                        
                        int nuevox = jPanel3.getX();
                        int nuevoy = jPanel3.getY();
                        /*int coordenadaCentroPelota = 
                                (int)(jPanel2.getY()+ jPanel2.getHeight()/2);
                        int coordenadaCentroBarra = 
                                (int)(jPanel3.getY()+ jPanel3.getHeight()/2);
                        if (coordenadaCentroBarra>coordenadaCentroPelota){
                            dy = -10;
                        }
                        if (coordenadaCentroBarra<coordenadaCentroPelota){
                            dy = 10;
                        } */
                        
                        nuevoy += dy;
                        if (nuevoy + jPanel3.getHeight()>= 480) {
                            dy = -dy;
                        }
                        if (nuevoy <=0 ) {
                            dy = -dy;
                        }
                        jPanel3.setLocation(nuevox, nuevoy);
                        Thread.sleep(100);
                    } catch(Exception e){
                        
                    }
                }
            }
        };
        oponente.start();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(29, 177));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 0, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("0");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)))
                .addGap(328, 328, 328)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        jPanel1.setLocation(80
                ,evt.getY()-(int) (jPanel1.getHeight() / 2) );
       
             
        
        //System.out.println(evt.getY());
    }//GEN-LAST:event_formMouseMoved

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
            java.util.logging.Logger.getLogger(VentanaPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
