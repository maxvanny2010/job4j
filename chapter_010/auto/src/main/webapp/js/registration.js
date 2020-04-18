const map = new Map();

function getMap() {
    return map;
}

$(document).ready(function () {
    let $ads = $('#ads');
    $ads.html(form);
    $ads.append(back);
});

function setWarn(name, warn) {
    return '<span style="color: red; font-size: smaller;" id="' + name + 'A"' + '>' + warn + '</span>';
}

function checkUser(input) {
    let name = input.name;
    let $name = $('#' + name);
    let reg;
    switch (name) {
        case 'name':
            reg = new RegExp('^([a-zA-Zа-яА-ЯЁё]{3,20})$');
            break;
        case 'login':
            reg = new RegExp('^([a-zA-Zа-яА-ЯЁё0-9]{1,20})$');
            break;
        case "password":
            reg = new RegExp('^[^;,&@#*]{1,20}$');
            break;
        case 'email':
            reg = new RegExp('^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$');
            break;
        case 'phone':
            reg = new RegExp('^[0-9]{1,12}$');
            break;
        default:
            break;
    }
    $name.blur(function () {
        let get = $name.val().trim();
        let warn = $name.attr('placeholder');
        let selector = '#' + name + 'D';
        if (!(reg.test(get)) || get.length === 0) {
            $(selector).html(setWarn(name, warn));
            getMap().delete(input.id);
        } else {
            getMap().set(input.id, get);
            console.log(getMap());
        }
        if (getMap().size >= 5) {
            $('#b1').attr('disabled', false);
        } else {
            $('#b1').attr('disabled', 'disabled');
        }
        console.log(getMap());
    });
    $name.focus(function () {
        $('#' + name + 'A').html('');
    });
}

function addUser() {
    let success = function (data) {
        let tasks = JSON.parse(data);
        let selector = '#logD';
        console.log(tasks);
        if (tasks.name === "no") {
            $(selector).html('<span style="color: red;" id="logA">Логин занят</span>');
        } else {
            getMap().clear();
            document.location.href = '/auto';
        }
        $('#login').focus(function () {
            $(selector).html('');
        });
    }

    const json = {
        "action": "register",
        "name": $('#name').val(),
        "email": $('#email').val(),
        "login": $('#login').val(),
        "password": $('#password').val(),
        "phone": $('#phone').val()
    };
    console.log(json);
    $.ajax({
        url: 'http://localhost:8080/controller',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(json),
        dataType: 'text',
        async: true,
        success: success,
    });

}

const path = '/auto';
const form = `<div class="center" id="added" style="width: 250px; margin-top: 25px">
                        <form action="" id="user" method="POST">
                            <div class="form-group">
                                <label class="sr-only" for="name">Name</label>
                                <input class="form-control" id="name" name="name"
                                       onchange="checkUser(this)"
                                       placeholder="Имя 3-20 букв" required="" style="border-radius: 0;
                                       font-size: smaller;" type="text">
                                <div id="nameD"></div>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="email">Email</label>
                                <input class="form-control" id="email" name="email"
                                       onchange="checkUser(this)"
                                       placeholder="Почта example@ex.com" required="" style="border-radius: 0;
                                       font-size: smaller;"
                                       type="text">
                                <div id="emailD"></div>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="login">Login</label>
                                <input class="form-control" id="login" name="login"
                                       onchange="checkUser(this)"
                                       placeholder="Логин 1-20 букв/цифр" required="" style="border-radius: 0;
                                       font-size: smaller;"
                                       type="text">
                                <div id="logD"></div>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="password">Password</label>
                                <input class="form-control" id="password" name="password"
                                       onchange="checkUser(this)" placeholder="Пароль 1-5 букв/цифр"
                                       required="" style="border-radius: 0 font-size: smaller;;" type="text">
                                <div id="passwordD"></div>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="phone">Phone</label>
                                <input class="form-control" id="phone" name="phone"
                                       onchange="checkUser(this)"
                                       placeholder="Телефон 10 цифр(1)" required="" style="border-radius: 0;
                                       font-size: smaller;"
                                       type="text">
                                <div id="phoneD"></div>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-md"
                                        disabled="" id="b1"
                                        onclick="addUser()"
                                        style="color: white; width: 250px; height: 40px; border-radius: 0;
                                        font-size: smaller;"
                                        type="button">Сохранить
                                </button>
                            </div>
                        </form>
                    </div>`;
const back = `<div id="back" style="margin-top: 25px; margin-left: 5px;"><a href="` + path + `">
                            <button class="btn btn-default" style="border-color: #4285f4; color: #4285f4;
                            font-size: smaller;"
                             type="button">назад</button></a></div>`;
