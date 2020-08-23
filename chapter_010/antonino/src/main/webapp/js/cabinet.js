let tasks = null;
let user = null;
let get64 = null;
let name = null;
$(document).ready(function () {
    user = onLoad();
    switch (user.role) {
        case "admin":
            getUsersByAdmin();
            break;
        case "user":
            getAdsByUser();
            $('#searches').append(linkAdd);
            break;
        default:
            document.location.href = "/antonino";
            break;
    }
    $('#visitor').html(`<div class="d-flex justify-content-end" style="color: #4285f4; padding-right: 10px">
<button class="btn btn-link" type="button" onclick="setOutCabinet()" id="btnOutCabinet">выйти</button></div>`);
});

function getUsersByAdmin() {
    let success = function (data) {
        tasks = JSON.parse(data);
        //console.log(tasks.list);
        let $ads = $('#ads');
        if (tasks.size === '0') {
            document.location.href = "/antonino";
            return;
        } else if (tasks.list.length === 0) {
            noData($ads);
        } else {
            let $head = $('#headBase');
            let $body = $('#bodyBase');
            $head.html('');
            $body.html('');
            $head.html(`<tr><th>#</th><th>ads</th><th>имя</th><th>телефон</th><th>почта</th><th>удалить</th></tr>`);
            $head.attr('style', 'font-size: smaller');
            $body.attr('style', 'font-size: smaller');
            for (let v of tasks.list) {
                let $tr = $("<tr id=" + v.id + ">").appendTo($body);
                $tr.append(`<td><span class="badge">${v.id}</span></td>`);
                $tr.append(`<td>${v["ads"].length}</td>`);
                $tr.append(`<td><button class="btn btn-link btn-sm" id="${v.id}"
                        style="color:#4285f4;" type="button"
                        onclick="viewAdsByAdmin(this)">${v.name}</button></td>`);
                $tr.append(`<td>${v.phone}</td>`);
                $tr.append(`<td>${v.email}</td>`);
                $tr.append(`<td><button class="btn btn-warning btn-sm"
                        style="background-color:#EE5C60; border-color:firebrick;  color: white; border-radius: 0;"
                        name="${v.id}" id="${user.role}" type="button"
                        onclick="deleteUserByAdmin(this)">удалить</button></td>`);
            }
        }
        $ads.append(back);
        $('#searches').append(demand);
    }
    const json = {
        "action": "cabinetByRole",
        "role": user.role,
        "name": user.name
    };
    //console.log(json);
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success,
    });
}

function viewAdsByAdmin(input) {
    let $head = $('#headBase');
    let $body = $('#bodyBase');
    let $back = $('#back');
    let $searches = $('#searches');
    $body.html('');
    $head.html('');
    $back.html('');
    $searches.html('');
    $back.html(_back);
    $head.html(`<tr><th>#</th><th>статус</th><th style="text-align: center">продам</th>
                <th style="text-align: center">фото</th><th>телефон</th><th>удалить</th></tr>`);
    let number = parseInt(input.id);
    let user = tasks.list.find(one => one.id === number);
   // console.log(user);
    // noinspection DuplicatedCode
    user["ads"].forEach(v => {
        let id = v.id;
        let status = v.status;
        let year = v["auto"].year.values;
        let brand = v["auto"].brand.values;
        let model = v["auto"].model.values;
        let alt = v["foto"][0].name;
        let foto = v["foto"][0].values;
        let $tr = $(`<tr id=` + id + `>`).appendTo($body);
        $tr.append(`<td><span class="badge">${id}</span></td>`);
        if (status === 'no') {
            $tr.append(`<td style="text-align: center; padding-top: 21px"><img alt="продажа" src="/img/green.png"/></td>`);
        } else {
            $tr.append(`<td style="text-align: center; padding-top: 21px"><img alt="продано" src="/img/sold.png"/></td>`);
        }
        $tr.append(`<td>` + brand + ' ' + model + ' ' + year + `год` + `</td>`);
        $tr.append(`<td><div class="center"><button class="btn btn-link btn-sm" id="${id}" type="button">
                    <img style="width: 200px; height: 111px;" alt="${alt}" src="${foto}"/></button></div></td>`);
        $tr.append(`<td>${user.phone}</td>`);
        $tr.append(`<td><button class="btn btn-warning btn-sm"
                        style="background-color:#EE5C60; border-color:firebrick; color: white; border-radius: 0;"
                        id="ads_${id}" name=${user.id} type="button"
                        onclick="deleteAds(this)">удалить</button></td>`);
    });
}

function getAdsByUser() {
    let success = function (data) {
        tasks = JSON.parse(data);
        /*console.log(tasks);*/
        if (tasks.size === '0') {
            document.location.href = "/antonino";
        } else if (tasks.list["ads"].length === 0) {
            noData($('#ads'));
        } else {
            viewAds(tasks);
        }
    }
    const json = {
        "action": "cabinetByRole",
        "role": user.role,
        "name": user.name
    };
    //console.log(json);
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success,
    });
}

function deleteUserByAdmin(input) {
    let id = input.name;
    let success = function (data) {
        let tasks = JSON.parse(data);
        //console.log(tasks.name);
        if (tasks.name === 'ok') {
            delTask(id);
        }
    }

    const json = {
        "action": "delU",
        "role": input.id,
        "id": id
    };
    //console.log(json);
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success,
    });
}

function deleteAds(input) {
    let id = input.id.split('_')[1];
    //console.log(id);
    let success = function (data) {
        let tasks = JSON.parse(data);
        //console.log(tasks.name);
        if (tasks.name === 'ok') {
            delTask(id);
        }
    }

    const json = {
        "action": "delA",
        "role": user.role,
        "idU": input.name,
        "id": id
    };
    //console.log(json);
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success,
    });
}

function viewAds(answer) {
    let $head = $('#headBase');
    let $body = $('#bodyBase');
    let $back = $('#back');
    let $ads = $('#ads');
    $body.html('');
    $head.html('');
    $back.html('');
    $back.html(back);
    $head.html(`<tr><th>#</th><th>статус</th><th style="text-align: center">продам</th>
                <th style="text-align: center">фото</th><th>обновить</th><th>удалить</th></tr>`);
    $head.attr('style', 'font-size: smaller');
    $body.attr('style', 'font-size: smaller');
    let $user = answer.list;
    // noinspection DuplicatedCode
    answer.list["ads"].forEach(v => {
        let id = v.id;
        let status = v.status;
        let year = v["auto"].year.values;
        let brand = v["auto"].brand.values;
        let model = v["auto"].model.values;
        let alt = v["foto"][0].name;
        let foto = v["foto"][0].values;
        let $tr = $(`<tr id=` + id + `>`).appendTo($body);
        $tr.append(`<td><span class="badge">${id}</span></td>`);
        if (status === 'no') {
            $tr.append(`<td style="text-align: center; padding-top: 21px"><img alt="продажа" src="/img/green.png"/></td>`);
        } else {
            $tr.append(`<td style="text-align: center; padding-top: 21px"><img alt="продано" src="/img/sold.png"/></td>`);
        }
        $tr.append(`<td>` + brand + ' ' + model + ' ' + year + `год` + `</td>`);
        $tr.append(`<td><div class="center"><button class="btn btn-link btn-sm" id="${id}" type="button">
                    <img style="width: 200px; height: 111px;" alt="${alt}" src="${foto}"/></button></div></td>`);
        $tr.append(`<td><button class="btn btn-info btn-sm"
                        style="background-color:darkorange; border-color:firebrick; color: white; border-radius: 0;"
                        id="ads_${id}" name=${$user.id} type="button"
                        onclick="getEditForm(this)">обновить</button></td>`);
        $tr.append(`<td><button class="btn btn-warning btn-sm"
                        style="background-color:#EE5C60; border-color:firebrick; color: white; border-radius: 0;"
                        id="ads_${id}" name=${$user.id} type="button"
                        onclick="deleteAds(this)">удалить</button></td>`);
    });
    $ads.append(back);
}

function setOutCabinet() {
    let success = function (data) {
        let tasks = JSON.parse(data);
        /*console.log(tasks);*/
        if (tasks.name === "no") {
            document.location.href = '/antonino';
        }
    }
    const json = {
        "action": "logout"
    };
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success,
    });
}

function onLoad() {
    let User = {
        role: 'null',
        name: 'null'
    }
    let split1 = window.location.href.split("?")[1];
    if (split1 === undefined) {
        return User;
    }
    User.role = split1.split("=")[0];
    User.name = split1.split("=")[1];
    if (User.role === undefined || User.name === undefined) {
        User.role = 'null';
        User.name = 'null';
    }
    return User;
}

function noData(ads) {
    ads.html('');
    ads.html(`<div class="center"><span style="color: red;">Нет данных</span></div>`);
}

function delTask(id) {
    document.getElementById(id).style.display = 'none';
}

function reload() {
    window.location.reload();
}

function checkFillForm() {
    let color = $('body #colorE :selected').val();
    let status = $('body #statusE :selected').val();
    if (color !== '' || status !== '') {
        $('#edited').attr('disabled', false);
    } else {
        $('#edited').attr('disabled', 'disabled');
    }
}

function getSplitId(input, position) {
    return input.id.split('_')[position];
}

function getEditForm(input) {
    const id = getSplitId(input, 1);
    let $ads = $('#ads');
    $ads.html('');
    $ads.html(formEdit(id));
    $(`<div id="back" style="margin-top: 25px; margin-left: 37px; padding-right: 13px">`).appendTo($ads);
    $('#back').append(_back);
}

function formEdit(ida) {
    return `<div class="center" style="width: 200px; margin-top: 25px">
                        <form action="" method="POST">
                            <div class="form-group">
                            <label class="sr-only" for="colorE">color</label>
                            <select class="form-control-sm" id="colorE" name="colorE"
                            style="width: auto"
                            onchange="checkFillForm()" size="1">
                                <option value="">цвет</option>
                                <option value="1">чёрный</option>
                                <option value="2">синий</option>
                                <option value="3">белый</option>
                                <option value="4">зелёный</option>
                                <option value="5">серый</option>
                            </select>
                            </div>
                             <div class="form-group">
                             <label class="sr-only" for="statusE">status</label>
                            <select class="form-control-sm" id="statusE" name="statusE"
                            style="width: auto"
                            onchange="checkFillForm()" size="1">
                                <option value="">продано:</option>
                                <option value="1">да</option>
                                <option value="2">нет</option>
                            </select>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-md"
                                        disabled="" id="edited" name="bt4_${ida}"
                                        onclick="editAds(this)"
                                        style="color: white; width: 130px; height: 40px; border-radius: 0;"
                                        type="button">Сохранить
                                </button>
                            </div>
                        </form>
                    </div>`;

}

function editAds(input) {
    let success = function (data) {
        let user = JSON.parse(data);
        if (user["name"] !== "no") {
            //console.log(user["ads"]);
            tasks = user["ads"];
            reload();
        }
    }
    const json = {
            "action": "editA",
            "id": input.name.split('_')[1],
            "color": $('#colorE :selected').val(),
            "status": $('#statusE :selected').val()
        }
    ;
    /*console.log(json)*/
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success,
    });

}

function viewAdd() {
    let $ads = $('#ads');
    let $searches = $('#searches');
    $ads.html('');
    $searches.html('');
    $ads.html(formAddAds);
    $(`<div id="back" style="margin-top: 25px; margin-left: 37px; padding-right: 13px">`).appendTo($ads);
    $('#back').append(_back);
}

// noinspection DuplicatedCode
function encodeImageFileAsURL(element) {
    let brand = $('body #brandAdd :selected').val();
    let model = $('body #modelAdd :selected').val();
    let engine = $('body #engineAdd :selected').val();
    let year = $('body #yearAdd :selected').val();
    let color = $('body #colorAdd :selected').val();
    if (brand === '' || model === '' || engine === '' || year === '' || color === '') {
        return;
    }
    let win = document["forms"][0]["file"]["files"][0];
    /*console.log(document["forms"][0]["file"]["files"][0]);*/
    if (win === undefined) {
        $('#bt5').attr('disabled', false);
        get64 = "";
        return;
    }
    let size = win.size;
    let type = win.type;
    name = win.name;
    let isSize = size < 500000;
    let isType = (type === 'image/png') || (type === 'image/jpeg') || (type === 'image/jpg');
    if (!isSize || !isType) {
        alert('размер файла не больше 50kb, тип файла: png/jpeg/jpg.');
        $('#bt5').attr('disabled', 'disabled');
    } else {
        $('#bt5').attr('disabled', false);
        let file = element["files"][0];
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onloadend = function () {
            get64 = reader.result;
        }
    }
}

function checkSelect() {
    let engine = $('body #engineAdd :selected').val();
    let year = $('body #yearAdd :selected').val();
    let color = $('body #colorAdd :selected').val();
    if (engine === '' || year === '' || color === '') {
        $('#bt5').attr('disabled', 'disabled');
    } else {
        $('#bt5').attr('disabled', false);
    }
}

// noinspection DuplicatedCode
function getBrands(input) {
    let $bt5 = $('#bt5');
    let $model = $('#modelAdd');
    let brand = $('body #brandAdd :selected').val();
    if (brand === '') {
        $bt5.attr('disabled', 'disabled');
        $model.attr('disabled', 'disabled');
        $model.html('<option value="">модель</option>');
        return;
    }
    let val = input["value"];
    let map = new Map([
        ['1', "bmw"],
        ['2', "mercedes"],
        ['3', "toyota"],
        ['4', "lexus"]
    ]);
    let message = map.get(val);
    /*console.log(message);*/
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
        /*console.log(set);*/
        $model.attr('disabled', false);
        $model.html('<option value="">модель</option>');
        for (let i = 0; i < set.length; i++) {
            $model.append('<option value="' + set[i].id + '">' + set[i].values + '</option>');
           /* console.log(i + ' : ' + set[i].id + ' : ' + set[i].values);*/
        }
    }
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success
    });
}

// noinspection DuplicatedCode
function addedAds() {
    let brand = $('body #brandAdd :selected').val();
    let model = $('body #modelAdd :selected').val();
    let engine = $('body #engineAdd :selected').val();
    let year = $('body #yearAdd :selected').val();
    let color = $('body #colorAdd :selected').val();
    if (brand === '' || model === '' || engine === '' || year === '' || color === '') {
        return;
    }
    const json = {
        "action": "upload",
        "brand": brand,
        "model": model,
        "engine": engine,
        "color": color,
        "year": year,
        "foto": get64,
        "name": name
    };
    let success = function (data) {
        let answer = JSON.parse(data);
        /*console.log(answer);*/
        if (answer["length"] !== 0) {
            tasks = answer;
            reload();
        }
    }
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        success: success
    });

}

function getTmp(input) {
    /*console.log(input.id + " to do");*/
}

function checkData(input) {
    /*console.log(input.id + " to do");*/
}

const path = '/antonino';
const back = `<div id="back" style="margin-top: 25px; margin-left: 37px;"><a href="` + path + `">
                            <button class="btn btn-default" style="border-color: #4285f4; color: #4285f4;
                            border-radius: 0; font-size: smaller;"
                             type="button">назад</button></a></div>`;
const _back = `<button class="btn btn-default"
                style="border-color: #4285f4; border-radius:0; color: #4285f4; font-size: smaller;"
                type="button" onclick="reload()"">назад</button>`;
// language=HTML
const demand = `
    <div id="demand">
        <form id="demands" method="post">
            <div class="form-group">
                <label class="sr-only" for="byData">brand</label>
                <select class="form-control-sm" id="byData" name="byData" onchange="getTmp(this)" size="1">
                    <option value="" selected>выборка:</option>
                    <option value="1">телефон</option>
                    <option value="2">почтa</option>
                    <option value="3">имя</option>
                </select>
            </div>
            <div class="form-group">
                <label class="sr-only" for="data">Data</label>
                <input class="form-control-sm" id="data" name="data" onchange="checkData(this)"
                       placeholder="в разработке"
                       required style="width: 130px; height: 40px; border-radius: 0" disabled
                       type="text"/>
            </div>
            <div class="form-group">
                <button class="btn btn-primary btn-md"
                        disabled id="bt3"
                        style="color: white; width: 130px; height: 40px; border-radius: 0;"
                        type="button" onclick="getData()">поиск
                </button>
            </div>
        </form>
    </div>`
const linkAdd = `<div class="form-group">
<div class="form-control-sm"><button type="button" class="btn btn-info" style="border-radius: 0; font-size: smaller;"
    onclick="viewAdd()"><span class="badge badge-light">+</span> создать</button></div></div>`;
const formAddAds = `<div class="center" style="width: 200px; margin-top: 25px">
                            <form action="" id="formAdd" method="post">
                        <div class="form-group">
                            <label class="sr-only" for="brandAdd">брэнд</label>
                            <select class="form-control-sm" id="brandAdd" name="brandAdd"
                            onchange="getBrands(this)" size="1">
                                <option value="">бренд</option>
                                <option value="1">bmw</option>
                                <option value="2">mercedes</option>
                                <option value="3">toyota</option>
                                <option value="4">lexus</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="modelAdd">модель</label>
                            <select class="form-control-sm" disabled id="modelAdd" name="modelAdd"
                            onchange="checkSelect()" size="1">
                                <option value="">модель</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="engineAdd">мотор</label>
                            <select class="form-control-sm" id="engineAdd" name="engineAdd"
                            onchange="checkSelect()" size="1">
                                <option value="">мотор</option>
                                <option value="1">бензин</option>
                                <option value="2">дизель</option>
                                <option value="3">электро</option>
                                <option value="4">газ</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="yearAdd">год</label>
                            <select class="form-control-sm" id="yearAdd" name="yearAdd"
                            onchange="checkSelect()" size="1">
                                <option value="">год</option>
                                <option value="1">2020</option>
                                <option value="2">2019</option>
                                <option value="3">2018</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="colorAdd">цвет</label>
                            <select class="form-control-sm" id="colorAdd" name="colorAdd"
                            onchange="checkSelect()" size="1">
                                <option value="">цвет</option>
                                <option value="1">чёрный</option>
                                <option value="2">синий</option>
                                <option value="3">белый</option>
                                <option value="4">зелёный</option>
                                <option value="5">серый</option>
                            </select>
                        </div>
                        <div class="form-group">
                                <input type="file" class="form-control-file" id="file" multiple
                                onchange="encodeImageFileAsURL(this)">
                                <label for="file"></label>
                          </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-md"
                                    disabled id="bt5"
                                    style="color: white; width: 130px; height: 40px; border-radius: 0;" onclick="addedAds()"
                                    type="button">сохранить
                            </button>
                        </div>
                    </form></div>`;
