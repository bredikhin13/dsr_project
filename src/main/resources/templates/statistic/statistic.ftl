<#include "/part/header.ftl">
<script>
    $(document).ready(function () {
        $("#navStatistic").addClass("active");
        $.ajax({
            type: 'POST',
            url: "/word/show",
            success: function (result) {
                result.forEach(function (item, i, result) {
                            var percents;
                            if (item.callCount == 0 || item.trueCount == 0) {
                                percents = 0;
                            } else {
                                percents = item.trueCount * 100 / item.callCount;
                                percents.toFixed(1);
                            }
                            $("#tblWords tbody").append(
                                    "<tr>" +
                                    "<td>" + item.word + "</td>" +
                                    "<td>" + item.translate + "</td>" +
                                    "<td>" + item.callCount + "</td>" +
                                    "<td>" + item.trueCount + "</td>" +
                                    "<td>" + percents + "</td>" +
                                    "</tr>"
                            );

                        }
                );
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        })
        ;

        $.ajax({
            type: 'POST',
            url: "/training/getall",
            success: function (result) {
                result.forEach(function (item, i, result) {
                            var avgPoints;
                            if (item.points == 0 || item.callCount == 0) {
                                avgPoints = 0;
                            } else {
                                avgPoints = item.points / item.callCount;
                                avgPoints.toFixed(1);
                            }
                            $("#tblTrainings tbody").append(
                                    "<tr>" +
                                    "<td>" + item.name + "</td>" +
                                    "<td>" + item.callCount + "</td>" +
                                    "<td>" + item.bestResult + "</td>" +
                                    "<td>" + item.worstResult + "</td>" +
                                    "<td>" + item.points + "</td>" +
                                    "<td>" + avgPoints + "</td>" +
                                    "</tr>"
                            );

                        }
                );
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        })
        ;
    })
    ;
</script>


<ul class="nav nav-tabs">
    <li class="active"><a href="#home" data-toggle="tab">Тренировки</a></li>
    <li><a href="#profile" data-toggle="tab">Слова</a></li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
    <div class="tab-pane active" id="home">
        <div class="scrltable">
            <table class="table table-striped" id="tblTrainings">
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Количство попыток</th>
                    <th>Лучший результат</th>
                    <th>Худший результат</th>
                    <th>Очков всего</th>
                    <th>Очков в среднем</th>
                </tr>
                </thead>
                <tbody>

                </tbody>

            </table>
        </div>
    </div>
    <div class="tab-pane" id="profile">
        <div class="scrltable">
            <table class="table table-striped" id="tblWords">
                <thead>
                <tr>
                    <th>Слово</th>
                    <th>Перевод</th>
                    <th>Показы</th>
                    <th>Правильные ответы</th>
                    <th>% правильных ответов</th>
                </tr>
                </thead>
                <tbody>

                </tbody>

            </table>
        </div>
    </div>
</div>
<#include "/part/footer.ftl">