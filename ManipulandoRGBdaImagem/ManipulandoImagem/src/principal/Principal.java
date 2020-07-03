
package principal;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.PopupMenu;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Principal extends javax.swing.JFrame {

     public Principal() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jp1 = new javax.swing.JScrollPane();
        jp2 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jp3 = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Imagem Original");

        jLabel3.setText("1ª Imagem com tonalidade Cinza");

        jLabel4.setText(" 2ª Imagem com somente duas cores: Preto e Branco");

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 102));
        jMenuBar1.setBorder(null);
        jMenuBar1.setToolTipText("Manipulando Imagens");

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("Abrir Imagem");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jp2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jp3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    JLabel lbl = new JLabel();
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        
        if(jfc.showOpenDialog(jMenu1) == JFileChooser.APPROVE_OPTION)
        {
            File f = jfc.getSelectedFile();
        try{      
            Color color;
            BufferedImage imgOriginal = ImageIO.read(f);
            BufferedImage imgCinza = ImageIO.read(f);
            BufferedImage imgPeB = ImageIO.read(f);
            for(int i = 0; i < imgOriginal.getWidth(); i++){
                for(int j = 0; j < imgOriginal.getHeight(); j++){
                   color = new Color(imgOriginal.getRGB(i,j));


                   //Deixando a imagem cinza
                   int r = color.getRed();
                   int g = color.getGreen();
                   int b = color.getBlue(); 
                   int md = (r+g+b)/3;

                   Color novoRgbCinza = new Color(md, md, md); // RGB ALTERADO PARA CINZA
                   int rgbCinza = novoRgbCinza.getRGB();
                   imgCinza.setRGB(i, j, rgbCinza);

                   //Deixando a imagem somente em preto e branco

                   if(md > 127){
                       Color novoRgbPeB = new Color(255, 255, 255); // RGB ALTERADO PARA BRANCO
                       int rgbPeB = novoRgbPeB.getRGB();
                       imgPeB.setRGB(i, j, rgbPeB);
                       
                   }else{
                       Color novoRgbPeB = new Color(0, 0, 0); // RGB ALTERADO PARA PRETO
                       int rgbPeB = novoRgbPeB.getRGB();
                       imgPeB.setRGB(i, j, rgbPeB);
                      
                   }

                }
            }
         
           
            
            //Código para add imagem na label1
            Image newimg1 = imgOriginal.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            label1.setIcon(new ImageIcon(newimg1));
            label1.setHorizontalAlignment(JLabel.CENTER);
            jp1.getViewport().add(label1);

            //Código para add imagem na label2 
           
            Image newimg2 = imgCinza.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            label2.setIcon(new ImageIcon(newimg2));
            label2.setHorizontalAlignment(JLabel.CENTER);
            jp2.getViewport().add(label2); 

            //Código para add imagem na label3
            
            Image newimg3 = imgPeB.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            label3.setIcon(new ImageIcon(newimg3));
            label3.setHorizontalAlignment(JLabel.CENTER);
            jp3.getViewport().add(label3);
            
      

         }catch(IOException ex){
          System.out.println("Erro:" + ex);
         } 
       }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jp1;
    private javax.swing.JScrollPane jp2;
    private javax.swing.JScrollPane jp3;
    // End of variables declaration//GEN-END:variables

    private PopupMenu setIcon(ImageIcon imageIcon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
