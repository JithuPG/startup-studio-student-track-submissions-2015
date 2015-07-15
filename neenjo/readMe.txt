CONCEPT:

The histogram of an image shows the pixel intensity values and hence can be used as criteria for measuring the intensity.

Usage: imageComparator.py link1 link2

What our program does :

*The program code accepts two links of images as command line arguments

*It forms the histograms of the two images

*It then finds the root mean square values of the pixel intensities using the histogram which has 768 tuples in case of an RGB image.

*Now with the maximum RMS value we express the Rms value obtained,as percentage


REQUIREMENTS

For executing the code you need to have Python Image Library (PIL) 
PIL is compatible only with python 2.7 or lower versions. Its not available and doesnt with higher versions of python 2.7 like python 3.3


  
