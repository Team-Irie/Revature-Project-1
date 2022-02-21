const fullName = Cookies.get('fullName');

$(document).ready(function() {
  // print name in navbar
  $('#usernameContainer').text(fullName);
});
