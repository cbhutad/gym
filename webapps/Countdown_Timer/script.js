const eventname = document.getElementById("eventname");
const eventdate = document.getElementById("eventdate");
const eventtime = document.getElementById("eventtime");
const countdowndisplay = document.getElementById("countdown-display");

let intervalId;
let startDate;
let endDate;
let days;
let remainingMS;
let hours;
let remainingMSAfterHours;
let minutes;
let remainingMSAfterMinutes;
let seconds;

function setTimer() {
	startDate = new Date();
	if (!eventtime) {
		endDate = new Date(eventdate.value+"T"+"00:00:00");
	} else {
		endDate = new Date(eventdate.value+"T"+eventtime.value+":00");
	}

	console.log(endDate, eventdate.value+"T"+eventtime.value+":00");

	// Calculate the time difference in milliseconds
	let timeDifferenceMS = endDate - startDate;

	if (timeDifferenceMS < 0 ) {
		alert("Cannot set event for past date");
		return;
	}

	// Calculate the elapsed time in days, hours, minutes, and seconds
	days = Math.floor(timeDifferenceMS / 86400000);
	remainingMS = timeDifferenceMS % 86400000;
	hours = Math.floor(remainingMS / 3600000);
	remainingMSAfterHours = remainingMS % 3600000;
	minutes = Math.floor(remainingMSAfterHours / 60000);
	remainingMSAfterMinutes = remainingMSAfterHours % 60000;
	seconds = Math.floor(remainingMSAfterMinutes / 1000);

	countdowndisplay.innerText = `Time difference: ${days} days, ${hours} hours, ${minutes} minutes, ${seconds} seconds`;

	if (!intervalId) {
		intervalId = setInterval(timer, 1000);
	}

}


function timer() {
	if (seconds === 0 && minutes === 0 && hours === 0 && days === 0) {
		clearInterval(intervalId);
	} else if (seconds !== 0 && minutes !== 0 && hours !== 0 && days !== 0) {
		seconds -= 1;
	} else if (seconds === 0 && minutes !== 0 && hours !== 0 && days !== 0) {
		seconds = 59;
		minutes -= 1;
	} else if (seconds !== 0 && minutes === 0 && hours !== 0 && days !== 0) {
		seconds -= 1;
	} else if (seconds === 0 && minutes === 0 && hours !== 0 && days !== 0) {
		seconds = 59;
		minutes = 59;
		hours -= 1;
	} else if (seconds !== 0 && minutes !== 0 && hours === 0 && days !== 0) {
		seconds -= 1;
	} else if (seconds === 0 && minutes !== 0 && hours === 0 && days !== 0) {
		seconds = 59;
		minutes -= 1;
	} else if (seconds === 0 && minutes === 0 && hours === 0 && days !== 0) {
		seconds = 59;
		minutes = 59;
		hours = 23;
		days -= 1;
	} else if (seconds !== 0 && minutes !== 0 && hours !== 0 && days === 0) {
		seconds -= 1;
	} else if (seconds === 0 && minutes !== 0 && hours !== 0 && days === 0) {
		seconds = 59;
		minutes -= 1;
	} else if (seconds === 0 && minutes === 0 && hours !== 0 && days === 0) {
		seconds = 59;
		minutes = 59;
		hours -= 1;
	} else if (seconds !== 0 && minutes !== 0 && hours === 0 && days === 0) {
		seconds -= 1;
	} else if (seconds === 0 && minutes !== 0 && hours === 0 && days === 0) {
		seconds = 59;
		minutes -= 1;
	}

	countdowndisplay.innerText = `Time difference: ${days} days, ${hours} hours, ${minutes} minutes, ${seconds} seconds`;
}
