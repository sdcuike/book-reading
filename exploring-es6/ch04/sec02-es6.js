/**
 * Created by sdcuike on 15-10-28.
 */

    'use strict';
let x = 3;
function func(randomize){
    if(randomize){
        let x = Math.random();
        return x;
    }
    return x;
}

let r = func(false);
console.log(r);//3