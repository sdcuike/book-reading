/**
 * Created by sdcuike on 15-10-28.
 *
 *  From function expressions to arrow functions
 */
"use strict";

//es5
var arr = [1, 2, 3];
var squares = arr.map(function (x) {
  return x * x;
});
console.log(squares); //[ 1, 4, 9 ]

//es6
var ar = [1, 2, 3];
var sq = ar.map(function (x) {
  return x * x;
});
console.log(sq); //[ 1, 4, 9 ]

//# sourceMappingURL=sec05-compiled.js.map