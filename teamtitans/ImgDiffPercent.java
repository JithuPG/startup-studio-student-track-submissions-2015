import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class ImgDiffPercent
{
    private static int x;
    private static int rgb1;
    private static int rgb2;
    private static int g1;
    private static int r1;
    private static int b1;
    private static int r2;
    private static int g2;
    private static int b2;

  public static void main(String args[])
  {
   String b; 
    BufferedImage img1 = null;
    BufferedImage img2 = null;
    try {
        //Enter image of same size
     URL url1 = new URL("http://www.indiancinemagallery.com/images/profile/thumb_Priyanka-Chopra4692.jpg");
     URL url2 = new URL("http://media2.intoday.in/indiatoday/images/stories/priyanka-chopra_660_042313054728_020614072843.jpg");
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
    double s1= 1 - p;
    
       
       //180 degree
        diff = 0;
      int y;
    for ( y = 0; y < height1; y++) {
      for ( x = 0; x < width1; x++) {
         rgb1 = img1.getRGB(width1-x,height1-y);
        rgb2 = img2.getRGB(x, y);
         r1 = (rgb1 >> 16) & 0xff;
         g1 = (rgb1 >>  8) & 0xff;
        b1 = (rgb1      ) & 0xff;
         r2 = (rgb2 >> 16) & 0xff;
         g2 = (rgb2 >>  8) & 0xff;
         b2 = (rgb2      ) & 0xff;
        diff += Math.abs(r1 - r2);
        diff += Math.abs(g1 - g2);
        diff += Math.abs(b1 - b2);
      }}
double n2 = width1 * height1 * 3;
          double n3;
    double p2 = diff / n2 / 255.0;
         double p3;
    double s2= 1 - p2;
     //  System.out.println("similarity: " + (s3 * 100.0));
       //hf   
           diff = 0;
    for ( y = 0; y < height1; y++) {
      for ( x = 0; x < width1; x++) {
         rgb1 = img1.getRGB(y,x);
         rgb2 = img2.getRGB(y,width1-x);
         r1 = (rgb1 >> 16) & 0xff;
         g1 = (rgb1 >>  8) & 0xff;
         b1 = (rgb1      ) & 0xff;
         r2 = (rgb2 >> 16) & 0xff;
         g2 = (rgb2 >>  8) & 0xff;
         b2 = (rgb2      ) & 0xff;
        diff += Math.abs(r1 - r2);
        diff += Math.abs(g1 - g2);
        diff += Math.abs(b1 - b2);
      }}
 n3 = width1 * height1 * 3;
     p3 =  (diff / n3 / 255.0);
          double s3 = 1 - p3;
    //vf
     diff = 0;
    for ( y = 0; y < height1; y++) {
      for ( x = 0; x < width1; x++) {
         rgb1 = img1.getRGB(y,x);
         rgb2 = img2.getRGB(height1-y,x);
         r1 = (rgb1 >> 16) & 0xff;
         g1 = (rgb1 >>  8) & 0xff;
        b1 = (rgb1      ) & 0xff;
        r2 = (rgb2 >> 16) & 0xff;
         g2 = (rgb2 >>  8) & 0xff;
         b2 = (rgb2      ) & 0xff;
        diff += Math.abs(r1 - r2);
        diff += Math.abs(g1 - g2);
        diff += Math.abs(b1 - b2);
      }
    }
          double n4 = width1 * height1 * 3;
          double p4 = diff / n4 / 255.0;
          double s4 = 1 - p4;

       long s = (int) (s1+s2+s3+s4);
       s=s/2;
    System.out.println("similarity: " + (s * 100.0));
      }
    }
 
