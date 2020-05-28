function getAds(filter) {
    const json = {
        "action": "index",
        "filter": filter
    };
    let success = function (data) {
        let tasks = JSON.parse(data);
        console.log(tasks);
        getEnter(tasks);
        showAds(tasks);
    };
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        async: true,
        success: success
    });
}

function showAds(tasks) {
    let list = tasks.list;
    let $ads = $('#ads');
    $ads.html('');
    console.log(list);
    if (list.length === 0) {
        $ads.html(`<div class="center"><span style="color: red">нет данных</span></div>`);
        return;
    }
    $(list).each(function (index, v) {
        let id = v.id;
        let sold = `<img alt='продажа' src='/img/green.png'/>`;
        if (v.status === "yes") {
            sold = `<img alt='продано' src='/img/sold.png'/>`;
        }
        let name = v["foto"][0].name;
        let foto = v["foto"][0].values;
        let $row = $("<div style='margin: 0; padding: 0;'>").appendTo($ads);
        $row.append(`<div class='btn btn-link' type='button' id='${id}' onclick='pathView(this)'>
                             <img class='i250115' alt ='${name}' src='${foto}'/>
                <p class="view">${v["auto"].brand.values} ${v["auto"].model.values} ${v["auto"].year.values} год. цена 1$ ${sold}</p></div>`);
    });

}

function pathView(input) {
    document.location.href = '/view?=' + input.id;
}

function checkSelect() {
    let brand = $('body #brand :selected').val();
    let engine = $('body #engine :selected').val();
    let year = $('body #year :selected').val();
    let color = $('body #color :selected').val();
    if (brand === '' && engine === '' && year === '' && color === '') {
        $('#bt0').attr('disabled', 'disabled');
        let $model = $('#model');
        $model.attr('disabled', 'disabled');
        $model.html('<option value="">модель</option>');
    } else {
        $('#bt0').attr('disabled', false);
    }
}

// noinspection DuplicatedCode
function getBrand(input) {
    let $bt0 = $('#bt0');
    let $model = $('#model');
    let brand = $('body #brand :selected').val();
    if (brand === '') {
        $bt0.attr('disabled', 'disabled');
        $model.attr('disabled', 'disabled');
        $model.html('<option value="">модель</option>');
        return;
    }
    $bt0.attr('disabled', false);
    let val = input["value"];
    let map = new Map([
        ['1', "bmw"],
        ['2', "mercedes"],
        ['3', "toyota"],
        ['4', "lexus"]
    ]);
    let message = map.get(val);
    console.log(message);
    const json = {
        "action": "model",
        "filter": message
    };
    let success = function (data) {
        if (data === '') {
            $model.html('<option value="">модель</option>');
            $model.attr('disabled', 'disabled');
            return;
        }
        let tasks = JSON.parse(data);
        let set = tasks.set.sort((a, b) => a.id - b.id);
        console.log(set);
        $model.attr('disabled', false);
        $model.html('<option value="">модель</option>');
        for (let i = 0; i < set.length; i++) {
            $model.append('<option value="' + set[i].id + '">' + set[i].values + '</option>');
            console.log(i + ' : ' + set[i].id + ' : ' + set[i].values);
        }
    }
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        async: true,
        success: success
    });
}
