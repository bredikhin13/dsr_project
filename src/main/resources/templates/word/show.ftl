<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>jSchool 2016</title>

    <!-- Bootstrap -->
    <link href="/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script type="text/javascript" src="/assets/jquery/jquery-3.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="/assets/bootstrap/js/bootstrap.min.js"></script>

    <script>
       $('.btn').click(function () {
           var btn = $(this);
           btn.style.backgroundColor = "blue";
       })

        function trans() {
            var formData = {text: document.getElementById("in").value};
            $.ajax({
                type: 'POST',
                url: "/word/load",
                data: formData,
                dataType: 'JSON',
                success: function (result) {
                    document.getElementById("group_in").style.display = "none";
                    document.getElementById("out").value = result.text[0];
                    result.outputText.forEach(function (item, i, outputText) {
                        $('.myclass').append(
                                "<form class=\"form-inline\" role=\"form\">" +
                                "<input type=\"text\" class=\"form-control\" id=\"exampleInputEmail2\" disabled value=" + result.inputText[i] + ">" +
                                "<input type=\"text\" class=\"form-control\" id=\"exampleInputPassword2\" value=" + item + " >" +
                                "<button type='button' class='btn btn-danger' style='outline: none;' data-toggle='button'><span class='glyphicon glyphicon-remove'></button>" +
                                "</form>"
                        );
                    })
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.status + ' ' + jqXHR.responseText);
                }
            });
        }

    </script>
</head>
<body>
<div class="container">
    <div class="form-group" id="group_in">
        <label for="usr">Word</label>
        <input type="text" class="form-control" id="in">
    </div>
    <div class="form-group">
        <label>Translate</label>
        <input type="text" class="form-control" id="out">
    </div>
    <div class="form-group">
        <button type="button" class="btn btn-default" onclick="trans()">Default</button>
    </div>
    <div class="myclass">

    </div>
</div>
</body>
</html>
