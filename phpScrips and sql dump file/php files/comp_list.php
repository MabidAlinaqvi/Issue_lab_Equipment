<?php
require "db_connect.php";
//$name = json_decode(file_get_contents("php://input"),true);
$sql="SELECT * FROM comp_list";
$result=mysqli_query($conn,$sql);
if(mysqli_num_rows($result)>0)
{
while ($row=mysqli_fetch_assoc($result)) {
$names[]= array('com_name' => $row["Comp_name"],'com_type' => $row["type"], 'com_stat' => $row["status"],'com_quant' => $row["quantity"]);
}
echo json_encode($names);
}
else{
  echo "error";
}
?>
