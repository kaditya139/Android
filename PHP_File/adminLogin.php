<?php
	
	require 'database.php';
	
	$user = $_POST['user'];
	$pass = $_POST['pass'];
	
	if($user == 'user' and $pass == 'admin')
	{
		#header("refresh : 2; url = admin.html");
		echo 'You are logged in successfully';
	}
	else
	{
		echo 'Wrong user ID or password';
	}
?>