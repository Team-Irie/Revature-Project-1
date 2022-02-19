const fullName = Cookies.get('fullName');

$(document).ready(function() {
  // print name in navbar
  $('#usernameContainer').text(fullName);
  $('#viewEmployees').click(function() {
    console.log('clicked');
    fetch(`${window.origin}/users`)
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        console.log(data);
        
      });
  });
});
