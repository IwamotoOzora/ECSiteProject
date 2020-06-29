let targetElem = document.querySelectorAll('.subtotal');
console.log(targetElem)

let total = 0;

for (let i = 0; i < targetElem.length; i++) {
	(total += Number(targetElem[i].value * 1.1))
};

let element = document.createElement('div')

 element.innerText = "合計" + Math.round(total) + "円"

 let div = document.getElementById('total')

 console.log(div)
 console.log(Math.round(total))

 div.appendChild(element)

