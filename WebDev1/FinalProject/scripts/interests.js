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

const tableData = [
  ["Activity", "Description", "Time Spent"],
  [
    "Cooking",
    "I like to cook, grill, and smoke meats.  Making food that tastes good brings me a lot of satisfaction, as I like both to eat good food, but also make delicious food for others.",
    "Preparation can last up to 4 days for some foods and recipes.",
  ],
  [
    "Hockey",
    "Hockey is my favorite sport.  I love playing, coaching, and watching.  I have recently been working with my girlfriend to get her started playing street hockey, and during the summer we get together with some friends and play street hockey at one of the local parks that has a rink.",
    "Played for over 22 years.",
  ],
  [
    "Video Games",
    "I like to relax by playing video games, especially with friends.  Having a relaxing time hanging out with friends all trying to accomplish the same goal is a good way to wind down after a long day, and it has built and sustained many friendships over the years.",
    "Typically about an hour a night, sometimes more on the weekends, sometimes less if I am busy.",
  ],
  [
    "Playing with my dog",
    "My dog Korra is a 4 year old Pomsky, which is a Pomeranian - Husky mix.  She has a ton of energy and loves to play, and I enjoy spending time with her.  She is also very fluffy and soft, so when she eventually gets tired, laying down next to her is one of the most comfortable feeelings in the world.",
    "2 years of playtime.,",
  ],
];
function createTable(data) {
  var container = document.querySelector("body");
  var table = document.createElement("table");
  for (let i = 0; i < data.length; i++) {
    var tr = document.createElement("tr");
    for (let j = 0; j < data[i].length; j++) {
      var cell;
      if (i == 0) {
        cell = document.createElement("th");
      } else {
        cell = document.createElement("td");
      }
      cell.textContent = data[i][j];
      tr.appendChild(cell);
    }
    table.appendChild(tr);
  }
  container.appendChild(table);
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

document.addEventListener("DOMContentLoaded", function () {
  createHeader("Trevor Hollack");
  populateNavLinks();
  populateArticle(
    "Interests",
    "This is a table about some of my interests, as well as how long I have either had these interests, or how long they take."
  );
  createTable(tableData);
  createFooter();
});
