function selecttype(type)
{
	document.getElementById('userSelect').style.display='none';
	document.getElementById('adminSelect').style.display='none';
	if(type=="user")
	{
		document.getElementById('userSelect').style.display='block';
	}else if(type=="admin")
	{
		document.getElementById('adminSelect').style.display='block';
	}
} 