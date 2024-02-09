const form = document.querySelector("form");
const nome = document.querySelector("#name");
const cpf = document.querySelector("#cpf");
const phoneNumber = document.querySelector("#phoneNumber");
const email = document.querySelector("#phoneNumber");

function save() {
	fetch("http://localhost:8080/clients",
		{
			headers: {
				'Accept': 'applications/json',
				'Content-Type': 'application/json'
			},
			method: "POST",
			body: JSON.stringify({
				name: nome.value,
				cpf: cpf.value,
				phoneNumber: phoneNumber.value,
				email: email.value
			})
		})
		.then(function(res) { console.log(res) })
		.catch(function(res) { console.log(res) })
};

function clean(){
	name.value = "";
	cpf.value = "";
	phoneNumber.value = "";
	email.value = "";
};

function list(){
	
}

form.addEventListener('submit', function(event) {
	event.preventDefault();
	save();
	clean();
});