<?php
require "db_connect.php";
$user_name = $_POST['user_id'];
$comp = $_POST['comp_name'];
$due= $_POST['due_date'];
$stat = $_POST['status'];

$sql="delete FROM requestedComp where user_id='$user_name' and comp_name='$comp'";
$result=mysqli_query($conn,$sql);
$sql2="insert into `$user_name` values ('$comp',CURDATE(),'$due')";
$result2=mysqli_query($conn,$sql2);
$sql3="insert into t_account values ('$user_name','$comp',CURDATE(),'$due')";
$result3=mysqli_query($conn,$sql3);
$sql4="UPDATE comp_list SET quantity = quantity - 1 WHERE Comp_name='$comp'";
$result4=mysqli_query($conn,$sql4);
echo "done";
mysqli_close($conn);


?>
