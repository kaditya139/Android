<?php
	
	require 'database.php';
	
	$user = $_POST['user'];
	$pass = $_POST['pass'];
	$name = $_POST['name'];
	$email = $_POST['email'];
	
	$query = "Insert into admin values ('$user', '$pass', '$name', '$email')";
	$check = mysql_query($query);
	if(!$check)
	{
		echo 'Problem in Inserting data';
		header("refresh : 2; url = insert.html");
	}
	else
	{
		echo 'Data successfully Inserted';
		header("refresh : 2; url = insert.html");
	}
?>