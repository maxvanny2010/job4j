function removeAll() {
    [].forEach.call(document.querySelectorAll('tbody>tr'), function (item) {
        item.parentNode.removeChild(item);
    });
}

function getTask(show) {
    let showNotDone = !!show.checked;
    const notDone = {
        "done": "1",
    };
    const all = {
        "done": "0",
    };
    let success = function (data) {
        removeAll();
        let tasks = JSON.parse(data);
        console.log(tasks);
        $(tasks).each(function (k, v) {
            let $tr = $("<tr id='" + v.id + "'>").appendTo($("#tasks"));
            // noinspection JSUnresolvedVariable
            $tr.append($("<td>").text(v.created)).append("</td>");
            $tr.append($("<td>").text(v.desc)).append("</td>");
            if (v.done === "true") {
                $tr.append($("<td><input type='checkbox' value='' checked name='" + v.id + "' onclick='isDone(this)'"
                    + " style='margin-left: auto'></td>"));
            } else {
                $tr.append($("<td><input type='checkbox' value='' name='" + v.id + "' onclick='isDone(this)'"
                    + " style='margin-left: auto'></td>"));
            }
            $tr.append($("<td><button type='button' class='btn btn-sm' name='" + v.id + "' onclick='Delete(this)'>"
                + "удалить</button></td>"));
        });
    };
    if (showNotDone) {
        $.ajax({
            url: 'http://localhost:8080/get',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(notDone),
            dataType: 'text',
            success: success
        });
    } else {
        $.ajax({
            url: 'http://localhost:8080/get',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(all),
            dataType: 'text',
            success: success
        });
    }
}

function isDone(row) {
    let check = !!row.checked;
    let id = row.name;
    if (check) {
        const task = {
            "id": id,
            "done": "true"
        };
        $.ajax({
            url: 'http://localhost:8080/update',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(task),
            dataType: 'text',
        });
    }
    if (!check) {
        const task = {
            "id": id,
            "done": "false"
        };
        $.ajax({
            url: 'http://localhost:8080/update',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(task),
            dataType: 'text',
        });
    }
}

function Delete(task) {
    let id = task.name;
    let del = {"id": id};
    $.ajax({
        url: 'http://localhost:8080/delete',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(del),
        dataType: 'text',
        success: delTask(id)
    });
}

function delTask(id) {
    document.getElementById(id).style.display = 'none';
}

function sortTable(n) {
    let table, rows, switching, dir, i, x, y, shouldSwitch, switchCount = 0;
    table = document.getElementById("table");
    switching = true;
    dir = "asc";
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            if (dir === "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir === "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchCount++;
        } else {
            if (switchCount === 0 && dir === "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}
