import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class ImgSimilar
{
     public static void main(String args[])throws IOException
     {
          int width1, width2, height1, height2;
          BufferedImage img1=null, img2=null;
          long dif=0;
          Double n_pixel,p;
          img1=ImageIO.read(new URL("http://www.indiancinemagallery.com/images/profile/thumb_Priyanka-Chopra4692.jpg"));
          img2=ImageIO.read(new URL("http://media2.intoday.in/indiatoday/images/stories/priyanka-chopra_660_042313054728_020614072843.jpg"));
          width1=img1.getWidth();
          height1=img1.getHeight();
          width2=img2.getWidth();
          height2=img2.getHeight();
          if((width1!=width2) || (height1!=height2))
          {
               System.err.println("Dimensions of images are mismatched!!!");
               System.exit(1);
          }
          
          for(int y=0;y<height1;y++)
          {
               for(int x=0;x<width1;x++)
               {
                    int rgb1=img1.getRGB(x,y);
                    int rgb2=img2.getRGB(x,y);
                    int r1=(rgb1 >> 16) & 0xff;
                    int g1=(rgb1 >> 8)  & 0xff;
                    int b1=(rgb1) & 0xff;
                    int r2=(rgb2 >> 16) & 0xff;
                    int g2=(rgb2 >> 8)  & 0xff;
                    int b2=(rgb2) & 0xff;
                    dif+=Math.abs(r1-r2);
                    dif+=Math.abs(g1-g2);
                    dif+=Math.abs(b1-b2);
               }
          }
          n_pixel=width1* height1 * 3.0;
          p=1 - (dif / n_pixel / 255.0);
          System.out.println("Similarity in percentage : "+(p * 100.0));
     }
}
