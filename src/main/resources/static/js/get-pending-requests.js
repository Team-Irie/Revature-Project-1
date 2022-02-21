var id = Cookies.get('id');
console.log(id);

fetch(`${window.origin}/reimbursements`)
  .then(res => res.json())
  .then(data => {
    console.log(data);

    const reimbursements = data;
    const reimbursementsLength = reimbursements.length;

    function convertType(typeID) {
      switch (typeID) {
        case 0:
          return 'Lodging'
          break;
        case 1:
          return 'Travel'
          break;
        case 2:
          return 'Food'
          break;
        case 3:
          return 'Other'
          break;
      }
    }

    function convertStatus(statusID) {
      switch (statusID) {
        case 0:
          return 'Pending'
          break;
        case 1:
          return 'Approved'
          break;
        case 2:
          return 'Denied'
          break;
      }
    }

    // fill table
    for (let i = 0; i < reimbursementsLength; i++) {
      if (reimbursements[i].statusID === 0) {
        var amount = `<td>$${reimbursements[i].amount}</td>`;
        var submitted = `<td>${new Date(reimbursements[i].submitted).toLocaleString('en-US', {timeZone: 'UTC'})}</td>`;
        var type = `<td>${convertType(reimbursements[i].typeID)}</td>`;
        var description = `<td>${reimbursements[i].description}</td>`;
        var status = `<td class="reimbursementStatus">${convertStatus(reimbursements[i].statusID)}</td>`;
        var approveButton = '<td><button id="approveButton" class="btn btn-success">Approve</button>';
        var denyButton = '<td><button id="denyButton" class="btn btn-danger">Deny</button>';

        let tableRow = `<tr>${amount}${submitted}${type}${description}${status}${approveButton}${denyButton}</tr>`
        $('#tableBody').append(tableRow);
      }
    }

    // approve request
    $('#approveButton').click(function(e) {
      console.log('e:', e);
      console.log('this:', this);
    })
  });
