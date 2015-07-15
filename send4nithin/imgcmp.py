from math import sqrt
from urllib import urlretrieve
import os, re, string, sys
from PIL import Image, ImageChops

def extension(url):
    match = re.search(r'.[A-Za-z]+$', url)
    if match:
        return match.group()
    else:
        return ''

def rms(list):
    sum = 0

    for item in list:
        sum = sum + item * item

    mean = sum/len(list)
    return sqrt(mean)

def make_even(im1, im2):
    if im1.size > im2.size:
        im2 = im2.resize(im1.size, Image.BICUBIC)
    elif im2 > im1:
        im1 = im1.resize(im2.size, Image.BICUBIC)

    return im1, im2

def main():
    
    print('IMAGE COMPARISON USING LINK')
    url1 = raw_input('Enter the link to the first image: ')
    url2 = raw_input('Enter the link to the second image: ')

    ext1 = extension(url1)
    ext2 = extension(url2)

    if string.upper(ext1) != string.upper(ext2):
        print ('Filetypes dont match')
        sys.exit(1)

    file1 = 'im1' + ext1
    file2 = 'im2' + ext2

    urlretrieve(url1, file1)
    urlretrieve(url2, file2)

    diffpercseq = []

    im1 = Image.open(file1)
    im2 = Image.open(file2)


    im1, im2 = make_even(im1, im2)
    diffimage = ImageChops.difference(im1, im2)


    if diffimage.getbbox() is None:
        print ('Mirror Images.The images are 100% similar.')
        print('Similarity Scale value = 100')
    else:
        pixeltupleseq = diffimage.getdata()

        pixelrmsseq = map(rms, pixeltupleseq)

        for item in pixelrmsseq:
            diffpercseq.append(item/255*100)
        avgdiff = sum(diffpercseq)/len(diffpercseq)
        similarity = 100 - avgdiff

        if avgdiff == 100:
            print ('The images are completely dissimilar.Similarity scale value = 0')
        else:
            print ('The images are %.2f%% similar. Similarity scale value = %.2f ' %(similarity, similarity))
    os.system('rm ' + file1 + ' ' + file2)

main()

