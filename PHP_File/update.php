<?php
	
	require 'database.php';
	
	$attribute1 = $_POST['choose1'];
	$old_val = $_POST['oldval'];
	$attribute2 = $_POST['choose2'];
	$new_val = $_POST['newval'];
	
	$query = "select * from admin where $attribute1 = '$old_val'";
	$check = mysql_query($query);
	$exist = mysql_fetch_assoc ($check);
	
	$query = "Update admin set $attribute2 = '$new_val' where $attribute1 = '$old_val'";
	$check = mysql_query($query);
	if($exist)
	{
		if(!$check)
		{
			echo 'Problem in Updating data';
			#header("refresh : 2; url = update.html");
		}
		else
		{
			echo 'Data successfully Updated';
			#header("refresh : 2; url = update.html");
		}
	}
	else
	{
		echo 'Data not found. Try again!';
		#header("refresh : 2; url = update.html");
	}
?>