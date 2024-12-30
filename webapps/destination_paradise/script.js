const countryCodes = [
    { code: "+1", name: "USA" },
    { code: "+1", name: "Canada" },
    { code: "+52", name: "Mexico" },
    { code: "+852", name: "Hong Kong" },
    { code: "+44", name: "UK" },
    { code: "+33", name: "France" },
    { code: "+49", name: "Germany" },
    { code: "+66", name: "Thailand" },
    { code: "+84", name: "Vietnam" },
    { code: "+91", name: "India" },
    { code: "+27", name: "South Africa" },
    { code: "+61", name: "Australia" },
    { code: "+64", name: "New Zealand" },
    { code: "+971", name: "UAE" },
    { code: "+81", name: "Japan" },
    { code: "+82", name: "South Korea" },
    { code: "+39", name: "Italy" },
    { code: "+30", name: "Greece" },
    { code: "+90", name: "Turkey" },
    { code: "+55", name: "Brazil" },
    { code: "+54", name: "Argentina" },
    { code: "+56", name: "Chile" },
    // Add more countries as needed
];

/* Loading countryCodes options */
const countryCodeSelect = document.getElementById("countryCode");

for (let i = 0;i < countryCodes.length;i++) {
    const option = document.createElement("option");
    option.value = countryCodes[i].code;
    option.innerHTML = countryCodes[i].name;
    countryCodeSelect.appendChild(option);
}

/* Validate phone number function */
function validatePhoneNumber() {
	// get and trim phone number input
	const phoneNumber = document.getElementById("phone").value.trim();

	// regex pattern for 10-digit phone number
	const pattern = /^\d{10}$/;

	// validate phone number and update message
	const isValid = pattern.test(phoneNumber);
	if (isValid) {
		document.getElementById("phone-number-error").style.display = "none";
	} else {
		document.getElementById("phone-number-error").style.display = "block";
		document.getElementById("phone-number-error").innerText = "Please enter a valid 10 digit number";
	}

	return isValid;
}

/* Validate age for less than 18 years old */
function validateAge() {
	// get and trim birthday input
	const birthday = document.getElementById("birthday").value.trim();
	const birthdate = new Date(birthday);
	console.log(birthdate);

	// Calculate the difference in milliseconds between the two dates
	let diff = (birthdate.getTime() - Date.now()) / 1000;
	// Convert the difference from milliseconds to days
	diff /= (60 * 60 * 24);
	// Calculate the approximate number of years by dividing the difference in days by the average number of days in a year (365.25)
	const years = Math.abs(Math.round(diff / 365.25));
	
	const isValid = years >= 18;

	if (isValid) {
		document.getElementById("birthday-error").style.display = "none";
	} else {
		document.getElementById("birthday-error").style.display = "block";
		document.getElementById("birthday-error").innerText = "You must be atleast 18 years old";
	}

	return isValid;
}

/* Validate form */
function validateForm() {
	const validPhone = validatePhoneNumber();
	const validAge = validateAge();

	if (validPhone && validAge) {
		alert(" Thanks for your interest, our tour experts will get back to you shorty! ");
		document.getElementById("bookingForm").reset();
	}
}
