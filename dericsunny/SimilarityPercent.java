import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.lang.Math;
//program to find similarity between two images on internet
public class SimilarityPercent
{
  public static void main(String args[])
  {
    JLabel wait = new JLabel("Please wait....Processing", SwingConstants.CENTER);
    JLabel nil = new JLabel(" ");
    JFrame waiting = new JFrame();
    waiting.setSize(200, 80);
    waiting.add(wait);
    waiting.setVisible(false);
    point:
    do{

//variable initialization

    int width1 = 0;
    int height1 = 0;
    int width2 = 0;
    int height2 = 0;
    int width = 0;
    int height = 0;
    long diff = 0;
    int t = 0;
    BufferedImage img1 = null;
    BufferedImage temp1 = null;
    BufferedImage temp2 = null;
    BufferedImage img2 = null;
    String urlone = null;
    String urltwo = null;
    JTextField field1 = new JTextField("");
    JTextField field2 = new JTextField("");
    JPanel panel = new JPanel(new GridLayout(0, 1));
    JFrame frm1 = new JFrame();
    JFrame frm2 = new JFrame();
    panel.setSize(700,500);

//reading images from internet

    panel.add(new JLabel(" URL for 1st image :"));
    panel.add(field1);
    panel.add(new JLabel(" URL for 2nd image :"));
    panel.add(field2);
    panel.add(nil);
    panel.add(new JLabel("( Press CTRL/Command + V to paste )"));
    panel.setVisible(true);
    int result = JOptionPane.showConfirmDialog(null, panel, "INPUT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
        urlone = field1.getText();
        urltwo = field2.getText();
    } else
        System.exit(1);
    panel.setVisible(false);
    waiting.setLocationRelativeTo(null);
    waiting.setVisible(true);
    try {
      URL url1 = new URL(urlone);
      temp1 = ImageIO.read(url1);
    } catch (IOException e) {
        int error = JOptionPane.showConfirmDialog(null, "First URL can't be accessed!", "ERROR!!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        waiting.setVisible(false);
        if (result == JOptionPane.DEFAULT_OPTION)
            System.exit(1);
    }
    
    width1 = temp1.getWidth(null);
    height1 = temp1.getHeight(null);
    try {
      URL url2 = new URL(urltwo);
      temp2 = ImageIO.read(url2);
    } catch (IOException e) {
        int error = JOptionPane.showConfirmDialog(null, "Second URL can't be accessed!", "ERROR!!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        waiting.setVisible(false);
        if (result == JOptionPane.DEFAULT_OPTION)
            System.exit(1);
    }

//equalising images to same aspect ratio

    width2 = temp2.getWidth(null);
    height2 = temp2.getHeight(null);
    double aspect1 = width1/height1;
    double aspect2 = width2/height2;
    if(aspect1 < aspect2){
        width1 = (int)((double)width1*(aspect2));
        height1 = (int)((double)height1*(aspect2));
    }
    if(aspect2 < aspect1){
        width2 = (int)((double)width2*(aspect1));
        height2 = (int)((double)height2*(aspect1));
    }
    if(aspect1>1)
        temp1 = temp1.getSubimage((temp1.getWidth(null)-width1), (temp1.getHeight(null)-height1), width1, height1);
    else
        temp1 = temp1.getSubimage(0, 0, width1, height1);
    if(aspect2>1)
        temp2 = temp2.getSubimage((temp2.getWidth(null)-width2), (temp2.getHeight(null)-height2), width2, height2);
    else
        temp2 = temp2.getSubimage(0, 0, width2, height2);
        
    if(width1<width2){
        width = width1;
    } else{
        width = width2;
    }
    
    if(height1<height2){
        height = height1;
    } else{
        height = height2;
    }

//scaling images in same aspect ratio

    img1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = img1.createGraphics();
    g.drawImage(temp1, 0, 0, width, height, null);
    g.dispose();
    
    img2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    g = img2.createGraphics();
    g.drawImage(temp2, 0, 0, width, height, null);
    g.dispose();
    diff-=1;

//checking for similarity

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
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
    
    waiting.setVisible(false);
    frm1.setSize(temp1.getWidth(null), temp1.getHeight(null));
    frm1.setLocation(60, 60);
    frm2.setSize(temp2.getWidth(null), temp2.getHeight(null));
    frm2.setLocation(90+(temp1.getWidth(null)), 60);
    JLabel label1 = new JLabel(new ImageIcon(temp1));
    JLabel label2 = new JLabel(new ImageIcon(temp2));
    frm1.add(label1, BorderLayout.WEST);
    frm2.add(label2, BorderLayout.WEST);
    frm1.setVisible(true);
    frm2.setVisible(true);

//producing output

    double n = width*height*3;
    double p = diff / n / 255.0;
    p = (100 - p * 100.0);
    p = Math.round(p);
    JLabel oput = new JLabel("Similarity is " + p + "%",SwingConstants.CENTER);
    oput.setVerticalAlignment(SwingConstants.TOP);
    oput.setFont(new Font("Verdana", 0, 15));
    JLabel res = new JLabel("Try different URLs?",SwingConstants.CENTER);
    JPanel panel2 = new JPanel(new GridLayout(0, 1));
    panel2.setSize(300, 100);
    panel2.add(oput);
    panel2.add(nil);
    panel2.add(res);
    panel2.setVisible(true);
    result = JOptionPane.showConfirmDialog(null, panel2, "RESULT", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.YES_OPTION) {
        frm1.setVisible(false);
        frm2.setVisible(false);
        panel2.setVisible(false);
    } else
        System.exit(1);
    }while(true);
  }
}

