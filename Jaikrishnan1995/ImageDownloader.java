import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FilenameUtils;



public class ImageDownloader
{
    public static void main(String[] arguments) throws IOException
    {
        downloadImage("link|||||||||||||||||||||||||||link",
                new File("").getAbsolutePath());
    }

    public static void downloadImage(String sourceUrl, String targetDirectory)
            throws MalformedURLException, IOException, FileNotFoundException
    {
        URL imageUrl = new URL(sourceUrl);
        try (InputStream imageReader = new BufferedInputStream(
                imageUrl.openStream());
                OutputStream imageWriter = new BufferedOutputStream(
                        new FileOutputStream(targetDirectory + File.separator
                                + FilenameUtils.getName(sourceUrl)));)
        {
            int readByte;

            while ((readByte = imageReader.read()) != -1)
            {
                imageWriter.write(readByte);
            }
        }
    }

Image image = null;
try {
    URL url = new URL("link");
    image = pic1.read(url);
} catch (IOException e) {
}

Image image = null;
try {
    URL url = new URL("http://www.yahoo.com/image_to_read.jpg");
    image = pic2.read(url);
} catch (IOException e) {
}
 
public class Compare {
 
static void processImage() {
 
String file1 = "pic1.jpeg";
String file2 = "pic2.jpgeg";
 
Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
 
try {
 
PixelGrabber grab1 =new PixelGrabber(image1, 0, 0, -1, -1, false);
PixelGrabber grab2 =new PixelGrabber(image2, 0, 0, -1, -1, false);
 
int[] data1 = null;
 
if (grab1.grabPixels()) {
int width = grab1.getWidth();
int height = grab1.getHeight();
data1 = new int[width * height];
data1 = (int[]) grab1.getPixels();
}
 
int[] data2 = null;
 
if (grab2.grabPixels()) {
int width = grab2.getWidth();
int height = grab2.getHeight();
data2 = new int[width * height];
data2 = (int[]) grab2.getPixels();
}
 
System.out.println("Pixels equal: " + java.util.Arrays.equals(data1, data2));
 
} catch (InterruptedException e1) {
e1.printStackTrace();
}
}
 
public static void main(String args[]) {
processImage();
}
}

