<?php
	
	require 'database.php';
	
	$attribute = $_POST['choose'];
	$val = $_POST['val'];
	
	$query = "select * from admin where $attribute = '$val'";
	$check = mysql_query($query);
	$exist = mysql_fetch_assoc ($check);
	
	$query = "Delete from admin where $attribute = '$val'";
	$check = mysql_query($query);
	if($exist)
	{
		if(!$check)
		{
			echo 'Problem in Deleting data';
			#header("refresh : 2; url = delete.html");
		}
		else
		{
			echo 'Data successfully Deleted';
			#header("refresh : 2; url = delete.html");
		}
	}
	else
	{
		echo 'Data not found. Try again!';
		#header("refresh : 2; url = delete.html");
	}

?>