const jsonArea = document.getElementById("jsonstr");

function checkValidJSON(jsondata) {
	if (jsondata === "") {
		return false;
	}
	try {
		JSON.parse(jsondata);
		return true;
	} catch (exception) {
		return false;
	}
}

function convert() {
	const result = checkValidJSON(jsonArea.value);
	if (result === false) {
		alert("Provided json input is either empty or not valid");
	}
}
