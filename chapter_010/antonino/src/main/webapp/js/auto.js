$(document).ready(function () {
    setInterval('window.location.reload()', 600000);
    setFilter();
    setCalendar()
    getAds(1);
    let form = $('#searches').html(search);
    form.append(`<input type="checkbox" id="reset" name="reset" value="" onclick="resetSearch(this)"/>
                    <label for="reset" style="font-size: smaller">сбросить поиск</label>`);
    form.append(`<span style="font-size: smaller;">Войти как:</span><div style="height: 5px"></div>`);
    form.append(`<button class="btn btn-primary btn-md"
                                    id="btA"
                                    style="color: white; width: 130px; height: 40px; border-radius: 0;"
                                    type="button" onclick="setEnter('admin','admin')">админ
                            </button><div style="height: 5px"></div>`);
    form.append(`<button class="btn btn-primary btn-md"
                                    id="btU"
                                    style="color: white; width: 130px; height: 40px; border-radius: 0;"
                                    type="button" onclick="setEnter('555','1')">юзер5</button>`);
    form.append(`<span style="color: cadetblue; font-size: smaller;">логины: 111-555</span></br>
                 <span style="color: cadetblue; font-size: smaller;">пароль: 1</span></br>
                 <span style="color: cadetblue; font-size: smaller;">даты: 2020-05-1</span></br>
                 <span style="color: cadetblue; font-size: smaller;">даты: 2020-05-20</span></br>
                 <span style="color: cadetblue; font-size: smaller;">даты: 2020-05-30</span></br>
                 <span style="color: cadetblue; font-size: smaller;">use сбросить поиск</span></br>`);
    $('#search').submit(function (e) {
        e.preventDefault();
        let success = function (data) {
            let $bt0 = $('#bt0');
            let $ads = $('#ads');
            let $search = $('#search');
            $search.trigger('reset');
            $bt0.attr('disabled', 'disabled');
            let ads = JSON.parse(data);
            console.log(ads);
            $ads.html('');
            if (ads.list.length === 0) {
                $ads.html(`<div class="center" style="color: red;">Нет данных</div>`);
                return;
            }
            showAds(ads);
        };
        const json = {
            "action": "searches",
            "brand": $('body #brand :selected').val(),
            "model": $('body #model :selected').val(),
            "engine": $('body #engine :selected').val(),
            "year": $('body #year :selected').val(),
            "color": $('body #color :selected').val()
        };
        console.log(json);
        $.ajax({
            url: 'http://localhost:8080/controller',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(json),
            dataType: 'text',
            success: success,
        });
    });
});

function resetSearch(input) {
    let checked = input.checked;
    console.log(checked);
    if (checked) {
        window.location.reload();
    }
}

function setCalendar() {
    $(function () {
        let dateFormat = "yy-mm-dd",
            from = $('#from').datepicker({
                dateFormat: "yy-mm-dd",
                changeMonth: true,
                numberOfMonths: 1,
                changeYear: true,
            })
                .on("change", function () {
                    to.datepicker("option", "minDate", getDate(this));
                }),
            to = $('#to').datepicker({
                dateFormat: "yy-mm-dd",
                changeMonth: true,
                numberOfMonths: 1,
                changeYear: true,
            })
                .on("change", function () {
                    from.datepicker("option", "maxDate", getDate(this));
                });

        function getDate(element) {
            let date;
            try {
                date = $.datepicker.parseDate(dateFormat, element.value);
            } catch (error) {
                date = null;
            }

            return date;
        }
    });
}

function getRange() {
    success = function (data) {
        let ads = JSON.parse(data);
        console.log(ads);
        showAds(ads);
    }
    const json = {
        "action": "date",
        "start": $('#from').val(),
        "end": $('#to').val()
    }
    console.log(json);
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success,
    });

}

function setFilter() {
    $('#filters').html(`<div><label style="margin-right: 2px; font-size: smaller; color: #4285f4" for="from">from</label>
                        <input style="font-size:smaller" type="text" id="from" name="from">
                        <label style="margin-right: 2px; font-size: smaller; color: #4285f4"  for="to">to</label>
                        <input style="margin-left: 2px; font-size:smaller" type="text" id="to" name="to"></div>
                         <div><button class="btn btn-link" style="border-radius: 0; margin-left: 2px; margin-top: auto;
                          margin-bottom: auto; font-size: smaller; color: #0256b1" id="btDt" onclick="getRange()"
                          type="button">go</button></div>
                        <div style="margin-left: 203px"><select style="font-size: smaller" 
                        id="filter" name="filter" onchange="getAds(this.value)"
                        size="1"><option  style="font-size: smaller" selected value="">поиск:</option>
                        <option style="font-size: smaller" value="1">с фото</option>
                        <option style="font-size: smaller" value="2">без фото</option></select>
                        <label for="filter" id="label"><i class="fas fa-search"></i></label></div>`);
}

function setEnter(log, pass) {
    let success = function (data) {
        if (getMaps().size > 0) {
            getMaps().clear();
        }
        let answer = JSON.parse(data);
        console.log(answer);
        getEnter(answer);
        $('#btU').attr('disabled', 'disabled');
        $('#btA').attr('disabled', 'disabled');
    }
    const json = {
        "action": "login",
        "login": log,
        "password": pass
    };
    console.log(json);
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success,
    });
}

const search = `<form action="" id="search" method="post">
                        <div class="form-group">
                            <label class="sr-only" for="brand">brand</label>
                            <select class="form-control-sm" id="brand" name="brand" onchange="getBrand(this)" size="1">
                                <option value="">бренд</option>
                                <option value="1">bmw</option>
                                <option value="2">mercedes</option>
                                <option value="3">toyota</option>
                                <option value="4">lexus</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="model">model</label>
                            <select class="form-control-sm" disabled id="model" name="model" onchange="checkSelect()"
                                    size="1">
                                <option value="">модель</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="engine">engine</label>
                            <select class="form-control-sm" id="engine" name="engine" onchange="checkSelect()" size="1">
                                <option value="">мотор</option>
                                <option value="1">бензин</option>
                                <option value="2">дизель</option>
                                <option value="3">электро</option>
                                <option value="4">газ</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="year">year</label>
                            <select class="form-control-sm" id="year" name="year" onchange="checkSelect()" size="1">
                                <option value="">год</option>
                                <option value="1">2020</option>
                                <option value="2">2019</option>
                                <option value="3">2018</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="color">цвет</label>
                            <select class="form-control-sm" id="color" name="color" onchange="checkSelect()" size="1">
                                <option value="">цвет</option>
                                <option value="1">чёрный</option>
                                <option value="2">синий</option>
                                <option value="3">белый</option>
                                <option value="4">зелёный</option>
                                <option value="5">серый</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-md"
                                    disabled id="bt0"
                                    style="color: white; width: 130px; height: 40px; border-radius: 0;"
                                    type="submit">поиск
                            </button>
                        </div>
                    </form>`;
