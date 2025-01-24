const paragraphBox = document.getElementById("box");
const topLeftInput = document.getElementById("topleft");
const topRightInput = document.getElementById("topright");
const bottomLeftInput = document.getElementById("bottomleft");
const bottomRightInput = document.getElementById("bottomright");

function topLeftBorder() {
	const topLeftValue = topLeftInput.value;
	//console.log(topLeftValue);
	paragraphBox.style.borderTopLeftRadius = topLeftValue + "px";
}

function topRightBorder() {
	const topRightValue = topRightInput.value;
	paragraphBox.style.borderTopRightRadius = topRightValue + "px";
}

function bottomLeftBorder() {
	const bottomLeftValue = bottomLeftInput.value;
	paragraphBox.style.borderBottomLeftRadius = bottomLeftValue + "px";
}

function bottomRightBorder() {
	const bottomRightValue = bottomRightInput.value;
	paragraphBox.style.borderBottomRightRadius = bottomRightValue + "px";
}

function copycss(type) {

	if (type === "topleft") {
		topLeftInput.select();
		navigator.clipboard.writeText(
			`.box {\n\tborder-top-left-radius: ${topLeftInput.value}px;\n}`
		);
		alert("copied css");
	} else if (type === "topright") {
		topRightInput.select();
		navigator.clipboard.writeText(
			`.box {\n\tborder-top-right-radius: ${topRightInput.value}px;\n}`
		);
		alert("copied css");
	} else if (type === "bottomleft") {
		bottomLeftInput.select();
		navigator.clipboard.writeText(
			`.box {\n\tborder-bottom-left-radius: ${bottomLeftInput.value}px;\n}`
		);
		alert("copied css");
	} else if (type === "bottomright") {
		bottomRightInput.select();
		navigator.clipboard.writeText(
			`.box {\n\tborder-bottom-right-radius: ${bottomRightInput.value}px;\n}`
		);
		alert("copied css");
	}

}
