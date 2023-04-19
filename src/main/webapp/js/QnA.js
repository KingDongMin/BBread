/**
 * 
 */
const answer = document.querySelector('.answer');


 function checkAnswer(){
	 
	 if(!answer.value)
	 {
		answer.style.cssText = "outline-color : red"
		answer.focus();
		return false;
	 }
	 
	 return true;
 }