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

console.log(listOfAnimals(json,570,20));