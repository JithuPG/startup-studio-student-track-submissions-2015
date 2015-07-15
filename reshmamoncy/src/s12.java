/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author Divya
 */
public class s12 extends javax.swing.JFrame {
static int flag=0,p1;
    /** Creates new form s12 */
    public s12() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn = new javax.swing.JButton();
        txturl1 = new javax.swing.JTextField();
        txturl2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn.setText("Compare");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        txturl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txturl1ActionPerformed(evt);
            }
        });

        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);

        jLabel1.setText("Enter URL1:");

        jLabel2.setText("Enter URL2:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txturl1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txturl2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(btn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txturl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txturl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addComponent(btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
         {
    BufferedImage img1 = null;
    BufferedImage img2 = null;
    
      String urla = txturl1.getText();
      String imageUrl1=urla;
        String urlb = txturl2.getText();
        String imageUrl2=urlb;
        try
        {
      URL url1=new URL(urla);
      URL url2=new URL(urlb);
      img1 = ImageIO.read(url1);
      img2 = ImageIO.read(url2);
    } catch (IOException e) {
      e.printStackTrace();
    }
    int width1 = img1.getWidth(null);
    int width2 = img2.getWidth(null);
    int height1 = img1.getHeight(null);
    int height2 = img2.getHeight(null);
    if ((width1 != width2) || (height1 != height2)) {
      System.err.println("Error: Images dimensions mismatch");
      System.exit(1);
    }
    long diff = 0;
    for (int y = 0; y < height1; y++) {
      for (int x = 0; x < width1; x++) {
        int rgb1 = img1.getRGB(x, y);
        int rgb2 = img2.getRGB(x, y);
        int r1 = (rgb1 >> 16) & 0xff;
        int g1 = (rgb1 >>  8) & 0xff;
        int b1 = (rgb1      ) & 0xff;
        int r2 = (rgb2 >> 16) & 0xff;
        int g2 = (rgb2 >>  8) & 0xff;
        int b2 = (rgb2      ) & 0xff;
        diff += Math.abs(r1 - r2);
        diff += Math.abs(g1 - g2);
        diff += Math.abs(b1 - b2);
      }
    }
    double n = width1 * height1 * 3;
    double p = diff / n / 255.0;
    String destinationFile1 = "image1.jpg";
            try {
                saveImage(imageUrl1, destinationFile1);
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
      String destinationFile2 = "image2.jpg";
            try {
                saveImage(imageUrl2, destinationFile2);
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
      long start = System.currentTimeMillis();
File file,files;
        int q=0;
            File file1 = new File("sp.txt");

        
        if (!file1.exists()) {
                try {
                    file1.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        FileWriter fw = null;
            try {
                fw = new FileWriter(file1.getAbsoluteFile());
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        BufferedWriter bw = new BufferedWriter(fw);
if(flag==0)
{
             file= new File("image1.jpg");
}
else
  {          file= new File("image1.png");
}
 BufferedImage image = null;
            try {
                image = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        int width = image.getWidth(null);
            int height = image.getHeight(null);
        int[][] clr=  new int[width][height]; 
       if(flag==0)
{
             files= new File("image2.jpg");
}
else
  {         files= new File("image2.png");
}
            BufferedImage images = null;
            try {
                images = ImageIO.read(files);
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        int widthe = images.getWidth(null);
            int heighte = images.getHeight(null);
        int[][] clre=  new int[widthe][heighte]; 
        int smw=0;
        int smh=0;
        int p1=0;
            //CALUCLATING THE SMALLEST VALUE AMONG WIDTH AND HEIGHT
            if(width>widthe)
            { 
                smw =widthe;
            }
            else 
            {
                smw=width;
            }
            if(height>heighte)
            {
                smh=heighte;
            }
            else 
            {
                smh=height;
            }
            //CHECKING NUMBER OF PIXELS SIMILARITY
            for(int a=0;a<smw;a++)
            {
                for(int b=0;b<smh;b++)
                {
                    clre[a][b]=images.getRGB(a,b);
                    clr[a][b]=image.getRGB(a,b);
                    if(clr[a][b]==clre[a][b]) 
                    {
                        p1=p1+1;
                        try {
                            bw.write("\t");
                        
                         bw.write(Integer.toString(a));
                        bw.write("\t");
                         bw.write(Integer.toString(b)); 
                        bw.write("\n");
                        } catch (IOException ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                        q=q+1;
                }
            }

    float w,h=0;
    if(width>widthe) 
    {
        w=width;
    }
    else 
    {
        w=widthe;
    }
    if(height>heighte)
    { 
        h = height;
    }
    else
    {
        h = heighte;
    }
    float s = (smw*smh);
    //CALUCLATING PERCENTAGE
    float x =(100*p1)/s;
long stop = System.currentTimeMillis();

    
    double div=100-(p*100);
    double di=(div+x)/2;
    
    txtarea.setText("THE PERCENTAGE SIMILARITY IS APPROXIMATELY ="+di+"%"+"\n"+
    
    "TIME TAKEN IS ="+(stop-start)+"\n"+
    "NO OF PIXEL GETS VARIED:="+q+"\n"+
    "NO OF PIXEL GETS MATCHED:="+p1);
      }
    }                                        
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           
    private void txturl2ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

public static void saveImage(String imageUrl, String destinationFile) throws IOException {
    URL url = new URL(imageUrl);
    InputStream is = url.openStream();
    OutputStream os = new FileOutputStream(destinationFile);
    byte[] by = new byte[2048];
    int length;
    while ((length = is.read(by)) != -1) {
        os.write(by, 0, length);
    }
    is.close();
    os.close();
    }//GEN-LAST:event_btnActionPerformed

    private void txturl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txturl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txturl1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new s12().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtarea;
    private javax.swing.JTextField txturl1;
    private javax.swing.JTextField txturl2;
    // End of variables declaration//GEN-END:variables
}

