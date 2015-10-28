/**
 * Created by sdcuike on 15-10-28.
 *
 *  From IIFEs to blocks
 */
//es5
"use strict";

(function (){
  var temp = 'temp';
    console.log(temp);//temp

})();

//console.log(temp);//ReferenceError: temp is not defined


//es6

{
    let tem = 'tem';
    console.log(tem);
}
//console.log(tem);//ReferenceError: tem is not defined