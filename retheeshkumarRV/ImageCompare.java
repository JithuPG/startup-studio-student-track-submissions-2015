import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.imageio.ImageIO;


public class ImageCompare 
	{
	public static void main(String s[])
		{
		float sim=0;
		int h,mh,w,mw;
		
		try
			{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter first image's link: ");
			BufferedImage image1=ImageIO.read(new URL(br.readLine()));
			System.out.print("Enter second image's link: ");
			BufferedImage image2=ImageIO.read(new URL(br.readLine()));
			br.close();
			
			if((image1.getHeight()==image2.getHeight())||(image1.getHeight()<image2.getHeight()))
				{
				h=image1.getHeight();
				mh=image2.getHeight();
				}
			else
				{
				h=image2.getHeight();
				mh=image1.getHeight();
				}
			
			if((image1.getWidth()==image2.getWidth())||(image1.getWidth()<image2.getWidth()))
				{
				w=image1.getWidth();
				mw=image2.getWidth();
				}
			else 
				{
				w=image2.getWidth();
				mw=image1.getWidth();
				}
			
			for(int i=0;i<w;i++)
				{
				for(int j=0;j<h;j++)
					{
					if((image1.getRGB(i,j)-image2.getRGB(i,j))==0)
						sim++;
					}
				}
		
			System.out.println("Rank= "+(int)((sim/(mw*mh))*100));
			}catch(Exception e){System.out.println(e);}
		}
	}