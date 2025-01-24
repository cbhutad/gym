const resultSpan = document.getElementById("result");
const errorMessageSpan = document.getElementById("error-message");

function generateDecimal() {

	// fetch the input string provided by user.
	const binaryInput = document.getElementById("binarystring").value.trim();

	// check for binary constraint of the string.
	for (let i = 0;i < binaryInput.length; i++) {
		if (binaryInput[i] != '1' && binaryInput[i] != '0') {
			errorMessageSpan.innerText = "Error : binary string does not allow integers apart from 0 and 1";
			return;
		}
	}
	
	// calculate the equivalent decimal value.
	let power = 0;
	let decimalValue = 0;
	
	for (let i = binaryInput.length - 1;i >= 0; i--) {
		if (binaryInput[i] == '1') {
			decimalValue = decimalValue + (2 ** power);
		}
		power++;
	}

	resultSpan.innerText = "Decimal Equivalent : " + decimalValue;
}
