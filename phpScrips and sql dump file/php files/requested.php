<?php
require "db_connect.php";
$user=$_POST['userid'];
$msg=$_POST['msgis'];
$sql_1="SELECT status from comp_list where Comp_name='$msg'";
$result_1=mysqli_query($conn,$sql_1);
$row=mysqli_fetch_assoc($result_1);
$state= $row['status'];
$sql="INSERT INTO requestedComp VALUES ('$user','$msg','$state')";
$result=mysqli_query($conn,$sql);
mysqli_close($conn);
?>
