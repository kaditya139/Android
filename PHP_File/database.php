<?php

	$mysql_host = 'localhost';
	$mysql_user = 'root';

	if(!@mysql_connect ($mysql_host, $mysql_user)){
		die('Cannot connect to database');
	}
	else{
		if(@mysql_select_db('project')){
			#echo "Connection Success";
		}
		else{
			die('Cannot connect to database');
		}
	}

?>