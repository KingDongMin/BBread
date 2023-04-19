/**
 * 
 */
const datas = document.querySelectorAll('.data');
 
 function checkNull(){
	 for(const input of datas){
		if(!input.value){
			input.style.cssText = "outline-color:red;"
			input.focus();
			return false;
		}
		input.style.cssText = "outline-color:green"
	 }
	 return true;
 }