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
      status_id: 0,
      type_id: type_id
    }


    console.log(JSON.stringify(reimbursementObject));
  });
});
