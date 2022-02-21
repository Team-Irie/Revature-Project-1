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
      if (reimbursements[i].statusID === 1 || reimbursements[i].statusID === 2) {
        var amount = `<td>$${reimbursements[i].amount}</td>`;
        var submitted = `<td>${new Date(reimbursements[i].submitted).toLocaleString('en-US', {timeZone: 'UTC'})}</td>`;
        var type = `<td>${convertType(reimbursements[i].typeID)}</td>`;
        var description = `<td>${reimbursements[i].description}</td>`;
        var status = `<td class="reimbursementStatus">${convertStatus(reimbursements[i].statusID)}</td>`;
        var resolver = `<td class="resolvedBy">${reimbursements[i].resolver}</td>`;
        var resolved = `<td>${reimbursements[i].resolved === null ? 'N/A' : new Date(reimbursements[i].resolved).toLocaleString('en-US', {timeZone: 'UTC'})}</td>`;


        let tableRow = `<tr>${amount}${submitted}${type}${description}${status}${resolver}${resolved}</tr>`
        $('#tableBody').append(tableRow);
      }
    }

    $('#requestsFilter').change(function() {
      console.log('requestsFilter value:', this.value);
      if (this.value == 1) {
        $('.1').show();
        $('.2').hide();
      }
      if (this.value == 2) {
        $('.2').show();
        $('.1').hide();
      }
      if (this.value == 3) {
        $('.1').show();
        $('.2').show();
      }
    });

  });
