<?php
require 'image.compare.class.php';
 
/*
	these two images are almost the same so the hammered distance will be less than 10
	try it with images like this:
		1. the example images
		2. two complatly different image
		3. the same image (returned number should be 0)
		4. the same image but with different size, even different aspect ratio (returned number should be 0)
	you will see how the returned number will represent the similarity of the images.
*/ 
$class = new compareImages;
echo $class->compare('http://www.indiancinemagallery.com/images/profile/thumb_Priyanka-Chopra4692.jpg','http://media2.intoday.in/indiatoday/images/stories/priyanka-chopra_660_042313054728_020614072843.jpg');
  
?>