const keyvalue = document.getElementById("key-value");
const keycode = document.getElementById("key-code");
const altkey = document.getElementById("alt-key");
const ctrlkey = document.getElementById("ctrl-key");
const shiftkey = document.getElementById("shift-key");

addEventListener("keydown", (event) => {

	if (event.key !== "Shift" && event.key !== "Control" && event.key !== "Alt") {
		keyvalue.innerText = event.key;
		keycode.innerText = event.code;
	}

	if (event.ctrlKey) {
		ctrlkey.innerText = "true";
	} else {
		ctrlkey.innerText = "false";
	}

	if (event.shiftKey) {
		shiftkey.innerText = "true";
	} else {
		shiftkey.innerText = "false";
	}

	if (event.altKey) {
		altkey.innerText = "true";
	} else {
		altkey.innerText = "false";
	}
});
