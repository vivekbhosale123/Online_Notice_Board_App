function searchCategory(str)
{
    //let name=str;
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function()
	{
		
		if(this.readyState==4 && this.status==200)
		{
			//alert("function calling");
			document.getElementById("v").innerHTML=this.responseText;
		}
	}
	xhttp.open("GET","CategorySearch?catName="+str,true);
	xhttp.send();
}