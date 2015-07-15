  <html>
  <head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>Image Comparison Application</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width">
 		<link rel="stylesheet" type="text/css" href="ourstyle.css">
 		<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
 </head>
  <body>
    <div class="container">
			<header>
				<div class="page-header">
					<h2>Enter URL in the form</h2>
					</div>
					</header>
    <form action="forminput.php" method="post">
        <input id="i1" type="text" name="i1" placeholder="Image 1"></input><input type="button" id="btn1" value="show image" />
        <br>
        <input id="i2" type="text" name="i2" placeholder="Image 2"></input><input type="button" id="btn2" value="show image" />
        <br>
        <input type="submit" value="Test it" name="submit"></input>
    </form>
<br>
<div class="row">

    
    <div class="col-md-12">
        <div class="row">

            <div class="col-md-6">
                <div id="dropzone1" class="small-drop-zone">
                	<img src="" id="img1">
                	</div>
			<div id="dropzone2" class="small-drop-zone">
					<img src="" id="img2">
			</div>
			</div>
			<div class="col-md-6">

    <h2>

        Notes

    </h2>
    <p>1. Any format (JPEG, PNG) supported. </p>
    <p>2. Images need not to be of same size </p>
    <p>3. The show image button, is there for you to check whether you load the image you &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; wished to see.
    You don't really need to click on it. You can check image comparison &nbsp; &nbsp; &nbsp;&nbsp;by clicking on "Test it" button</p>
    <p>4. We ranks images on a similarity scale from 0 -very different to 100 -exactly the same.</p>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript">
			$('#btn1').on('click', function() {
    		$('#img1').attr('src', $('#i1').val());
			});
			$('#btn2').on('click', function() {
    		$('#img2').attr('src', $('#i2').val());
			});
		</script>

</body>
</html>