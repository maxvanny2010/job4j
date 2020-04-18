$(document).ready(function () {
    let id = onLoad();
    viewAds(id);
});

function onLoad() {
    return window.location.href.split("?")[1].split("=")[1];
}

function viewAds(id) {
    let success = function (data) {
        let user = JSON.parse(data);
        console.log(user);
        let foto = user["ads"]["foto"][0].values;
        if (foto === null) {
            foto = 'img/default.png';
        }
        let $ads = $('#ads');
        if (user["ads"].name === "no") {
            $ads.html('<div class="center"><span style="color: red;">Нет Данных</span></div>');
        } else {
            $ads.html(`<div class="d-flex justify-content-center" 
            style="margin-top: 25px"><img alt='${id}' src='${foto}'/></div>`);
            $ads.append(back);
            let $searches = $('#searches');
            $searches.html(`<div class="flex-container" style='display: flex; flex-wrap: wrap; width: 232px'>
                        <ul><li>бренд: <span class="view">${user["ads"]["auto"].brand.values}</span></li>
                        <li>модель: <span class="view">${user["ads"]["auto"].model.values}</span></li>
                        <li>мотор:  <span class="view">${user["ads"]["auto"].engine.values}</span></li>
                        <li>год:    <span class="view">${user["ads"]["auto"].year.values}</span></li>
                        <li>цвет:   <span class="view">${user["ads"]["auto"].color.values}</span></li>
                        <li>телефон:</br><span class="view">${user["phone"]}</span></li></ul>`);
        }
    }
    const json = {
        "action": "viewA",
        "id": id,
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

let path = '/auto';
const back = `<div id="back" style="margin-top: 25px; margin-left: 5px;"><a href="` + path + `">
                            <button class="btn btn-default" style="border-color: #4285f4; color: #4285f4; 
                            font-size: smaller;" type="button">назад</button></a></div>`;
