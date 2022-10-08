// getActivities()
getData('https://vtbservice.herokuapp.com/account/orders','GET')

function getData(url, method){
    const tokenauth = localStorage.getItem('tokenauth')
    const auth = localStorage.getItem('auth')


    fetch(url,{
        method: method,
        mode: 'cors',
        headers:{
            'Accept': '*/*',
            'Auth' : auth,
            'x-csrf-token': tokenauth
        }	})
        .then(response => response.json())
        .then(data => {
            console.log(data)
        })
}
