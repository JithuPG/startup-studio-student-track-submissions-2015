package compare.darkmatter;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;

 
public class ImgDiffPercent
{
	
	public static String urla ;
    public static String urlb ;

	ImgDiffPercent(String url1 , String url2 ){
		
		urla = url1;
	    urlb = url2;
	}
	
  public double DifPerc()
  {
    BufferedImage img1 = null;
    BufferedImage img2 = null;
    try {
    	
      URL url1 = new URL(urla);
      URL url2 = new URL(urlb);
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
    JOptionPane.showMessageDialog(null, "Godamnit Kevin!!");
      
    }
    long diff = 0;
    for (int y = 0; y < height1; y++) {
      for (int x = 0; x < width1; x++) {
        int rgb1 = img1.getRGB(x, y);
        int rgb2 = img2.getRGB(x, y);
        int red1 = (rgb1 >> 16) & 0xff;
        int green1 = (rgb1 >>  8) & 0xff;
        int blue1 = (rgb1      ) & 0xff;
        int red2 = (rgb2 >> 16) & 0xff;
        int green2 = (rgb2 >>  8) & 0xff;
        int blue2 = (rgb2      ) & 0xff;
        diff += Math.abs(red1 - red2);
        diff += Math.abs(green1 - green2);
        diff += Math.abs(blue1 - blue2);
      }
    }
    double n = width1 * height1 * 3;
    double p = diff / n / 255.0;
    p = (1-p)*100;
    BigDecimal bd = new BigDecimal(p);
    bd = bd.setScale(2, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
}









