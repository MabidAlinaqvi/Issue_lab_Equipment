<?php
require "db_connect.php";
$sql="SELECT * FROM t_account";
$result=mysqli_query($conn,$sql);
if(mysqli_num_rows($result)>0)
{
while ($row=mysqli_fetch_assoc($result)) {
$comp[]= array('user' => $row["stud_name"], 'component' => $row["comp_name"]);
}
echo json_encode($comp);
}
mysqli_close($conn);

 ?>
