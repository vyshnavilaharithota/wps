<?php
$conn = mysqli_connect("localhost", "root", "", "test");
$blogs = [];
$error = '';
if (!$conn) {
    echo "connection failed";
} else {
    $sql = "SELECT * from blog";
    $result = mysqli_query($conn, $sql);
    if ($result) {
        if (mysqli_num_rows($result) > 0)
            $blogs = mysqli_fetch_all($result, MYSQLI_ASSOC);
        else
            $error = "No blogs yet";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
    $conn->close();
}

function base64_url_encode($input)
{
    return strtr(base64_encode($input), '+/=', '-_,');
}

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>

<body style="background-image: url('bg1.jpg');background-repeat: no-repeat;background-size: cover;">
    <br>
    <br><br><br>
    <div class="container" style="text-align:center;">
        <h4>Post a Blog</h4>
        <br>
    </div>
    <form action="confirmation.php" method="POST">
        <div class="container">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" name="title" class="form-control" id="title" required>

            </div>

            <textarea name="body" id="editor">

        </textarea>
            <br>
            <div style="text-align: center;">
                <button type="submit" name="preview" class="btn" style="background-color: #1b5e20;color:white">Preview</button>
            </div>
        </div>
    </form>

    <div class="container">
        <br>

        <div class="row">
            <div class="col-sm-6"></div>
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <h4>Blogs List</h4>
                <?php echo $error; ?>
            </div>

            <?php foreach ($blogs as $blog) { ?>
                <div class="col-sm-6"></div>
                <div class="col-sm-3"></div>
                <div class="col-sm-3" style="padding-left: 25px;">
                    <a target="_blank" style="color:black;" href="view.php?id=<?php echo base64_url_encode($blog['id']); ?>"><?php echo $blog['title']; ?></a>
                </div>

                <br>

            <?php } ?>
        </div>
    </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/23.1.0/classic/ckeditor.js"></script>
    <script>
        ClassicEditor
            .create(document.querySelector('#editor'))
            .catch(error => {
                console.error(error);
            });
    </script>
</body>

</html>