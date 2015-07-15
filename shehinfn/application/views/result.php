<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<img src="<?php echo $image1; ?>" width="500" height="500" hspace="50" />
<img src="<?php echo $image2; ?>" width="500" height="500" /> <br /><br /><br />
<?php
if($image==0)
{
	echo "The images are same";
}
if($image>4)
{
	echo "The images are different";
	echo " <br > The percentage similarity is : ".(256-$image)/256*100;
	
}
if($image==1)
{
	echo "Different light and contrast.";
	echo "<br > The percentage similarity is : ".(256-$image)/256*100;
}
if($image==4)
{
	echo "Different size. And aspect ratio.";
	echo " <br > The percentage similarity is : ".(256-$image)/256*100;
}
if($image==2)
{
	echo "The images are of different size";
	echo " <br > The percentage similarity is : ".(256-$image)/256*100;
}
?>

</body>
</html>
