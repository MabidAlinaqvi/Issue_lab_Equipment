<?php
require "db_connect.php";
$name=json_decode(file_get_contents("php://input"),true);
$sql="select Comp_name from comp_list WHERE type='".$name['data']."'";

$result=mysqli_query($conn,$sql);
if ($row=mysqli_num_rows($result)>0) {
  while($row=mysqli_fetch_assoc($result))
  {
    $names[]=array("comp_name"=>$row["Comp_name"]);
  }
  echo json_encode($names);
}
else {
  echo "error";
}
mysqli_close($conn);
 ?>
