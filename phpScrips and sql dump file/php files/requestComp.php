<?php
require "db_connect.php";
$sql="SELECT * FROM requestedComp";
$result=mysqli_query($conn,$sql);
if(mysqli_num_rows($result)>0)
{
while ($row=mysqli_fetch_assoc($result)) {
$comp[]= array('user' => $row["user_id"], 'component' => $row["comp_name"],'status' => $row["status"]);
}
echo json_encode($comp);
}
mysqli_close($conn);
?>
