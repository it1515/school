function listOfAnimals(data, start, count) {
    try {
        if (isNaN(start)) throw "not a number";
        if (isNaN(count)) throw "not a number";
        if (start < 0) throw "can't be less than 0";
        if (start > data.length - 1) throw "can't be more than.";
        if (start + count > data.length - 1) throw "can't be more than.";
    } catch (err) {
        return '<div>Error: ' + err + '</div>'
    }
    var list = [];
    for (var i = start; i < start + count; i++) {
        list.push(data[i]);
    }
    return (list.length > 0) ? list : '<p>No items</p>'
};

function detailOfAnimal(data, id) {
    var animal = {};
    try {
        if (isNaN(id)) throw "Argument is not a number"
        if (id < 0) throw "can't be less than 0";
        if (id > data.length - 1) throw "cannot be greater than lenght of the array";
        var i = 0;
        while (i < data.length || !animal) {
            if (data[i].id == id)
                animal = data[i];
            i++;
        }
    } catch (err) {
        return '<div>Error: ' + err + '</div>';
    }
    return animal;
}
$(function() {
    var animals = [];
    var animal = {};
    var pageNum = 1;


    function listView(start, count) {
        var animals = listOfAnimals(json, start, count);
        animal = animals[0];
        $('#list').html('<div class="list-group"></div>');
        animals.forEach(function(item, index) {
            $('#list .list-group').append('<a href="#" data-id=' + item.id + ' class="list-group-item">' + item.title + '</a>')
        });
        itemClick();
    }

    function pageScroll(start, count) {
        var animals = listOfAnimals(json, start, count);
        animal = animals[0];
        listView(start + ((pageNum - 1) * 10), count)
        $('#scroller').html('<ul class="pagination">' +
            '<li><a href="#">' + "<" + '</a></li>' +
            '<li><a href="#">' + pageNum + '</a></li>' +
            '<li><a href="#">' + (pageNum + 1) + '</a></li>' +
            '<li><a href="#">' + (pageNum + 2) + '</a></li>' +
            '<li><a href="#">' + (pageNum + 3) + '</a></li>' +
            '<li><a href="#">' + (pageNum + 4) + '</a></li>' +
            '<li><a href="#">' + ">" + '</a></li></ul>');
    }

    function changePage(prom) {
        pageNum = (pageNum + prom);
        pageScroll(0, 10);
        console.log(pageNum);
    }


    function detailView(animal) {
        $('#detail').html('<h3>' + animal.title + ' <small>' + animal.latin_title + '</small></h3>' +
            '<hr><ul class="nav nav-tabs" role="tablist">' +
            '<li role="presentation" class="active"><a href="#basics" aria-controls="basics" role="tab" data-toggle="tab">Základní údaje</a></li>' +
            '<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profil</a></li>' +
            '<li role="presentation"><a href="#photo" aria-controls="photo" role="tab" data-toggle="tab">Popis a foto</a></li>' +
            '</ul>' +
            '<br><div class="tab-content">' +
            '<div role="tabpanel" class="tab-pane active" id="basics">' +
            '<table class="table table-hover">' +
            '<tbody><tr><th>Třída</th><td id="classes">' + animal.classes.title + '</td></tr>' +
            '<tr><th>Řád</th><td id="order">' + animal.order.title + '</td></tr>' +
            '<tr><th>Kontinenty</th><td id="continents">' + animal.continents.name_c + '</td></tr>' +
            '<tr><th>Biotop</th><td id="biotop">' + animal.biotop.name_b + '</td></tr>' +
            '<tr><th>Potrava</th><td id="food">' + animal.food.name_f + '</td></tr>' +
            '</tbody></table>' +
            '<p>Kde nás najdete:<a href="' + animal.localities.url + '" id="localities "> ' + animal.localities.title + '</a></p></div>' +
            '<div role="tabpanel" class="tab-pane" id="profile"><div class="row">' +
            '<div class="col-sm-3"><h4>Rozměry</h4></div><div class="col-sm-9" id="proportions">' + animal.proportions + '</div></div>' +
            '<div class="row"><div class="col-sm-3"><h4>Rozmnožování</h4></div><div class="col-sm-9" id="reproduction">' + animal.reproduction + '</div></div>' +
            '<div class="row"><div class="col-sm-3"><h4>Potrava</h4></div><div class="col-sm-9" id="food_note">' + animal.food_note + '</div></div>' +
            '<div class="row"><div class="col-sm-3"><h4>Biotopy a rozšíření</h4></div><div class="col-sm-9"><p id="biotopes_note">' + animal.biotopes_note +
            '</p><p id="spread_note">' + animal.spread_note + '</p></div></div>' +
            '<div class="row"><div class="col-sm-3"><h4>Zajímavosti</h4></div><div class="col-sm-9" id="attractions">' + animal.attractions + '</div></div></div>' +
            '<div role="tabpanel" class="tab-pane" id="photo"><figure id="description">' + animal.description + '</figure></div></div>');
    }

    function itemClick() {
        $('#list .list-group-item').on('click', function() {
            animal = detailOfAnimal(json, $(this).data('id'));
            detailView(animal);
        });
    }
    pageScroll(0, 10);
    detailView(animal);
});