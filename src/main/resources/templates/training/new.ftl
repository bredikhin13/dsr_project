<#include "/part/header.ftl">
<style>
    .scrltable {
        height: 200px !important;
        overflow: scroll;
        overflow-x: hidden;
        border-style: solid;
        border-color: #777777;
        border-top-width: 1px;
        border-left-width: 1px;
        border-right-width: 1px;
        border-bottom-width: 1px;
        border-top-left-radius: 4px;
        border-top-right-radius: 4px;
        border-bottom-left-radius: 4px;
        border-bottom-right-radius: 4px;
        margin-bottom: 10px;
    }
    .marked {
        color: red;
        font-style: italic;
    }
</style>

<script>
    var words = new Array();
    var chCount = 0;
    function collect() {
        $.each($("input[type='checkbox']:checked"),
                function () {
                    words.push($(this).attr("value"));
                });
        var name = $("#inputName").val();
        if (chCount != 10 || name == "") {
            $("#attention").show();
        } else {
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: 'POST',
                url: "/training/create",
                data: JSON.stringify({name, words}),
                success: function (result) {
                    window.location.assign("/training/choose");
                }
            });
        }
    }
    $(document).ready(function () {
        $("#attention").hide();
        $.ajax({
            type: 'POST',
            url: "/word/show",
            success: function (result) {
                result.forEach(function (item, i, result) {
                    $("#tblEntAttributes tbody").append(
                            "<tr>" +
                            "<td>" + item.word + "</td>" +
                            "<td>" + item.translate + "</td>" +
                            "<td><input type='checkbox' value='" + item.id + "'></td>" +
                            "</tr>"
                    )
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });

        $("#tblEntAttributes").on('change', 'input', function () {
            if ($(this).is(":checked")) {
                chCount++;
            } else {
                chCount--;
            }
            if (chCount >= 10) {
                $.each($("input[type='checkbox']"),
                        function () {
                            $(this).prop("disabled", !$(this).is(":checked"))
                        });
            } else {
                $.each($("input[type='checkbox']:disabled"),
                        function () {
                            $(this).prop("disabled", false);
                        });
            }
        });


    });
</script>


<div class="form-group col-sm-7">
    <p>Введи название тренировки и выбери 10 нужных слов из списка</p>
    <label>Название тренировки</label>
    <input type="text" class="form-control" id="inputName" placeholder="Название тренировки">
</div>
<div class="form-group col-sm-7">
    <div class="scrltable">
        <table class="table table-striped" id="tblEntAttributes">
            <thead>
            <tr>
                <th>Слово</th>
                <th>Перевод</th>
                <th>Выбор</th>
            </tr>
            </thead>
            <tbody>

            </tbody>

        </table>
    </div>
</div>
<div class="form-group col-sm-7" id="attention">
<p class="marked">Мало слов или нет имени!</p>
</div>
<div class="form-group col-sm-7">

        <button type="submit" onclick="collect()" class="btn btn-primary">Создать</button>

</div>

<#include "/part/footer.ftl">