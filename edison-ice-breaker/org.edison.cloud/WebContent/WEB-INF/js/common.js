/***************************************/
/* �꾩뿭蹂�닔 */
/***************************************/
var API_URL = "http://150.183.247.210:8080/admin/api";


/***************************************/
/* AJAX �듭떊�먮윭 泥섎━ */
/***************************************/
function ajaxError(request, type, errorThrown) {
	var message = "AJAX �듭떊�먯꽌 �먮윭媛�諛쒖깮 �덉뒿�덈떎.\n";
	switch (type) {
		case 'timeout':
			message += "�붿껌 �쒓컙��珥덇낵 �섏��듬땲��";
			break;
		case 'notmodified':
			message += "�붿껌��蹂�꼍�섏� �딆븯�듬땲��";
			break;
		case 'parsererror':
			message += "XML/Json��留욎� �딆뒿�덈떎.";
			break;
		default:
			message += "HTTP �듭떊�먮윭 (" + request.status + " : " + request.statusText + " : "  + request.responseText + ").";
	}
	message += "\n";
	alert(message);
}

/***************************************/
/* 濡쒓렇��泥섎━ */
/***************************************/
function login(id, pw){
	 var str_xml = '<?xml version="1.0" encoding="utf-8"?>'
         			+ '<login>'
         			+ '<userId>' + id + '</userId>'
         			+ '<password>' + pw + '</password>'
         			+ '</login>';

	$.ajax({
		url: API_URL + "/user/login",
	    type: "POST",
	    cache:false,
	    async:false,
	    timeout : 30000, 
	    contentType:"application/xml; charset=UTF-8",
	    dataType:"json",
	    data: str_xml
	}).done(function(data, status, xhr) {
		// �듭떊�깃났
		var _token = getTokenFromData(data);
		//$("#content").html(_token);
	    saveToken(_token);	
	}).fail(function(xhr, status, error) {
		// �듭떊�ㅽ뙣
		ajaxError(xhr, status, error);
	}).always(function(arg1, status, arg2) {
	});
}

/***************************************/
/* �ъ슜��由ъ뒪��泥섎━ */
/***************************************/
function getUserList() {
	if(isLogin()){
			   $.ajax({
				     
				   	  url: API_URL + "/user/list",
				      headers: {          
				          "Accept" : "application/json",         
				          "Content-Type" : "application/xml",
						  "Access-Control-Allow-Credentials" : "true",
				          "Authorization" : "Basic " + localStorage.getItem('Token') 
				      },				      	
				       type: "GET", 
				       contentType:"application/xml; charset=UTF-8",
				       dataType:"json"
				    	   
				   }).done(function(data, status, xhr) {
				      // �듭떊�깃났
				      alert("�깃났");
				   }).fail(function(xhr, status, error) {
				      // �듭떊�ㅽ뙣
				      alert("�ㅽ뙣");
				      ajaxError(xhr, status, error);
				   }).always(function(arg1, status, arg2) {
				      // �듭떊�꾨즺
				      alert("�꾨즺");
				   });
			   }
	}

	
/***************************************/
/* �좏겙 痍⑤뱷 */
/***************************************/
function getTokenFromData(data) {
	var token = data.split("\n")[0].replace(/s/gi, '').split(": ")[1];
	return token;
}

/***************************************/
/* �좏겙 ��옣 */
/***************************************/
function saveToken(token) {
	localStorage.setItem('Token', token);
}

/***************************************/
/* �좏겙 ��젣 */
/***************************************/
function deleteToken() {
	// 紐⑤뱺 濡쒓렇���뺣낫 ��젣
	localStorage.clear();
}

/***************************************/
/* 濡쒓렇���좊Т 泥댄겕 */
/* return : true-�뺤긽濡쒓렇��, false-濡쒓렇�꾩썐 */
/***************************************/
function isLogin() {
	// 濡쒓렇�명븳吏��섎（ 吏�궃 寃쎌슦 濡쒓렇�꾩썐�쇰줈 泥섎━
	if (localStorage.getItem('Token') !== null) {
		return true;
	} else {
		deleteToken();
		return false;
	}
}

/***************************************/
/* �좎��뺣낫 �뺤씤 */
/***************************************/
function getUserInfo(data){
	for(var i = 0; i <data.count; i++){
		data.users[i].id;
		data.users[i].userid;
		data.users[i].getItem(user);
	}
}

/***************************************/
/* �쒓컙�뺣낫 蹂�솚 */
/***************************************/

function parseSimDate(data.lastModified)
{
	     this.getFullYear() + '-' +
               data.lastModified(this.getMonth() + 1) + '-' +
               data.lastModified(this.getDate()) + ' ' +
               data.lastModified(this.getHours()) + ':' +
               data.lastModified(this.getMinutes()) + ':' +
               data.lastModified(this.getSeconds());
}