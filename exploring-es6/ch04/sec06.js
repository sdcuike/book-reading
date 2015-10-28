/**
 * Created by sdcuike on 15-10-28.
 *
 *  Handling multiple return values
 */



'use strict';

//es5
var matchObj = /^(\d\d\d\d)-(\d\d)-(\d\d)$/.exec('2999-12-31');
var year = matchObj[1];
var month = matchObj[2];
var day = matchObj[3];
console.log(year,month,day);//2999 12 31


//es6

let [,y,m,d ] = /^(\d\d\d\d)-(\d\d)-(\d\d)$/.exec('2999-12-31');
console.log(y,m,d);//2999 12 31
