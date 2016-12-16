<#include "/part/header.ftl">
<style>
    .font-red{
        color: red;
        font-style: italic;
    }
    .font-green{
        color: green;
        font-style: italic;
    }
</style>
<script>
    $(document).ready(function () {
        $(".btn-save").hide();
        $("#invalidField").hide();
        $("#success").hide();
        $("#navWord").addClass("active");
        $('.myclass').on('click', 'button', function () {
            var state = $(this).hasClass('active');
            $(this).parent().remove();
        });
        $("#addBtn").click(function () {
            $('.myclass').prepend(
                    "<form class='form-inline' role='form'>" +
                    "<div class='form-group'>" +
                    "<input type='text' class='form-control fld' name='word'>" +
                    "<input type='text' class='form-control fld' name='translate'>" +
                    "<button type='button' class='btn btn-default' style='outline: none;'  onfocus='this.blur()' data-toggle='button'><span class='glyphicon glyphicon-remove'></button>" +
                    "</div>" +
                    "</form>"
            );
            $(".btn-save").show();
        });
    });

    function checkFields() {
        var flag = true;
        $(".fld").each(function () {
            if($(this).val()==""){
                $("#success").hide();
                $("#invalidField").show();
                $(this).closest("div").addClass("has-warning");
                flag = false;
            }
        });
        return flag
    }


    function collect() {
        if(checkFields()) {
            var frm = $('form.form-inline');
            var data = JSON.stringify(frm.serializeArray());
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: 'POST',
                url: "/word/save",
                data: data,
                success: function (result) {
                    $("#invalidField").hide();
                    $("#success").show();
                    $("#in").val("");
                    $(".myclass").empty();
                    $('.btn-save').hide();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.status + ' ' + jqXHR.responseText);
                }
            });
        }
    }

    function trans() {
        var str = $.trim($("#in").val().toLowerCase());
        var formData = {text: str};
        $("#invalidField").hide();
        $("#success").hide();
        $(".myclass").empty();
        $.ajax({
            type: 'POST',
            url: "/word/load",
            data: formData,
            dataType: 'JSON',
            success: function (result) {
                result.outputText.forEach(function (item, i, outputText) {
                    $('.myclass').append(
                            "<form class='form-inline' role='form'>" +
                            "<div class='form-group'>" +
                            "<input type='text' class='form-control fld' name='word'  value=" + result.inputText[i] + ">" +
                            "<input type='text' class='form-control fld' name='translate' value=" + item + " >" +
                            "<button type='button' class='btn btn-default' style='outline: none;'  onfocus='this.blur()' data-toggle='button'><span class='glyphicon glyphicon-remove'></button>" +
                            "</div>" +
                            "</form>"
                    );
                });
                $(".btn-save").show();
            }

        });
    }

</script>

<div class="form-group col-sm-7" id="group_in">
    <p>Введите слова для перевода с английского языка на русский в текстовое поле. Максимум 1000 символов.</p>
    <p>Для добавления отдельной пары слов нажмите на +.</p>
    <label for="usr">Текст</label>
    <textarea class="form-control" rows="5" id="in" maxlength="1000"></textarea>
    <div id="invalidField">
        <p class="font-red">Все активные поля должны быть заполнены!</p>
    </div>
    <div id="success">
        <p class="font-green">Слова сохранены в базу</p>
    </div>
</div>
<div class="form-group btn-toolbar col-sm-7" role="toolbar">
    <div class="btn-group">
        <button type="button" class="btn btn-primary" onclick="trans()">Перевести</button>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-primary" id="addBtn""><span class="glyphicon glyphicon-plus"></span></button>
    </div>
</div>
<div class="form-group col-sm-7 myclass">

</div>

<div class="form-group col-sm-7 btn-save">

    <button type="button" class="btn btn-primary" onclick="collect()">Сохранить</button>
</div>
<#include "/part/footer.ftl">