<?php
$user="root";
$password="";
$host="localhost";
$database="test";

// Create connection
$conn = new mysqli($servername, $username, $password, $database);
// Check connection
if ($conn->connect_error) {
    echo "hi";
    die("Connection failed: " . $conn->connect_error);
}
$uid=$_POST["UID"];
$password=$_POST["password"];
$sql= "SELECT * from try where uid ='$uid' and password ='$password'";
$result=mysqli_query($conn,$sql);
if(mysqli_num_rows($result)==1)
{
    $response=array();
    $sql1= "SELECT * from try where uid ='1'";
    $result1=mysqli_query($conn,$sql);
    $user=mysqli_fetch_assoc($result1);
    $response["UID"]=$user['uid'];
    $response["name"]=$user['name'];
    $response["status"]="success";
    echo json_encode($response);


}
else
{
    $response=array();
    $response["status"]="fail";
    echo json_encode($response);
}
?>