<?php
set_time_limit(0);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>compare image</title>
</head>

<body>
<form id="form1" name="form1" method="post" action="index.php/compareimages/getimage">
  <table width="509" border="1" align="center">
    <tr>
      <td>First Image URL</td>
      <td><label>
        <input type="text" name="image1" id="image1" />
      </label></td>
    </tr>
    <tr>
      <td>Second Image URL</td>
      <td><label>
        <input type="text" name="image2" id="image2" />
      </label></td>
    </tr>
    <tr>
      <td colspan="2"><label>
        <input type="submit" name="button" id="button" value="Submit" />
      </label></td>
    </tr>
  </table>
  <label></label>
  <p>&nbsp;</p>
</form>
</body>
</html>
