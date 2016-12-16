<#include "/part/header.ftl">
<script>
    var t_words;
    var f_words;
    var training;
    var count = 0;
    var rightAnsw = 0;
    function randomInteger(min, max) {
        var rand = min + Math.random() * (max + 1 - min);
        rand = Math.floor(rand);
        return rand;
    }

    function updateTraining() {
        training.points += rightAnsw;
        training.callCount++;
        if (training.bestResult < rightAnsw) {
            training.bestResult = rightAnsw;
        }
        if (training.worstResult > rightAnsw) {
            training.worstResult = rightAnsw;
        }
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'PUT',
            url: "/training/update",
            data: JSON.stringify(training),
            success: function () {
                $(".training").hide();
                $("#name").append(training.name);
                $("#res").append(rightAnsw + "/" + t_words.length);
                $("#bestRes").append(training.bestResult);
                $(".results").show();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }

    function fillFields() {
        $("#in").text(t_words[count].word);
        var random_btn = randomInteger(1, 4);
        $("#btn" + random_btn).text(t_words[count].translate);
        $("#btn" + random_btn).val(1);
        for (i = 1; i < 5; i++) {
            if (i != random_btn) {
                $("#btn" + i).text(f_words.pop().translate);
                $("#btn" + i).val(0);
            }
        }
    }

    $(document).ready(function () {
        $(".results").hide();
        var url = window.location.href;
        var params = url.split('=');
        var urlString = params[1];
        if (!params[1]) {
            var tmp = params[0].split('/');
            urlString = tmp[4];
        }
        $.ajax({
            type: 'POST',
            url: "/training/" + urlString,
            success: function (result) {
                t_words = result.words;
                f_words = result.fakeWords;
                result.words = [];
                result.fakeWords = [];
                training = result;
                fillFields();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });

        $(".btn").click(function () {
            t_words[count].callCount++;
            if ($(this).attr("value") == 1) {
                $("#mark" + (count + 1)).removeClass("btn-default").addClass("btn-success");
                t_words[count].trueCount++;
                rightAnsw++;
            } else {
                $("#mark" + (count + 1)).removeClass("btn-default").addClass("btn-danger");
            }
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: 'PUT',
                url: "/word/update",
                data: JSON.stringify(t_words[count]),
                success: function () {
                    count++;
                    if (count < t_words.length) {
                        fillFields();
                    } else {
                        updateTraining();
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.status + ' ' + jqXHR.responseText);
                }
            });

        });


    });

</script>
<div class="form-group col-md-7">
    <div class="btn-group">
        <button type="button" class="btn btn-default" disabled id="mark1">1</button>
        <button type="button" class="btn btn-default" disabled id="mark2">2</button>
        <button type="button" class="btn btn-default" disabled id="mark3">3</button>
        <button type="button" class="btn btn-default" disabled id="mark4">4</button>
        <button type="button" class="btn btn-default" disabled id="mark5">5</button>
        <button type="button" class="btn btn-default" disabled id="mark6">6</button>
        <button type="button" class="btn btn-default" disabled id="mark7">7</button>
        <button type="button" class="btn btn-default" disabled id="mark8">8</button>
        <button type="button" class="btn btn-default" disabled id="mark9">9</button>
        <button type="button" class="btn btn-default" disabled id="mark10">10</button>
    </div>
</div>
<div class="training">
    <div class="form-group col-md-7" id="group_in">
        <label>Слово:</label>
        <h2 id="in"></h2>
    </div>
    <div class="form-group col-md-7">
        <div class="btn-group">
            <button type="button" class="btn btn-default" style="outline: none;" onfocus="this.blur()" id="btn1">1
            </button>
            <button type="button" class="btn btn-default" style="outline: none;" onfocus="this.blur()" id="btn2">2
            </button>
            <button type="button" class="btn btn-default" style="outline: none;" onfocus="this.blur()" id="btn3">3
            </button>
            <button type="button" class="btn btn-default" style="outline: none;" onfocus="this.blur()" id="btn4">4
            </button>
        </div>
    </div>
</div>
<div class="results form-group col-md-7">
    <p>Поздравляем! Тренировка окончена!</p>
    <label>Название тренировки: </label><p id="name"></p>
    <label>Ваш результат: </label><p id="res"></p>
    <label>Лучший результат: </label><p id="bestRes"></p>
</div>
<#include "/part/footer.ftl">