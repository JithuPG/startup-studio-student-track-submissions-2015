<?php
 header("Access-Control-Allow-Origin: *");
set_time_limit (30);
$image1=$_POST['imageUrl1'];
$image2=$_POST['imageUrl2'];

/* JSON encoding the response */
$arr= array('image1'=>getDataURI($image1,''),'image2'=>getDataURI($image2,''));
echo json_encode($arr);

//convert imageurl to dataURI
function getDataURI($image, $mime = '') {
	return 'data: '.(function_exists('mime_content_type') ? mime_content_type($image) : $mime).';base64,'.base64_encode(file_get_contents($image));
}

?>