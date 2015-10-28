/**
 * Created by sdcuike on 15-10-28.
 *
 * From concatenating strings to template literals
 *
 */

"use strict";
//es5
function printCoord(x, y) {
  console.log('(' + x + ',' + y + ')');
};

printCoord(1, 2); //(1,2)

//es6

function printCoordNew(x, y) {
  console.log('(' + x + ',' + y + ')'); //(3,5)
}

printCoordNew(3, 5);

//Multi-line strings

var HTML5_SKELETON = '\n<!doctype html>\n<html>\n<head>\n<meta charset="UTF-8">\n<title></title>\n</head>\n<body>\n</body>\n</html>';

console.log(HTML5_SKELETON);

//# sourceMappingURL=sec04-compiled.js.map