const fullName = Cookies.get('fullName');
console.log('loaded');

$(document).ready(function() {
  // print name in navbar
  $('#usernameContainer').text(fullName);
  $('#viewEmployees').click(function() {
    console.log('clicked');
    fetch(`${window.origin}/users`)
      .then(res => console.log(res));
  });
});
