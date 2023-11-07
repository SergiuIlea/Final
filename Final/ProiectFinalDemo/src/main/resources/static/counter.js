let count = 0;

document.getElementById("decrease-button").onclick = function(){
    count-=1;
    document.getElementById("count-label").innerHTML = count;
}

document.getElementById("increase-button").onclick = function(){
    count+=1;
    document.getElementById("count-label").innerHTML = count;
}