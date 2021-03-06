const fullName = Cookies.get('fullName');
const id = Cookies.get('id');
const currentUnixTimestamp = Math.round((new Date()).getTime() / 1000);

$(document).ready(function() {
  // print name in navbar
  $('#usernameContainer').text(fullName);

  // create reimbursement
  $('#submitButton').click(function(e) {
    e.preventDefault();
    // parse form data
    const amount = parseInt($('#amount').val());
    const description = $('#description').val();
    const type_id = parseInt($('#type_id').val());

    // create reimbursementObject
    let reimbursementObject = {
      amount: amount,
      submitted: currentUnixTimestamp,
      resolved: null,
      description: description,
      receipt: null,
      author: id,
      resolver: null,
      statusID: 0,
      typeID: type_id
    }

    // Example POST method implementation:
    async function postData(url = '', data = {}) {
      // Default options are marked with *
      const response = await fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        headers: {
          // 'Content-Type': 'application/json'
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(data) // body data type must match "Content-Type" header
      });
      return response.json(); // parses JSON response into native JavaScript objects
    }

    postData(`${window.origin}/reimbursements`, reimbursementObject)
      .then(data => {
        console.log(data); // JSON data parsed by `data.json()` call
      })
      .catch(err => console.log(err));

    console.log(JSON.stringify(reimbursementObject));

    // show confirmationMessage
    $('#confirmationMessageContainer').removeClass('invisible');
    $('#confirmationMessage').text('Reimburement has been submitted.');
    $('#confirmationMessageCloseButton').click(function() {
      $('#confirmationMessageContainer').addClass('invisible');
    });

    // reset input values
    $('#amount').val('');
    $('#description').val('');
    ('#type_id').val('');

  });
  // end creare reimbursement

});
