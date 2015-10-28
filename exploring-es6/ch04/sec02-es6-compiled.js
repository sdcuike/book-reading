/**
 * Created by sdcuike on 15-10-28.
 */

'use strict';
var x = 3;
function func(randomize) {
    if (randomize) {
        var _x = Math.random();
        return _x;
    }
    return x;
}

var r = func(false);
console.log(r); //3

//# sourceMappingURL=sec02-es6-compiled.js.map