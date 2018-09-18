<?php
	require "db_connect.php";
	
	$user_name = $_POST['use'];
	$token = $_POST['tok'];

	$sqlSelect = "select token from tokens where user_name= '$user_name'";
	
	$currentTokenInDB = mysqli_query($conn,$sqlSelect);
	$rows = mysqli_num_rows($currentTokenInDB);
	function inter_data($user_name, $token){
		$sqlInsert = "insert into tokens values ('$user_name','$token')";

    $currentToken = mysqli_query($GLOBALS['conn'],$sqlInsert);
		
		if(!currentToken)
		{
		
		}
		else{
		
		}
	}

	function update_data($user_name, $token){
		$sqlUpdate = "update tokens set token='$token' where user_name='$user_name'";
	
		 $currentToken = mysqli_query($GLOBALS['conn'],$sqlUpdate);
		if(!currentToken)
		{
			//echo 'failure';
		}
		else{
			//echo 'success';
		}
	}

	if($rows == 0){
	
		inter_data($user_name, $token);
	}

	elseif($rows == 1){
		if($token != $currentTokenInDB){
			update_data($user_name, $token);
		}
	}
	mysqli_close($conn);
?>
