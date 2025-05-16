function createHeader(text) {
  var header = document.createElement("header");
  var heading = document.createElement("h1");
  heading.textContent = text;
  header.appendChild(heading);
  document.body.prepend(header);
}

function createFooter() {
  var footer = document.querySelector("footer");
  var currentYear = new Date().getFullYear();
  footer.textContent =
    "\u00A9 " + currentYear + " Trevor Hollack. All rights reserved.";
}

function createNavLink(text, href) {
  var listItem = document.createElement("li");
  var link = document.createElement("a");
  link.textContent = text;
  link.href = href;
  listItem.appendChild(link);
  return listItem;
}

function populateNavLinks() {
  var nav = document.querySelector("nav");
  var ul = document.createElement("ul");
  ul.appendChild(createNavLink("Home", "index.html"));
  ul.appendChild(createNavLink("Interests", "interests.html"));
  ul.appendChild(createNavLink("Registration", "registration.html"));
  nav.appendChild(ul);
}

function createHeading(text) {
  var heading = document.createElement("h2");
  heading.textContent = text;
  return heading;
}

function createParagraph(text) {
  var paragraph = document.createElement("p");
  paragraph.textContent = text;
  return paragraph;
}

function populateArticle(headingText, paragraphText) {
  var article = document.querySelector("article");
  var heading = createHeading(headingText);
  var paragraph = createParagraph(paragraphText);
  article.appendChild(heading);
  article.appendChild(paragraph);
}

function showRegistrationForm() {
  var registrationDiv = document.querySelector("section");
  registrationDiv.innerHTML =
    "<h3>Register</h3>" +
    '<form id="registrationForm">' +
    '<label for="firstName">First Name</label><br>' +
    '<input type ="text" id="firstName" name="fname" required><br>' +
    '<label for="lastName">Last Name</label><br>' +
    '<input type ="text" id="lastName" name="lname" required><br>' +
    '<label for="email">Email</label><br>' +
    '<input type ="email" id="email" name="email" required><br>' +
    '<label for="phone">Phone</label><br>' +
    '<input type ="phone" id="phone" name="phone" required><br>' +
    "<br>" +
    "<h5>Gender</h5>" +
    '<label for="male">Male</label><br>' +
    '<input type="radio" id="male" name="gender"><br>' +
    '<label for="female">Female</label><br>' +
    '<input type="radio" id="female" name="gender"><br>' +
    "<br>" +
    "<h5>Interests</h5>" +
    '<input type ="checkbox" id="cooking" name="cooking"><br>' +
    '<label for="cooking">Cooking.</label><br>' +
    '<input type ="checkbox" id="hockey" name="hockey"><br>' +
    '<label for="hockey">Hockey.</label><br>' +
    '<input type ="checkbox" id="videoGames" name="videoGames"><br>' +
    '<label for="videoGames">Video Games.</label><br>' +
    '<input type ="checkbox" id="dogs" name="dogs"><br>' +
    '<label for="dogs">Dogs.</label><br>' +
    '<button type="submit">Submit</button>' +
    "</form>";

  document
    .getElementById("registrationForm")
    .addEventListener("submit", handleFormSubmit);
}

function handleFormSubmit(event) {
  event.preventDefault();

  var firstName = document.getElementById("firstName").value;
  var lastName = document.getElementById("lastName").value;
  var email = document.getElementById("email").value;
  var phone = document.getElementById("phone").value;
  var registrationDiv = document.querySelector("section");
  var tableData = [
    ["First Name", firstName],
    ["Last Name", lastName],
    ["Email", email],
    ["Phone", phone],
  ];
  createTable(tableData);
}

function createTable(data) {
  var container = document.querySelector("section");
  container.innerHTML = "";
  var table = document.createElement("table");
  data.forEach(([label, value]) => {
    var tr = document.createElement("tr");
    var labelCell = document.createElement("td");
    labelCell.textContent = label;
    tr.appendChild(labelCell);
    var valCell = document.createElement("td");
    valCell.textContent = value;
    tr.appendChild(valCell);
    table.appendChild(tr);
  });
  container.appendChild(table);
}

document.addEventListener("DOMContentLoaded", function () {
  createHeader("Trevor Hollack");
  populateNavLinks();
  populateArticle(
    "Register Here",
    "Please register with your name, email, phone number, gender, and interests."
  );
  showRegistrationForm();
  createFooter();
});
