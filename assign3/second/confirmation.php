<?php
if (!isset($_POST['preview']))
    header("Location: index.php");
$title = $_POST['title'];
$body = $_POST['body'];

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

<body style="background-image: url('bg.jpg');background-repeat: no-repeat;background-size: cover;" >
    <br>
    <br><br>
    <div class="container">
        <h2><?php echo $title; ?></h2>
        <p><?php echo date("l jS \of F Y h:i:s A"); ?></p>
        <div><?php echo $body; ?></div>


        <form method="post" action="postblog.php">
            <input value="<?php echo $title; ?>" name="title" type="hidden">
            <input value="<?php echo $body; ?>" name="body" type="hidden">
            <p>
                <label>
                    <input type="checkbox" class="filled-in" name="confirmation" />
                    <span>Confirm blog</span>
                </label>
            </p>
            <button class="btn " type="submit" style="background-color: #d81b60;color:white">Save Blog</button><br>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>

</html>