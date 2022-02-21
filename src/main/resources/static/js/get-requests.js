fetch(`${window.origin}/reimbursements`)
  .then(res => res.json())
  .then(data => {
    console.log(data);

    const reimbursements = data;
    const reimbursementsLength = reimbursements.length

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
          return 'Resolved'
          break;
      }
    }

    for (let i = 0; i < reimbursementsLength; i++) {
      let amount = `<td>$${reimbursements[i].amount}</td>`;
      let submitted = `<td>${new Date(reimbursements[i].submitted)}</td>`;
      let type = `<td>${convertType(reimbursements[i].typeID)}</td>`;
      let description = `<td>${reimbursements[i].description}</td>`;
      let status = `<td>${convertStatus(reimbursements[i].statusID)}</td>`;
      let resolver = `<td>${reimbursements[i].resolver}</td>`;
      let resolved = `<td>${null ? 'N/A' : new Date(reimbursements[i].resolved)}</td>`;

      let tableRow = `<tr>${amount}${submitted}${type}${description}${status}${resolver}${resolved}</tr>`
      $('#tableBody').append(tableRow);
    }
  });
