 window.onload=function(){
		var pic=document.getElementById("pic").getElementsByTagName("li");
		var next=document.getElementById("next");
		var i=0;
		next.onclick=function(){
			for(var t=0;t<4;t++){
				pic[t].style.display="none";
			}
			i++;
			pic[i].style.display="block";
			if(i>2){
				i=-1;
			}
		};
	};
 