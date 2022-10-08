let submitlogin = document.getElementById('loginform')
let login = document.getElementById('exampleInputEmail1')
let password = document.getElementById('exampleInputPassword1')
let btnlogin = document.getElementById('btn-login')

// submitlogin.addEventListener('submit', ()=>{
//
// 	if (!(login.value == null ||login.value || password.value)){
// 	alert('не хватает данных')
// 	} else{
// }})

btnlogin.addEventListener('click',(event)=>{
	event.preventDefault()

	if ((login.value == null) || password.value == null || !(password.value) || !(login.value)){
	document.getElementById('login-info').innerText = 'Ошибка с авторизацией'

	} else{

	var userlofinwithpass = login.value + ':' +  password.value
	let encoded = window.btoa(userlofinwithpass)
		let auth = 'Basic ' + encoded

	fetch('http://localhost:8085/auth/login', {
		method: 'POST',
		mode: 'cors',
		headers: {
			'Authorization': auth,
		}
	})
		.then((response) => {
			globalResponse = response;
			const tokenauth = globalResponse.headers.get('X-Csrf-Token')

			if (globalResponse.status == '200'){
				console.log(login.value, password.value)
				alert('ura')
				localStorage.setItem('auth', auth)
				localStorage.setItem('tokenauth', tokenauth)

				localStorage.setItem('name', login.value)
				localStorage.setItem('password', password.value)

				window.location.href="./personal-account/index.html";

			}
			else{
				document.getElementById('login-info').innerText = 'Ошибка с авторизацией'
			}

		})
		// getActivities()

	}
})
function getActivities(){
	const tokenauth = localStorage.getItem('tokenauth')

	fetch(`http://localhost:8085/info/activities?token=${tokenauth}`,{
		method: 'GET',
		headers:{
			'Accept': 'application/json'
		}	})
		.then(response => response.json())
		.then(data => {
			console.log(data)
		})
}

// question = {
// 	'login': 'motwik',
// 	'password': 'motwik'
// }
// fetch(`https://vtbservice.herokuapp.com/admin/loginForms`,{
// 	method:'POST',
// 	mode:'cors',
// 	body: JSON.stringify(question),
// 	headers: {
// 		'Access-Control-Allow-Methods': "POST, GET, OPTIONS, DELETE, PUT",
// 		'x-srf': 'eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiOTIwMzcyZTQ3N2U0MGEzYTllMjEzMWZiN2JhMTlmMiIsImlhdCI6MTY2NTI0MzE1NiwibmJmIjoxNjY1MjQzMTU2LCJleHAiOjE2NjUyNDQ5NTZ9.u0AgrS_PEGl_35ZCHPPP98be9K5632myXLV43G8MaPI',
// 		'Accept': 'application/json'
// 	}
// })
// 	.then(response => response.json())
// 	.then(data => {
// 		console.log(data)
// 	})