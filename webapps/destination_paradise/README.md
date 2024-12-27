# Destination Paradise

Fictional travel agency. This is a sample practice project from the [code360](https://www.naukri.com/code360/web-development?offering_type=WEB_PROJECTS) website.

## Tools used

- HTML
- CSS (bootstrap)
- Javascript
- Bootstrap version 

## Folders and Files

- images -> folder contains the images being displayed in the carousel.
- Destination_Paradise.pdf -> instructions on what to be included in the project.

## Notes

## Adding Bootstrap

To add bootstrap just check the download section provided on the website for more details. The version that is used in the project is `5.3.3`. We use the cdn way to install the required files.

## Working the Navbar

In order to setup the navbar we start with the basic [navbar example](https://getbootstrap.com/docs/5.3/components/navbar/#supported-content) provided in the documentations of the bootstrap. After modifying the same to add only the required links and input field we get the following refined `nav` tag and this is the subsequent result.

![Navbar image1](./screenshots/image1.png)

Next we try to center the provided links `Home`, `About` and `Destinations`. First after observation the provided elements `ul` containing the links and `form` are child of parent `div` tag. So we use the `row` class on parent `div` tag and `col` on both child tags to create 2 equal columms. 

![Navbar image2](./screenshots/image2.png)

We have an expanded `search` input field and in order to reduce its size we use the `col-sm-*` class.

![Navbar image3](./screenshots/image3.png)

And to center the links for the `ul` tag we use the `justify-content-center` class.

![Navbar image4](./screenshots/image4.png)

The Destinations url needs to display options on hover and in order to do this we need to add a bit of custom css.