const displayParagraph = document.getElementById("calculatordisplay");
displayParagraph.innerText = "";
let number = "";
let previousValues = [];

function operatorclick(operator) {
	
	// user clicks 0 - 9
	switch (operator) {
		
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			
			if (number.length <= 8) {
				number = number + operator;
				if (displayParagraph.innerText === "") {
					displayParagraph.innerText = operator;
				} else {
					if (displayParagraph.innerText[displayParagraph.innerText.length - 1] === "+" ||  displayParagraph.innerText[displayParagraph.innerText.length - 1] === "-" || displayParagraph.innerText[displayParagraph.innerText.length - 1] === "*" || displayParagraph.innerText[displayParagraph.innerText.length - 1] === "/") {
						displayParagraph.innerText = displayParagraph.innerText.substring(0) + " " + operator;
					} else {
						displayParagraph.innerText = displayParagraph.innerText.substring(0) + operator;
					}
				}
			}
			break;

		case "+":
		case "-":
		case "*":
		case "/":
			number = "";
			if (displayParagraph.innerText === "") {
				displayParagraph.innerText = "";
			} else {
				if (displayParagraph.innerText[displayParagraph.innerText.length - 1] === "+" ||  displayParagraph.innerText[displayParagraph.innerText.length - 1] === "-" || displayParagraph.innerText[displayParagraph.innerText.length - 1] === "*" || displayParagraph.innerText[displayParagraph.innerText.length - 1] === "/") {
					displayParagraph.innerText = "Error. cannot allow operator after operator. Press C and retry";
					return;
				} else {
					displayParagraph.innerText = displayParagraph.innerText + " " + operator;
				}
			}
			break;

		case "=":
			if (displayParagraph.innerText !== "") {
				const splits = displayParagraph.innerText.split(" ");
				const currentLength = splits.length;

				if (splits[currentLength - 1] === "+" || splits[currentLength - 1] === "-" || splits[currentLength - 1] === "*" || splits[currentLength - 1] === "/") {
					displayParagraph.innerText = "Error. cannot allow = after any other operator such as +,-,/,*. Press C and retry";
					return;

				} else {
					while (splits.length !== 1) {
						// first check for / or *
						for (let i = 0;i < splits.length;i++) {
							if (splits[i] === "/" || splits[i] === "*") {
								let num1 = Number(splits[i - 1]);
								let num2 = Number(splits[i + 1]);
								if (splits[i] === "/") {
									if (num2 == 0) {
										displayParagraph.innerText = "Error. cannot divide by 0. Press C and retry";
										return;
									}
									splits[i-1] = "" + (num1 / num2);
								} else {
									splits[i-1] = "" + (num1 * num2);
								}
								splits.splice(i, 2);
							}
						}

						for (let i = 0;i < splits.length;i++) {
							if (splits[i] === "+" || splits[i] === "-") {
								let num1 = Number(splits[i - 1]);
								let num2 = Number(splits[i + 1]);

								if (splits[i] === "+") {
									splits[i-1] = "" + (num1 + num2);
								} else {
									splits[i-1] = "" + (num1 - num2);
								}
								splits.splice(i, 2);
							}

						}
					}

					previousValues.push(splits[0]);
					displayParagraph.innerText = splits[0];
				}
			}

			break;

		case "C":
			number = "";
			if (displayParagraph.innerText !== "") {
				
				if (displayParagraph.innerText.indexOf("Error") > -1) {
					if (previousValues.length === 0) {
						displayParagraph.innerText = "";
						previousValues = [];
						return;
					} else if (previousValues.length === 1) {
						displayParagraph.innerText = previousValues[0];
						previousValues = [];
						return;
					} else {
						displayParagraph.innerText = previousValues[previousValues.length - 1];
						previousValues.pop();
					}
					return;

				}

				const splits = displayParagraph.innerText.split(" ");
				if (splits.length === 1) {
					if (previousValues.length === 0) {
						displayParagraph.innerText = "";
						previousValues = [];
						return;
					} else if (previousValues.length === 1) {
						displayParagraph.innerText = previousValues[0];
						previousValues = [];
						return;
					} else {
						displayParagraph.innerText = previousValues[previousValues.length - 1];
						previousValues.pop();
					}
					return;
				} else {
					splits.pop();
					displayParagraph.innerText = splits.join(" ");
				}
			}
			break;

		case "AC":
			number = "";
			displayParagraph.innerText = "";
			previousValues = [];
			break;
	}
}
