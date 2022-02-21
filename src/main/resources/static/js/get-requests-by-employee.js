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
      if (id == reimbursements[i].author) {
        let amount = `<td>$${reimbursements[i].amount}</td>`;
        let submitted = `<td>${new Date(reimbursements[i].submitted).toLocaleString('en-US', {timeZone: 'UTC'})}</td>`;
        let type = `<td>${convertType(reimbursements[i].typeID)}</td>`;
        let description = `<td>${reimbursements[i].description}</td>`;
        let status = `<td class="reimbursementStatus">${convertStatus(reimbursements[i].statusID)}</td>`;
        let resolver = `<td class="resolvedBy">${reimbursements[i].resolver}</td>`;
        let resolved = `<td>${reimbursements[i].resolved === null ? 'N/A' : new Date(reimbursements[i].resolved).toLocaleString('en-US', {timeZone: 'UTC'})}</td>`;

        let tableRow = `<tr class="${reimbursements[i].statusID}">${amount}${submitted}${type}${description}${status}${resolver}${resolved}</tr>`
        $('#tableBody').append(tableRow);
      }
    }

    $('#requestsFilter').change(function() {
      console.log('requestsFilter value:', this.value);
      if (this.value == 0) {
        $('.0').show();
        $('.1').hide();
        $('.2').hide();
      }
      if (this.value == 1) {
        $('.1').show();
        $('.0').hide();
        $('.2').hide();
      }
      if (this.value == 2) {
        $('.2').show();
        $('.0').hide();
        $('.1').hide();
      }
      if (this.value == 3) {
        $('.0').show();
        $('.1').show();
        $('.2').show();
      }
    });

  });
