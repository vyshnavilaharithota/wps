
<?php
$conn = mysqli_connect("localhost", "root", "", "test");
if (!$conn) {
    echo "connection failed";
} else {
    if ($_POST["confirmation"]) {
        $title = htmlspecialchars($_POST["title"],ENT_QUOTES);
        $body= htmlspecialchars($_POST["body"],ENT_QUOTES);
        echo $body;
        $sql = "INSERT INTO blog (title,body) VALUES ('$title','$body')";
        if ($conn->query($sql) === TRUE) {
            echo "New record created successfully";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
        $conn->close();
    }
    header("Location: index.php");
}

?>