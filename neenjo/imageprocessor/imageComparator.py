import math, operator
from PIL import Image
import cStringIO
import urllib


def compare(URL1, URL2):
    file1 = cStringIO.StringIO(urllib.urlopen(URL1).read())
    file2 = cStringIO.StringIO(urllib.urlopen(URL2).read())
    image1 = Image.open(file1)
    image2 = Image.open(file2)
    h1 = image1.histogram() 
    h2 = image2.histogram()
    maxrms = math.sqrt(reduce(operator.add,
                           map(lambda a,b: (max(a,b))**2, h1, h2))/len(h1))
    rms = math.sqrt(reduce(operator.add,
                           map(lambda a,b: (a-b)**2, h1, h2))/len(h1))
    rms=maxrms-rms
    rms=rms/maxrms
    rms=rms*100
    return rms

if __name__=='__main__':
    import sys
    URL1, URL2 = sys.argv[1:]
    print compare(URL1, URL2)