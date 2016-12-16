<#include "/part/header.ftl">
<script>
    $(document).ready(function () {
        $("#navChoose").addClass("active");
        $.ajax({
            type: "POST",
            url: "/training/getlist",
            success: function (result) {
                if (result.length > 0) {
                    $("#customBtn").prop("disabled", false);
                }
                result.forEach(function (item, i, result) {
                    $("#trainingSelect").append(
                            "<option value='" + item.id + "'>" + item.name + "</option>"
                    )
                });
            }
        });
        $("#customBt").click(function () {
            var idTraining = $("#trainingSelect").val();
            $.ajax({
                type: "GET",
                url: "/training/" + idTraining,
            });
        });
    });
</script>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Случайный набор</h3>
    </div>
    <div class="panel-body">
        <p>Тренировка из 10 случайных слов</p>
        <form action="random" method="get">
            <div class="form-group">
            <button type="submit" class="btn btn-primary">Начать</button>
            </div>
        </form>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Сложный набор</h3>
    </div>
    <div class="panel-body">
        <p>Тренировка из 10 слов с наименьшим количеством правильных ответов</p>
        <form action="hard" method="get">
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Начать</button>
            </div>
        </form>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Пользовательская тренировка</h3>
    </div>
    <div class="panel-body">
        <p>Тренировки составленные из пользовательских наборов слов</p>
        <form action="custom" method="get">
            <div class="form-group">
                <select name="trainingSelect" class="form-control" id="trainingSelect">
                </select>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary" id="customBtn" disabled>Начать</button>
            </div>
        </form>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Создать тренировку</h3>
    </div>
    <div class="panel-body">
        <p>Создать тренировку из 10 слов из словаря</p>
        <form action="new" method="get">
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Создать</button>
            </div>
        </form>
    </div>
</div>

<#include "/part/footer.ftl">