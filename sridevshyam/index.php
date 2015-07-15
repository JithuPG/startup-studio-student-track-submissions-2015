<html>
<body>
<?php
if(!isset($_POST['id1']))
{
?>
<form method="post">
First URL:<br>
<input type="text" name="id1">
<br>
Second URL:<br>
<input type="text" name="id2">
<button>Submit</button>
</form>
<?php	
}
else
{
$id1 = $_POST['id1'];
$id2 = $_POST['id2'];
require 'index2.php';
$class = new compareImages;
echo "Difference Grading = ";
echo $class->compare($id1,$id2);
}  
?>
</body>
</html>