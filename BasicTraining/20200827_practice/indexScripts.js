var balance = 2000;

// Sets initial balance
function updateBalance() {
  document.getElementById('balanceDiv').innerHTML = 'Balance = ' + balance;
}

function deposit() {
  let transaction = document.getElementById('box').value;

  // change to float and rounds to 2 decimals
  transaction = parseFloat(transaction).toFixed(2);
  console.log(transaction);
  let numberCheck = isNaN(transaction);
  console.log(numberCheck);

  // Checks if changed to float
  if (isNaN(transaction)) {
    alert('Please input a valid number.');
  }
  if (isNaN(transaction) == false) {
    let table = document.getElementById('transactions');
    // probeer document.createElement en dan parent.appendChild(newTrans) waar parent de parent element is waar je de trans in wilt stoppen
    let newListElement = table.createElement('li');
    newListElement.className = 'deposit';
    newListElement.appendChild(newListElement);
  }
}

// niet nodig, kan gewoon init() doen zolang je script onderaan body geladen wordt ;)
updateBalance();
