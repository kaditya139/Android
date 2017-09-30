<?php
	require 'database.php';
	$query = "Select * From admin";
	$result = mysql_query($query);
	
	$output = array();
	
	if ($result)
	{
		while ($rows = mysql_fetch_assoc ($result))
		{
			$output[] = $rows;
		}
		echo json_encode(array('response' => $output));
	}
	else
	{
		echo "Data not found";
	}
?>