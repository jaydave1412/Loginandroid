<?php
$user="root";
$password="";
$host="localhost";
$database="test";
// Create connection
$conn = new mysqli($servername, $username, $password, $database);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
$name=$_POST["name"];
$uid=$_POST["UID"];
$password=$_POST["password"];
$sql= " INSERT INTO TRY (uid,name,password) VALUES ('$uid','$name','$password')";
if ($conn->query($sql) === TRUE) {
    $response=array();
    $response["status"]="yes";
    
echo json_encode($response);
} else {
    $response=array();
    $response["status"]="no";
    
echo json_encode($response);
}

$conn->close();


?>