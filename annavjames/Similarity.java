import java.io.*;
import java.net.URL;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



 
public class Similarity
{
  public static void main(String args[]) throws IOException
  {
      InputStreamReader r=new InputStreamReader(System.in);  
        BufferedReader br=new BufferedReader(r);  
  
        System.out.println("Enter the link of image");  
        String link1=br.readLine();  
        System.out.println("Enter the link of second image");  
        String link2=br.readLine();  
        
    BufferedImage I1 = null;
    BufferedImage I2 = null;
    try {
      URL url1 = new URL(link1);
      URL url2 = new URL(link2);
      I1 = ImageIO.read(url1);
      I2 = ImageIO.read(url2);
    } catch (IOException e) {
     System.out.println("Error:"+e);
    }
    int w1 = I1.getWidth(null);
    int w2 = I2.getWidth(null);
    int h1 = I1.getHeight(null);
    int h2 = I2.getHeight(null);
    if ((w1 != w2) || (h1 != h2)) {
      System.err.println("Your Images does not match !!!");
      System.exit(1);
    }
    long difference = 0;
    for (int i = 0; i < h1; i++) {
      for (int j = 0; j < w1; j++) {
        int rgb1 = I1.getRGB(j, i);
        int rgb2 = I2.getRGB(j, i);
        int red1 = (rgb1 >> 16) & 0xff;
        int green1 = (rgb1 >>  8) & 0xff;
        int blue1 = (rgb1      ) & 0xff;
        int red2 = (rgb2 >> 16) & 0xff;
        int green2 = (rgb2 >>  8) & 0xff;
        int blue2 = (rgb2      ) & 0xff;
        difference += Math.abs(red1 - red2);
        difference += Math.abs(green1 - green2);
        difference += Math.abs(blue1 - blue2);
      }
    }
    double n = w1 * h1 * 3;
    double p = difference / n ;
    double p1= p/ 255.0;
    double s=1.0-p1;
    
    System.out.println("Similarity Rank : " + (s * 100.0));
  }
}