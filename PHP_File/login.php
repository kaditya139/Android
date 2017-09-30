<?php

	require 'database.php';
	
	$user = $_POST['user'];
	$pass = $_POST['pass'];
	
	$query = "select * from admin where UserID = '$user' and Password = '$pass'";
	$check = mysql_query($query);
	$exist = mysql_fetch_assoc ($check);
	if(!$exist)
	{
		echo 'Your User ID or Password is invalid';
	#	header("refresh : 2; url = index.html");
	}
	else
	{
		echo 'Redirecting you to your profile';
	#	header("refresh : 2; url = profile.html");
	}

?>