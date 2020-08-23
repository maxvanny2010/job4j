const maps = new Map();

function getMaps() {
    return maps;
}

$(document).ready(function () {
});

function checkDemand(input) {
    let name = input.name;
    let $name = $('#' + name);
    let reg;
    switch (name) {
        case 'log':
            reg = new RegExp('^([a-zA-Zа-яА-ЯЁё0-9]{3,20})$');
            break;
        case "pass":
            reg = new RegExp('^[^;,&@#*]{1,5}$');
            break;
        default:
            break;
    }
    let get = $name.val();
    let selector = '#helper';
    $name.blur(function () {
        if (!(reg.test(get)) || get.length === 0) {
            $(selector).html(`<span style="color: red; margin-right: 5px;" id="logA">нет данных</span>`);
            getMaps().delete(input.id);
        } else {
            $('#logA').html('')
            getMaps().set(input.id, get);
        }
        if (getMaps().size >= 2) {
            $('#b2').attr('disabled', false);
        } else {
            $('#b2').attr('disabled', 'disabled');
        }
        //console.log(getMaps());
    });
    $name.focus(function () {
        $('#logA').html('');
    });
}

function setOut() {
    let success = function (data) {
        let tasks = JSON.parse(data);
        //console.log(tasks);
        if (tasks.name === "no") {
            $('#btU').attr('disabled', false);
            $('#btA').attr('disabled', false);
            $('#helper').remove();
            document.location.href = '/auto';
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

function Cabinet(input) {
    let name = input.id;
    if (name === 'admin') {
        document.location.href = "/cabinet?admin=" + name;
    } else if (name.length > 0 && name !== 'admin') {
        document.location.href = "/cabinet?user=" + name;
    } else {
        document.location.href = "/antonino";
    }

}

function getEnter(answer) {
    let role = answer.role;
    let names = answer.user;
    let enter = `<div class="d-flex justify-content-end" style="color: #4285f4; padding-right: 10px">
        <div><button class="btn btn-link" type="button" onclick="Cabinet(this)" id="${names}">Кабинет: ${names}</button>
        <button class="btn btn-link" type="button" onclick="setOut()" id="btnOut">выйти</button>
        </div></div>`;
    let reg = '/registration';
    if (role === "unknown") {
        $('#visitor').html(formGate);
        $('#register').html(`<a href="${reg}"><button class="btn btn-link" type="button">Регистрация</button></a>`);
    } else if (role === 'admin' || role === 'user') {
        $('#visitor').html(enter);
        $('#register').html(`<span style="color: white;">Регистрация</span>`);
        $('#btU').attr('disabled', 'disabled');
        $('#btA').attr('disabled', 'disabled');
    }
}

function setUser() {
    let success = function (data) {
        getMaps().clear();
        let answer = JSON.parse(data);
        //console.log(answer);
        let selector = '#helper';
        if (answer.role === "unknown") {
            $(selector).html('<span style="color: red; margin-right: 5px;" id="logA">нет данных</span>');
            $('#log').val('');
            $('#pass').val('');
            $('#b2').attr('disabled', 'disabled');
        } else if (answer.role === 'admin' || answer.role === 'user') {
            getEnter(answer);
        }
    }
    const json = {
        "action": "login",
        "login": $('#log').val(),
        "password": $('#pass').val()
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

const formGate = `<div class="d-flex justify-content-end">
                            <div id="helper"></div>
                            <div>
                                <label class="sr-only" for="log">Login</label>
                                <input class="form-control" id="log" name="log" onchange="checkDemand(this)"
                                       placeholder="логин" 
                                       required style="width: 100px; height: 25px; border-radius: 0;
                                       font-size: smaller;"
                                       type="text"/>
                            </div>
                            <div>
                                <label class="sr-only" for="pass">Password</label>
                                <input class="form-control" id="pass" name="pass" onchange="checkDemand(this)"
                                       placeholder="пароль" 
                                       required style="width: 100px; height: 25px; border-radius: 0;
                                       font-size: smaller;"
                                       type="text"/>
                            </div>
                            <div>
                                <button class="btn btn-primary btn-md"
                                style="border-radius: 0; margin-left: 2px; margin-top: auto; margin-bottom: auto;"
                                id="b2" disabled onclick="setUser()" type="button"></button>
                            </div></div>`;
