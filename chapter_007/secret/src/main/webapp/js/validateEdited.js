$.validator.addMethod("regex",
    function (value, element, regexp) {
        let re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    }, "Поле не корректно"
);
$(document).ready(function () {
    $('#edited').validate({
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
        },
    });
});
jQuery.extend(jQuery.validator.messages, {
    required: "Заполните поле.",
});
