/*
program which when given links to two images on the Internet, finds out how similar they are
before running this program make sure that D drive is available in your computer
the images corresponding to the urls are available in D drive as img,img1 

*/

import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
class spe
{
    public static void main(String args[]) 
    throws IOException
    {

        try{
         String targetDirectory;
         System.out.println("enter the url..");
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         String sourceUrl=br.readLine();

        URL imageUrl = new URL(sourceUrl);
        
        
        try (InputStream imageReader = new BufferedInputStream(
                imageUrl.openStream());
                OutputStream imageWriter = new BufferedOutputStream(
                new FileOutputStream("D:\\img.jpg"));) //download the image into d drive; 
        {
            int readByte;

            while ((readByte = imageReader.read()) != -1)
            {
                imageWriter.write(readByte);
            }
        }

        }
        catch(Exception e){}

        try{
    
     String targetDirectory;
     System.out.println("enter the next url");
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String sourceUrl = br.readLine();

        URL imageUrl = new URL(sourceUrl);
        try (InputStream imageReader = new BufferedInputStream(
                imageUrl.openStream());
                OutputStream imageWriter = new BufferedOutputStream(
                 new FileOutputStream("D:\\img1.jpg"));) //download as img1 into the d drive
        {
            int readByte;

            while ((readByte = imageReader.read()) != -1)
            {
                imageWriter.write(readByte);
            }
        }

    
    }catch(Exception e){} 
  
  
        int q=0;
        File file1 = new File("filename.txt");

        FileWriter fw = new FileWriter(file1.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        File file= new File("D:\\img.jpg");
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int[][] clr=  new int[width][height]; 
        File files= new File("D:\\img.jpg");
        BufferedImage images = ImageIO.read(files);
        int widthe = images.getWidth(null);
        int heighte = images.getHeight(null);
        int[][] clre=  new int[widthe][heighte]; 
        int smw=0;
        int smh=0;
        int p=0;
           
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
            
            for(int a=0;a<smw;a++)
            {
                for(int b=0;b<smh;b++)
                {
                    clre[a][b]=images.getRGB(a,b);
                    clr[a][b]=image.getRGB(a,b);
                    if(clr[a][b]==clre[a][b]) 
                    {
                    p=p+1;
                    bw.write("\t");
                    bw.write(Integer.toString(a));
                    bw.write("\t");
                    bw.write(Integer.toString(b)); 
                    bw.write("\n");
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
    float x =(100*p)/s;
    System.out.println("THE PERCENTAGE SIMILARITY IS APPROXIMATELY ="+x+"%");
    if(x==100){
                    System.out.println("images are exactly same");}
    else if(x<50){
    System.out.println("images are less similar");
        }
    else if(x>50){
    System.out.println("images are more similar");
    }
      System.out.println("NO OF PIXEL GETS VARIED:="+q);
    System.out.println("NO OF PIXEL GETS MATCHED:="+p);
  }
}