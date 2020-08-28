const button = document.getElementById('add');

const addTransaction = () => {
  const list = document.querySelector('ul');

  const newItem = document.createElement('li');
  newItem.classList.add('transaction');
  newItem.classList.add('deposit');
  newItem.innerText = 1500;

  list.insertAdjacentElement();
};

button.addEventListener('click', addTransaction);
