$.validator.addMethod("regex",
    function (value, element, regexp) {
        let re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    }, "Поле не корректно"
);
$(document).ready(function () {
    $('#added').validate({
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
            },
            confPassword: {
                required: true,
                equalTo: "#password"
            },
        },
        message: {
            name: {
                regex: "Буквы, 3-20."
            },
            login: {
                regex: "Буквы/цифры, 3-20."
            },
            email: {
                regex: "Введите корректный адрес."
            },
            password: {
                regex: "1-5 символов."
            },
            confPassword: {
                regex: "Пароль 1-5 символов.",
            },
        },
    });
});
jQuery.extend(jQuery.validator.messages, {
    required: "Заполните поле.",
    equalTo: "Пароли не совпадают."
});
