// <!-- amount, submitted, resolved, description, receipt, author, resolver, status_id, type_id  -->
const fullName = Cookies.get('fullName');
const id = Cookies.get('id');
const currentUnixTimestamp = Math.round((new Date()).getTime() / 1000);

$(document).ready(function() {
  // print name in navbar
  $('#usernameContainer').text(fullName);

  // trigger submit reimbursement Modal
  $('#submitButton').click(function(e) {
    e.preventDefault();
    const amount = parseInt($('#amount').val());
    const description = $('#description').val();
    const type_id = parseInt($('#type_id').val());

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

  }); // end submit click
});
