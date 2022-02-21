console.log(window.origin);

function handleLogin(e) {
  e.preventDefault();

  const email = $('#email').val();
  const password = $('#password').val();
  const loginMessage = $('#loginMessage');
  const errorMessage = $('#errorMessage');

  let loginObject = {
    email: 'hkearle0@loc.gov',
    password: '8ZkVeA'
  };

  async function postData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
      method: 'POST', // *GET, POST, PUT, DELETE, etc.
      headers: {
      //   // 'Content-Type': 'application/json'
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: data // body data type must match "Content-Type" header
    });
    console.log('response:', response.json());
    return response.json(); // parses JSON response into native JavaScript objects
  }

  postData(`${window.origin}/login`, loginObject)
    .then(res => res.json())
    .then(data => {
      console.log(data);
    })
    .catch(err => console.log(err));


  // for (let i = 0; i < users.length; i++) {
  //   if (email === users[i].email && password === users[i].password) {
  //     const user = users[i];
  //     Cookies.set('username', user.username);
  //     Cookies.set('fullName', `${user.first_name} ${user.last_name}`);
  //     Cookies.set('id', user.id);
  //     Cookies.set('roleID', user.roleID);
  //     if (user.roleID === 'EMPLOYEE') {
  //       window.location = `${window.origin}/views/employee/dashboard.html`;
  //     }
  //     if (user.roleID === 'FINANCE_MANAGER') {
  //       window.location = `${window.origin}/views/manager/dashboard.html`;
  //     }
  //     loginMessage.style.color = 'green';
  //     loginMessage.innerHTML = 'Logging in...';
  //     return;
  //   } else {
  //     loginMessage.style.color = 'red';
  //     loginMessage.innerHTML = "Invalid credentials, please try again."
  //   }
  // }

} // end handleLogin() function

const loginButton = document.getElementById('loginButton');

loginButton.addEventListener('click', handleLogin);
