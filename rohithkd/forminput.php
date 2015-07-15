<p>The Image comparison rank is:
<?php
require 'image.compare.class.php';
 
$class = new compareImages;

$firstone= $_POST['i1'];

$secondone= $_POST['i2'];

echo $class->compare($firstone, $secondone);
  
?> 