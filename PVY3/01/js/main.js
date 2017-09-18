function listOfAnimals(data,start,count){
    try { 
        if(isNaN(start)) throw "not a number";
        if(isNaN(count)) throw "not a number";
        if(start < 0) throw "can't be less than 0";
        if(start > data.length-1) throw "can't be more than.";
        if(start+count > data.length-1) throw "can't be more than.";
    }
    catch(err) {
        return '<div>Error: ' + err + '</div>'
    }
    var list = [];
    for (var i = start; i < start+count;i++){
        list.push(data[i]);
    }
    return (list.length > 0) ? list : '<p>No items</p>'
};

function detailOfAnimal(data, id){
    var animal = {};
    try {
        if(isNaN(id)) throw "Argument is not a number"
        if(id < 0) throw "can't be less than 0";
        if(id > data.length-1) throw "cannot be greater than lenght of the array";
            var i = 0;
        while(i < data.length || !animal){
            if(data[i].id == id)
                animal = data[i];
            i++;
        }
    } catch(err){
        return '<div>Error: ' + err + '</div>';
    }
    return animal;
}
$(function(){
    var animals = [];
    var animal = {};
    function listView(start, count){
        var animals = listOfAnimals(json,start,count);
        animal = animals[0];
        $('#list').html('<div class="list-group"></div>');
        animals.forEach(function(item, index){
            $('#list .list-group').append('<a href="#" data-id='+item.id+' class="list-group-item">' + item.title + '</a>')
        });
        itemClick();
    }
    function detailView(animal){
        $('#detail').html('<h3>' + animal.title + ' <small>' + animal.latin_title + '</small></h3>' +
        '<hr><ul class="nav nav-tabs" role="tablist">' +
        '<li role="presentation" class="active"><a href="#basics" aria-controls="basics" role="tab" data-toggle="tab">Základní údaje</a></li>' +
        '<li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profil</a></li>' +
        '<li role="presentation"><a href="#photo" aria-controls="photo" role="tab" data-toggle="tab">Popis a foto</a></li>' +
        '</ul>' +
        '<div class="tab-content">' + 
        '<div role="tabpanel" class="tab-pane active" id="basics">' + 
        '<table class="table table-hover">' + 
        '<tbody><tr><th>Třída</th><td id="classes">' + "Doe" + '</td></tr>' +
        '<tr><th>Řád</th><td id="order">' + "Moe" + '</td></tr>' + 
        '<tr><th>Kontinenty</th><td id="continents">' + "Dooley" + '</td></tr>' +
        '');
        
    }
    function itemClick(){
        $('#list .list-group-item').on('click', function(){
            animal = detailOfAnimal(json,$(this).data('id'));
            detailView(animal);
        });
    }
    listView(0,10);
    detailView(animal);
});