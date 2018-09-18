<?php
require "db_connect.php";
$user_name=$_POST["user_name"];
$user_pass=$_POST["user_pass"];
$result=mysqli_query($conn,"SELECT roll from student where roll like '$user_name' and password like '$user_pass' ");
if(mysqli_num_rows($result)>0)
{
  $sql="SHOW TABLES LIKE '".$user_name."'";
  $results=mysqli_query($conn,$sql);
  if(mysqli_num_rows($results)>0)
  {
      //echo "Table exists"; //comment them because they return as response
  }
  else{
    $sql = "CREATE TABLE `$user_name`(

        comp_name VARCHAR(30) NOT NULL,

        issue_date DATE,

        due_date DATE

    )";
    if(mysqli_query($conn, $sql)){

        //echo "Table created successfully.";

    } else{

        //echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);

    }
  }

$row=mysqli_fetch_assoc($result);
$name=$row["roll"];
//echo json_encode($row);
echo "$name";
}
else{
echo "null";
}
mysqli_close($conn);
?>
