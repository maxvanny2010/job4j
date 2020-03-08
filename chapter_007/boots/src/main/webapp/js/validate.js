let get64;

function encodeImageFileAsURL(element) {
    let file = element.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onloadend = function () {
        get64 = reader.result;
    };
}

$.validator.addMethod("regex",
    function (value, element, regexp) {
        let re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    }, "Введите корректное имя."
);
$(document).ready(function () {
    $("#ajax").validate({
        rules: {
            name: {
                required: true,
                regex: "^([a-zA-Zа-яА-ЯЁё]{3,20})$"
            },
            login: {
                required: true,
                regex: "^([a-zA-Zа-яА-ЯЁё0-9]{3,20})$"
            },
            email: {
                required: true,
                regex: "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"
            },
            password: {
                required: true,
                regex: "^[^;,&@#\\*]{1,5}$"
                // regex: "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{1,5}$"
            },
            confPassword: {
                required: true,
                equalTo: "#password"
            },
            file: {
                required: true,
            },
        },
        messages: {
            name: {
                regex: "Только буквы, 3-20."
            },
            login: {
                regex: "Только буквы/цифры, 3-20."
            },
            email: {
                regex: "Введите корректный адрес."
            },
            password: {
                regex: "Пароль 1-5 символов.",
            },
            confPassword: {
                regex: "Пароль 1-5 символов.",
                equalTo: "Пароли не совпадают."
            },
            file: {
                required: "Только image файлы.",
            },
        },
        success: function (label) {
            label.text("ok!").addClass("success");
        },
    });
});
jQuery.extend(jQuery.validator.messages, {
    required: "Заполните поле.",
});
// noinspection JSUnusedGlobalSymbols
$.validator.setDefaults({
    submitHandler: function () {
        let user = {
            "name": $('#name').val(),
            "email": $('#email').val(),
            "login": $('#login').val(),
            "password": $('#password').val(),
            "img": get64
            //"role": $("input[name='role']:checked").val(),
        };
        let start = "<td><img alt=\"image\" src=\"";
        let end = "\" width=\"16px\" height=\"16px\"/></td>";
        let success = function (data) {
            let obj = JSON.parse(data);
            $.each(obj, function (out, v) {
                let $tr = $("<tr>").appendTo($("#some"));
                $.each(v, function (k, v) {
                    if (v.startsWith('data:image')) {
                        $tr.append($(start + v + end));
                    } else {
                        $tr.append($("<td>").text(v)).append("</td>");
                    }
                });
            });
        };
        $.ajax({
            url: 'http://localhost:8080/index',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(user),
            dataType: 'text',
            success: success,
        });
        $('#ajax').trigger('reset');
        $('.success').remove();
    }
});
