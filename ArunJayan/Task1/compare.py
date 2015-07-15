# This a program to compare two images that stored in local storage(or in hard disk)	  
# program should run using following command :											  
# python compare.py --internet1 path/image --internet2 path/image 						  
# eg: python compare.py --internet1 http://i.stack.imgur.com/tJKoS.png --internet2 http://i.stack.imgur.com/0yVih.png
# we give the two images with path as arguments . 										  
######################################################################################################################
#importing libs.
import cv2
import numpy as np
import argparse
import urllib
ap = argparse.ArgumentParser() # Argument Parser 

#canny() will return edged out of source image
def canny(img,sigma=0.33):
	v = np.median(img)
	lower = int(max(0,(1.0-sigma)*v))
	upper = int(min(255,(1.0+sigma)*v))
	edged_img = cv2.Canny(img,lower,upper) #cv2.Canny() --> Edge detection FIlter 
	return edged_img
#count_ones count the no. pixels that have pixel value 255 (ie., white)
def count_ones(img,w,h):
	i=0
	c=0
	while(i<w):
		j=0
		while(j<h):
			if img[j,i]==255:
				c = c+1.0
			j = j+1
		i = i+1
	return c

def main():
	ap.add_argument("-i1","--internet1",required=True,help="address of image in internet")	#argument 1
	ap.add_argument("-i2","--internet2",required=True,help="address of image in internet")	#argument 2
	args = vars(ap.parse_args())
	urllib.urlretrieve(args["internet1"],"test_1.jpg")	#download image1 
	urllib.urlretrieve(args["internet2"],"test_2.jpg")	#download image2
	img1 = cv2.imread("test_1.jpg")
	img2 = cv2.imread("test_2.jpg")
	#if both image are not in same dimension program will end with a message (to implement that we are using the if block)
	if img1.shape[0]!=img2.shape[0] or img1.shape[1]!=img2.shape[1]:	
		print "Please enter images with same dimension"
		return
	canny_out1 = canny(img1)	#we perform edge detection on both image.
	canny_out2 = canny(img2)	#we perform edge detection second image . 
	o = cv2.bitwise_and(canny_out1,canny_out2) #to find the common area, we perform bitwise_and operation
	w = img1.shape[1]	# width
	h = img1.shape[0]	# height 
	c = count_ones(o,w,h) #count one's in edges of o (out of bitwise_and operation)
	#actually a image objects is a numpy array
	c1 = count_ones(canny_out1,w,h) #similarly we count ones in first source image
	#print c 
	per = (c/float(c1))*100	
	print "similarity Scale (1-100) :: %f"%(per)
	if per == 100 :	#if images are exactly same , prints a message .
		print "Exactly same"
	cv2.imshow("source image 1",img1)
	cv2.imshow("source image 2",img2)
	cv2.imshow("out",np.hstack([canny_out1,canny_out2,o]))
	#cv2.imshow("img2",canny_out2)
	#cv2.imshow("sample",o)
	cv2.waitKey(0)

main()	#running main function