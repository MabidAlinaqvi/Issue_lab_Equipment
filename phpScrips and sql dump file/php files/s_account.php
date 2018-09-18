<?php
require "db_connect.php";
$name = json_decode(file_get_contents("php://input"),true);

$sql="SELECT * FROM `".$name['namess']."`";

$result=mysqli_query($conn,$sql);

if(mysqli_num_rows($result)>0)
{

while ($row=mysqli_fetch_assoc($result)) {


$names[]= array('com_name' => $row["comp_name"], 'is_date' => $row["issue_date"],'du_date' => $row["due_date"]);

}
echo json_encode($names);
}
else{
  echo "error";
}
?>
