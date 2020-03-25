$(document).ready(function () {
    let show = {checked: false};
    getTask(show);
    $('#todo_ajax').submit(function (e) {
        e.preventDefault();
        let success = function (data) {
            let obj = JSON.parse(data);
            console.log(obj);
            let $tr = $("<tr id='" + obj.id + "'>").appendTo($("#tasks"));
            // noinspection JSUnresolvedVariable
            $tr.append($("<td>").text(obj.created).append("</td>"));
            $tr.append($("<td>").text(obj.desc).append("</td>"));
            $tr.append($("<td><label class='sr-only' for='" + obj.id + "'" + ">" + obj.done + "</label>"
                + " <input type='checkbox' value='' name='" + obj.id + "' onclick='isDone(this)'"
                + " style='margin-left: auto'></td>"));
            $tr.append($("<td><button type='button' class='btn btn-sm' name='" + obj.id + "' onclick='Delete(this)'>"
                + "удалить</button></td>"));
        };
        const task = {"desc": $('#desc').val()};
        console.log(task);
        $.ajax({
            url: 'http://localhost:8080/add',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(task),
            dataType: 'text',
            success: success,
        }).done(function () {
            $('#todo_ajax').trigger('reset');
        });
    });
});
