/**
 * Created by sdcuike on 15-10-28.
 */
"use strict";

var x = 3;

function func(randomize){

    if(randomize){
        var x = Math.random();
        return x;
    }

    return x;
}

var r = func(false);
console.log(r);//undefined ,变量作用域的提升现象导致