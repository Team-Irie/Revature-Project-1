fetch(`${window.origin}/reimbursements`)
  .then(res => res.json())
  .then(data => {
    console.log(data);

    const reimbursements = data;
    const reimbursementsLength = reimbursements.length;

    for (let i = 0; i < reimbursementsLength; i++) {
      let amount = `<td>$${reimbursements[i].amount}</td>`;
      let submitted = `<td>${reimbursements[i].submitted}</td>`;
      let type = `<td>${reimbursements[i].typeID}</td>`;
      let description = `<td>${reimbursements[i].description}</td>`;
      let status = `<td>${reimbursements[i].statusID}</td>`;
      let resolver = `<td>${reimbursements[i].resolver}</td>`;
      let resolved = `<td>${reimbursements[i].resolved}</td>`;

      let tableRow = `<tr>${amount}${submitted}${type}${description}${status}${resolver}${resolved}</tr>`
      $('#tableBody').append(tableRow);
    }
  });
