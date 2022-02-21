const fullName = Cookies.get('fullName');

$(document).ready(function() {
  // print name in navbar
  $('#usernameContainer').text(fullName);

  // get all employees
  fetch(`${window.origin}/users`)
    .then(res => res.json())
    .then(data => {
      // fill table
      const users = data;
      const usersLength = data.length;

      for (let i = 0; i < usersLength; i++) {
        var userId = `<td>${users[i].id}</td>`;
        var username = `<td>${users[i].username}</td>`;
        var firstName = `<td>${users[i].firstName}</td>`;
        var lastName = `<td>${users[i].lastName}</td>`;
        var email = `<td>${users[i].email}</td>`;
        var viewUserRequestsButton = `<td><button id="viewUserRequestsButton" class="btn btn-primary" name="${users[i].id}">View Requests</button></td>`;

        let tableRow = `<tr>${userId}${username}${firstName}${lastName}${email}${viewUserRequestsButton}</tr>`;
        $('#tableBody').append(tableRow);
      }

      $('#viewUserRequestsButton').click(function() {
        console.log(this.name);
      })
    })
    .catch(err => console.log(err));
});
