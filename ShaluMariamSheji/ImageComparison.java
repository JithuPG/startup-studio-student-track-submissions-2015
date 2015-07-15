package Bluetick;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageComparison {
   
   
    public boolean compareTwoImages(File fileOne, File  fileTwo) {
        Boolean isTrue = true;
        try{
            Image imgOne = ImageIO.read(fileOne);
            Image imgTwo = ImageIO.read(fileTwo);
            BufferedImage bufImgOne = ImageIO.read(fileOne);
            BufferedImage bufImgTwo = ImageIO.read(fileTwo);
            int imgOneHt = bufImgOne.getHeight();
            int imgTwoHt = bufImgTwo.getHeight();
            int imgOneWt = bufImgOne.getWidth();
            int imgTwoWt = bufImgTwo.getWidth();
            if(imgOneHt!=imgTwoHt ||(imgOneWt!=imgTwoWt)){
                System.out.println(" size are not equal ");
                isTrue = false;
            }

            for(int x =0; x < imgOneWt; x++ ){ //replace the loop, if needed
                for(int y =0; y < imgOneHt ; y++){
                    if(bufImgOne.getRGB(x, y) != bufImgTwo.getRGB(x, y) ){
                        System.out.println(" rgb are not equal ");
                        isTrue = false;
                        break;
                    }
                }
            }
        }catch (IOException e) {
                        e.printStackTrace();
        }
        return isTrue;
    }
   
   
    public static void main(String[] softwareEngineer) {
       
        File OracleJava = new File("C:\\Image\FingerPrint\analysis.jpg");
        File javaOracle = new File("C:\\Histogram\match\image.jpg");
        ImageComparison imgComp = new ImageComparison();
        System.out.println(imgComp.compareTwoImages( OracleJava , javaOracle));
       
    }
   

}



To work the above code for different dimensional images the for loop has to replaced.

Change the for loop to the following .... for(int x =0; x < imgOneWt; x++ ){ for(int y =0; y < imgOneHt ; y++){ if(bufImgOne.getRGB(x, y) != bufImgTwo.getRGB(x, y) ){ System.out.println(" size are not equal "); isTrue = false; break; } } }﻿
