var fname = document.getElementById("fname_id");
var fnamev =document.getElementById("fname_v");
var fnamei = document.getElementById("fname_i");

var lname = document.getElementById("lname_id");
var lnamev =document.getElementById("lname_v");
var lnamei = document.getElementById("lname_i");

var dob = document.getElementById("dob_id");
var dobi = document.getElementById("dob_i");
var dobv = document.getElementById("dob_v");

var maleid = document.getElementById("male_id");
var femaleid =document.getElementById("female_id");
var gen_name = document.getElementsByName("gender");
var genderv = document.getElementById("gen_v");

var eidid = document.getElementById("eid_id");
var eidi =document.getElementById("eid_i");
var eidv = document.getElementById("eid_v");

var unit = document.getElementById("unit_id");
var unitv =document.getElementById("unit_v");
var uniti = document.getElementById("unit_i");

var email = document.getElementById("email_id");
var emailv = document.getElementById("email_v");
var emaili = document.getElementById("email_i");

var des = document.getElementById("desg_id");
var desi = document.getElementById("desg_i");
var desv = document.getElementById("desg_v");

var con = document.getElementById("contact_id");
var coni = document.getElementById("contact_i");
var conv = document.getElementById("contact_v");

var branch = document.getElementById("branch_id");
var branchi = document.getElementById("branch_i");
var branchv = document.getElementById("branch_v");

var add = document.getElementById("add");
var addv = document.getElementById("add_v");

var age = document.getElementById("age_id");

var city = document.getElementById("city_id");
var cityi = document.getElementById("city_i");
var cityv = document.getElementById("city_v");

var pin = document.getElementById("pin_id");
var pini = document.getElementById("pin_i");
var pinv = document.getElementById("pin_v");

var pic = document.getElementById("pic_id");
var pici = document.getElementById("pic_i");
var picv = document.getElementById("pic_v");



function valid_fname(){

	var letters = /^[A-Za-z]+$/;
	if(fname.value.match(letters)){
		fnamei.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
		fnamev.innerHTML = "";
		return true;		

	}else if(fname.value == ""){
		fnamei.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		fnamev.innerHTML = "<span style='color:red'>enter name</span>"
		return false;
	}

		fnamei.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		fnamev.innerHTML = "<span style='color:red'>only alphabets</span>"
		return false;
}

function valid_lname(){

	var letters = /^[A-Za-z]+$/;
	if(lname.value.match(letters)){
		lnamei.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
		lnamev.innerHTML = "";
		return true;		

	}else if(lname.value == ""){
		lnamei.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		lnamev.innerHTML = "<span style='color:red'>enter name</span>"
		return false;
	}

		lnamei.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		lnamev.innerHTML = "<span style='color:red'>only alphabets</span>"
		return false;
}


function valid_gender(){

	var x = 0,i;

	for(i=0;i<gen_name.length;i++){
		x++;
	}

	if(x!=0){
		genderv.innerHTML = "<span style='color:red; font-weight:bold'>choose gender</span>";
		return false;
	}

	return true;
}


function valid_eid(){
	var numbers = /^[0-9]+$/;
	if(eidid.value.match(numbers)){

		if(eidid.value.length != 5){
			eidi.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
			eidv.innerHTML = "<span style='color:red'>enter 5 digits</span>"
			return false;			
		}else{
		eidi.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
		eidv.innerHTML = "";
		return true;	
		}	
	}else if(eidid.value == ""){
		eidi.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		eidv.innerHTML = "<span style='color:red'>enter employee id</span>"
		return false;
	}

		eidi.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		eidv.innerHTML = "<span style='color:red'>only numbers</span>"
		return false;

}



function valid_unit(){
	
	if(unit.value.length == 0){
		uniti.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		unitv.innerHTML = "<span style='color:red'>enter unit</span>";
		return false;
	}	
	uniti.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
	return true;
}

function valid_email(){
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if(email.value.match(mailformat)){
		emaili.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
		emailv.innerHTML = "";
		return true;

	}else if(email.value == ""){
		emaili.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		emailv.innerHTML = "<span style='color:red'>enter email</span>";
		return false;
	}

		emaili.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		emailv.innerHTML = "<span style='color:red'>enter valid email</span>";
		return false;
}


function valid_des(){


	var letters = /^[A-Za-z]+$/;
	if(des.value.match(letters)){
		desi.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
		desv.innerHTML = "";
		return true;		

	}else if(des.value == ""){
		desi.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		desv.innerHTML = "<span style='color:red'>enter designation</span>"
		return false;
	}

		desi.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		desv.innerHTML = "<span style='color:red'>only alphabets</span>"
		return false;

}


function valid_contact(){

	var numbers = /^[0-9]+$/;
	if(con.value.match(numbers)){

		if(con.value.length != 10){
			coni.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
			conv.innerHTML = "<span style='color:red'>enter 10 digits</span>"
			return false;			
		}else{
			coni.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
			conv.innerHTML = "";
			return true;		
		}

	}else if(con.value == ""){
		coni.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		conv.innerHTML = "<span style='color:red'>enter contact no.</span>"
		return false;
	}else{
		coni.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		conv.innerHTML = "<span style='color:red'>only numbers</span>"
		return false;	

	}

	return true;
}

function valid_branch(){


	if(branch.value == "default"){
		branchi.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		branchv.innerHTML = "<span style='color:red'>select branch</span>";
		return false;			

	}

	branchv.innerHTML = "";
	branchi.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
	return true;
}

function valid_add(){

	if(add.value == ""){
		addv.innerHTML = "<span style='color:red'>enter address </span>";
		return false;
	}

	addv.innerHTML = ""; 

	return true;
}


function valid_dob(){

	var dobs = dob.value.substring(0,4);
	var age = 2019 - dobs;
	//alert(age + 6);
	if(age>=17 && age<=70){
		
		dobi.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
		dobv.innerHTML ="";
		age.value = age;
		
		return true;
	}

	dobi.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
	dobv.innerHTML = "<span style='color:red'>(yyyy < 2002) and (yyyy > 1948)</span>";
	return false;
}

function valid_city(){


     if(city.value == ""){
		cityi.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		cityv.innerHTML = "<span style='color:red'>enter city</span>"
		return false;
	}

		cityi.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
		cityv.innerHTML = "";

		return true;

}


function valid_pin(){

	var numbers = /^[0-9]+$/;
	if(pin.value.match(numbers)){
		pini.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
		pinv.innerHTML = "";
		return true;		

	}else if(pin.value == ""){
		pini.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		pinv.innerHTML = "<span style='color:red'>enter pin</span>"
		return false;
	}

		pini.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		pinv.innerHTML = "<span style='color:red'>only numbers</span>"
		return false;

}


function valid_pic(){
	
	var en = pic.value.length;

	if(en == 0){
		pici.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		picv.innerHTML = "<span style='color:red'>please upload image</span>"
		return false;		
	}

	var st = en- 4;
	var pic_format =  pic.value.substring(st,en);
	//alert(pic_format)

	if(pic_format != ".jpg" && pic_format!=".png"){
		pici.innerHTML = "<i class='glyphicon glyphicon-remove'></i>";
		picv.innerHTML = "<span style='color:red'>upload in jpg or png format</span>"
		return false;
	}

		pici.innerHTML = "<i class='glyphicon glyphicon-ok'></i>";
		picv.innerHTML = "";
		return true;
}


function valid(){

	var fname,lname,gender,eid,unit,des,contact,branch,add,city,pin,pic,email;
	fname = valid_fname();
	lname = valid_lname();
	gender = valid_gender();
	eid = valid_eid();
	unit = valid_unit();
	des = valid_des();
	contact = valid_contact();
	branch = valid_branch();
	add = valid_add();
	city = valid_city();
	pin = valid_pin();
	pic = valid_pic();
	email = valid_email();



	if(fname==true && lname==true && gender==true && eid==true &&
		unit==true && des==true && contact==true && branch==true &&
		add==true && city==true && pin==true && pic==true && email==true)
	{

		return true;
	}

	return false;
}


