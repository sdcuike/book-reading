/**
 * Created by sdcuike on 15-10-28.
 *
 *  Handling multiple return values
 */

'use strict';

//es5

var _slicedToArray = (function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i['return']) _i['return'](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError('Invalid attempt to destructure non-iterable instance'); } }; })();

var matchObj = /^(\d\d\d\d)-(\d\d)-(\d\d)$/.exec('2999-12-31');
var year = matchObj[1];
var month = matchObj[2];
var day = matchObj[3];
console.log(year, month, day); //2999 12 31

//es6

var _dDDDDDDD$$exec = /^(\d\d\d\d)-(\d\d)-(\d\d)$/.exec('2999-12-31');

var _dDDDDDDD$$exec2 = _slicedToArray(_dDDDDDDD$$exec, 4);

var y = _dDDDDDDD$$exec2[1];
var m = _dDDDDDDD$$exec2[2];
var d = _dDDDDDDD$$exec2[3];

console.log(y, m, d); //2999 12 31

//# sourceMappingURL=sec06-compiled.js.map