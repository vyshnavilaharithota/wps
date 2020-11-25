<?php

function base64_url_decode($input)
{
return base64_decode(strtr($input, '-_,', '+/='));
}

$conn = mysqli_connect("localhost", "root", "", "test");
$blog = null;
if (!$_GET['id'])
    header("Location: index.php");
$id = base64_decode( $_GET['id']);
if (!$conn) {
    echo "connection failed";
} else {
    $sql = "SELECT * from blog where id=$id";
    $result = mysqli_query($conn, $sql);
    if ($result) {
        if (mysqli_num_rows($result) > 0)
            $blog = mysqli_fetch_assoc($result);
        else
            echo "Blog Not found";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
    $conn->close();
}
?>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Document</title>
</head>

<body style="background-image: url('bg.jpg');background-repeat: no-repeat;background-size: cover;">
    <br>
    <br>
    <div class="container">
        <h2><?php echo htmlspecialchars_decode($blog['title']); ?></h2>
       
        <p><?php echo htmlspecialchars_decode($blog['body']); ?></p>
        <br>
        <a href="index.php" class="btn " style="background-color: #d81b60;color:white">Back to Home</a>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>

</html>