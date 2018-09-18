<?php
require "db_connect.php";
$user_name=$_POST["user_name"];
$password=$_POST["user_pass"];
$result=mysqli_query($conn,"SELECT Email FROM teacher WHERE Email LIKE '$user_name' and password LIKE '$password';");
if(mysqli_num_rows($result)>0){
$row=mysqli_fetch_assoc($result);
$name=$row["Email"];
echo $name;
}
else{
echo "null";
}
mysqli_close($conn);
?>
