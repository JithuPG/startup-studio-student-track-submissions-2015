package compare.darkmatter;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class ImgShow 
{	
	private static String u1 =null;
	private static String u2 =null;
	ImgShow(String ur1, String ur2){
		
		ImgShow.u1= ur1;
		ImgShow.u2 = ur2;
		ImgShow.show();
	}
	
    public static void show()
    {
    	Image image1 = null;
    	Image image2 = null;
        try {
            URL url1 = new URL(u1);
            URL url2 = new URL(u2);
            image1 = ImageIO.read(url1);
            image2 = ImageIO.read(url2);
        } catch (IOException e) {
        	e.printStackTrace();
        }
 
        JFrame frame1 = new JFrame("Image 1");
        JFrame frame2 = new JFrame("Image 2");
        int width1 = image1.getWidth(null);
        int width2 = image2.getWidth(null);
        int height1 = image1.getHeight(null);
        int height2 = image2.getHeight(null);
        if(width1>600&&width2>600){
        	width1 /=2;
        	width2 /=2;
        }
        else if(width1>1600&&width2>1600){
        	width1 /=4;
        	width2 /=4;
        }
        if(height1>600&&height2>600){
        	height1 /=2;
        	height2 /=2;
        }
        else if(height1>1200&&height2>1200){
        	height1 /=4;
        	height2 /=4;
        }
        frame1.setSize(width1, height1);
        frame2.setSize(width2, height2);
        JLabel label1 = new JLabel(new ImageIcon(image1.getScaledInstance(width1, height1, 0)));
        JLabel label2 = new JLabel(new ImageIcon(image2.getScaledInstance(width2, height2, 0)));
       
        frame1.add(label1);
        frame2.add(label2);
        frame1.setVisible(true);
        frame2.setVisible(true);
    }
}