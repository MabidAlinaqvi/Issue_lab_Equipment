<?php
require "db_connect.php";

$sql="SELECT * FROM t_account";
$result=mysqli_query($conn,$sql);
if(mysqli_num_rows($result)>0)
{
while ($row=mysqli_fetch_assoc($result)) {
$names[]= array('stu_name' => $row["stud_name"],'com_name' => $row["comp_name"], 'is_date' => $row["issue_date"],'du_date' => $row["due_date"]);
}
echo json_encode($names);
}
else{
  echo "error";
}
?>
