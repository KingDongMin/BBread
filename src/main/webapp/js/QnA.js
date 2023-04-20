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

 
 const deleteItem = (qseq) => {
	location.href=`BBreadServlet?command=delete_QnA&qseq=${qseq}`;
}
