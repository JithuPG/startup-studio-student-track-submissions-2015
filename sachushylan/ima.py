from itertools import izip
from PIL import Image
import urllib, cStringIO
import Tkinter


#type the url of image in the given format file1 = cStringIO.StringIO(urllib.urlopen("<url>").read())
#root=Tkinter.Tk()
#text =Text(root)
#tex=Text(root)

#print text
file1 = cStringIO.StringIO(urllib.urlopen("http://www.indiancinemagallery.com/images/profile/thumb_Priyanka-Chopra4692.jpg").read())
file2 = cStringIO.StringIO(urllib.urlopen("http://media2.intoday.in/indiatoday/images/stories/priyanka-chopra_660_042313054728_020614072843.jpg").read())
i1 = Image.open(file1)
i2 = Image.open(file2)
print i1.mode == i2.mode, "Different kinds of images."
print i1.size == i2.size, "Different sizes."

 
pairs = izip(i1.getdata(), i2.getdata())
if len(i1.getbands()) == 1:
    # for gray-scale jpegs
    dif = sum(abs(p1-p2) for p1,p2 in pairs)
else:
    dif = sum(abs(c1-c2) for p1,p2 in pairs for c1,c2 in zip(p1,p2))
 
ncomponents = i1.size[0] * i1.size[1] * 3
print "Difference (percentage):", (dif / 255.0 * 100) / ncomponents
#root.mainloop()
