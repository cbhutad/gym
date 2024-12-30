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

// Packages array
const packages = [
	{
	name: "Beach Getaway",
	photo: "https://cdn.pixabay.com/photo/2016/11/23/13/48/beach-1852945_640.jpg",
	description: "Enjoy a relaxing time at the sunny beaches of Bali. Inclusive of hotel stay and guided tours."
	},
	{
	name: "Mountain Adventure",
	photo: "https://cdn.pixabay.com/photo/2016/11/14/03/26/cliff-1822484_640.jpg",
	description: "Explore the thrilling trails of the Himalayas. Package includes hiking, camping, and meals."
	},
	{
	name: "City Life Experience",
	photo: "https://cdn.pixabay.com/photo/2017/03/29/15/18/tianjin-2185510_1280.jpg",
	description: "Discover the vibrant life of New York City. Comes with city tours and museum passes."
	},
	// Add more packages as needed
];

/* Loading countryCodes options */
const countryCodeSelect = document.getElementById("countryCode");

function loadCountryCodes() {
	for (let i = 0;i < countryCodes.length;i++) {
		const option = document.createElement("option");
		option.value = countryCodes[i].code;
		option.innerHTML = countryCodes[i].name;
		countryCodeSelect.appendChild(option);
	}
}

/* Loading packages */
const packagesContainer = document.getElementById("packages-container");

function loadPackages() {
	packages.forEach(pkg => {
		const packageElement = document.createElement("div");
		packageElement.className = "package";
		packageElement.innerHTML = `
			<div class="image-container">
				<img src="${pkg.photo}" alt="${pkg.name}">
			</div>
			<h4 class="package-name">${pkg.name}</h4>
			<p class="package-description">${pkg.description}</p>
			<a href="#" class="book-now-btn">Book Now</a>
		`;
		packagesContainer.appendChild(packageElement);
	});
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
		// Resetting the form on successful validations.
		document.getElementById("bookingForm").reset();
	}
}

/* Search input functionality */
const searchInput = document.querySelector('input[type="search"]');

searchInput.addEventListener('input', (event) => {
	if (searchInput.value.length != 0) {
		for(let i = 0;i < packages.length; i++) {
			if (packages[i].name.toLowerCase().includes(searchInput.value.toLowerCase())) {
				packagesContainer.innerHTML = "";
				const packageElement = document.createElement("div");
				packageElement.className = "package";
				packageElement.innerHTML = `
					<div class="image-container">
						<img src="${packages[i].photo}" alt="${packages[i].name}">
					</div>
					<h4 class="package-name">${packages[i].name}</h4>
					<p class="package-description">${packages[i].description}</p>
					<a href="#" class="book-now-btn">Book Now</a>
				`;
				packagesContainer.appendChild(packageElement);
				break;
			}
		}
	} else {
		packagesContainer.innerHTML = "";
		loadPackages();
	}
});

loadCountryCodes();
loadPackages();