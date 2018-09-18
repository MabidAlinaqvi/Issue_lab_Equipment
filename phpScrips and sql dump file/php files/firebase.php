<?php
require "db_connect.php";
$message=$_POST['selected'];
$name = $_POST['user'];
$receiver=$_POST['receive'];

$sql2="SELECT quantity from comp_list WHERE Comp_name='$message'";
$result2=mysqli_query($conn,$sql2);
$row=mysqli_fetch_assoc($result2);
$quantity=$row['quantity'];
if($quantity>0)
{
if($receiver=='amir.khurrum@namal.edu.pk')
{
	$msg = array
	(
		'message' 	=> $message,
		'sender'		=> $name,
		'rejec'			=>'admin'
	);
}
else {
$msg = array
(
	'message' 	=> $message,
	'sender'		=> $name,
	'rejec'			=>'issue'
);
}
$sql="select token from tokens where user_name= '$receiver'";
$result=mysqli_query($conn,$sql);
$row=mysqli_fetch_assoc($result);
$tokenis=$row['token'];
$path_to_fcm = 'https://fcm.googleapis.com/fcm/send';  //is it correct for my porject
$server_key = "AAAALWZSgVE:APA91bFdQxD9YG0Jj3UOPwbDFzT60NlK8ti9xyYFX5m6sR48O2aK1DurZgXaSKDU9RctDIxi-NwvLYE-2LoMv_w1kXseLeqzCqQv_sviVxdcqco3-V3jvIYnFUgg1t7t_kJurWsf-_vG";
$key=$tokenis;
$headers = array( 'Content-Type:application/json', 'Authorization:Key=' .$server_key );
$fields = array
(
  'to' =>$key,
  'data'=>$msg
  );
$payload = json_encode($fields);
//echo ($payload);
$curl_session = curl_init();
curl_setopt($curl_session, CURLOPT_URL, $path_to_fcm);
curl_setopt($curl_session, CURLOPT_POST, true);
curl_setopt($curl_session, CURLOPT_HTTPHEADER, $headers);
curl_setopt($curl_session, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl_session, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($curl_session, CURLOPT_IPRESOLVE, CURL_IPRESOLVE_V4);
curl_setopt($curl_session, CURLOPT_POSTFIELDS, $payload);
$result=curl_exec($curl_session);
curl_close($curl_session);
}
else {
	echo "out";
}
mysqli_close($conn);
?>
