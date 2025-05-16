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
  document.body.appendChild(footer);
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
  var article = document.createElement("article");
  var heading = createHeading(headingText);
  var paragraph = createParagraph(paragraphText);
  article.appendChild(heading);
  article.appendChild(paragraph);
  document.body.appendChild(article);
}

function createImage(image) {
    var header = document.querySelector("header");
    var img = document.createElement("img");
    img .src = image;
    header.appendChild(img);
}

document.addEventListener("DOMContentLoaded", function () {
  createHeader("Trevor Hollack");
  createImage("file:///Users/Trevor/Desktop/WebDev1/FinalProject/images/korra.jpg")
  populateNavLinks();
  populateArticle(
    "Background",
    "I was born and raised in Rancho Santa Margarita, California.  I moved to to Ohio in 2023 to go to Wright State University and am studying Computer Science.  I have always been fascinated by how computers and software work.  I also like to play ice, roller, and street hockey, as well as grill and smoke meats.  I also like to play video games with my girlfriend from time to time."
  );
  populateArticle(
    "Skills",
    "I am skilled with both Java and Python, having used them both extensively for many different projects and applications.  I have just started learning C++ and Kotlin, both being more difficult languages in my opinion, but they are difficult for different reasons.  I also learned how to use HTML, CSS, and JavaScript this semester, and I feel I have a pretty solid grasp of how they work, and how they are utilized together to create webpages."
  );
  populateArticle(
    "Goals",
    "My goals are to get a degree from Wright State University in Computer Science, and then take what I have learned into the workforce.  I would like to get a job working in the video game industry, as I feel I have a lot of good ideas that I oculd implement to improve any game that I am working on.  I also like to figure out how things work, so I would be interested in fixing bugs and ensuring that edge cases are accounted for."
  );
  createFooter();
});
