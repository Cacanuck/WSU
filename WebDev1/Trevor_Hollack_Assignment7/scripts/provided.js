// first object
var person = {
  name: "Trevor Hollack",
  age: 25,
  hobbies: ["Eating", "Sleeping", "Coding"],
  displayinfo: function () {
    return (
      "Name:    " +
      person.name +
      "<br>" +
      "Age:     " +
      person.age +
      "<br>" +
      "Hobbie:  " +
      person.hobbies.join(", ")
    );
  },
};
var favorites = {
  favoriteAnimals: ["Gorilla", "Shark", "Penguin"],
  favoriteMusic: ["Rock", "Hip Hop", "EDM"],
  favoriteTeams: ["Vancouver Canucks", "Seattle Seahawks", "Bayern Munich"],
  displayFavorites: function () {
    return (
      "Favorite Animals:    " +
      favorites.favoriteAnimals.join(", ") +
      "<br>" +
      "FavoriteMusic:       " +
      favorites.favoriteMusic.join(", ") +
      "<br>" +
      "Favorite Teams:      " +
      favorites.favoriteTeams.join(", ")
    );
  },
};
function renderPersonalInfo() {
  var personalInfo = document.getElementById("personInfo");
  personalInfo.innerHTML = "<h2> Personal Info</h2>" + person.displayinfo();
}
function renderFavoritesInfo() {
  var FavoritesInfo = document.getElementById("favoritesInfo");
  FavoritesInfo.innerHTML =
    "<h2> Favorites Info</h2>" + favorites.displayFavorites();
}
renderPersonalInfo();
renderFavoritesInfo();
function createHeadings(text) {
  var heading = document.createElement("h2");
  heading.textContent = text;
  return heading;
}
function createParagraph(text) {
  var paragraph = document.createElement("p");
  paragraph.textContent = text;
  return paragraph;
}
//populat the article with heading, paragraph
function populatArticle(articleId, headingText, paragraphText) {
  var article = document.getElementById(articleId);
  var heading = createHeadings(headingText);
  var paragraph = createParagraph(paragraphText);

  article.appendChild(heading);
  article.appendChild(paragraph);
}

populatArticle(
  "personInfo",
  "About Me",
  "I was born and raised in California, and moved to Ohio 2 years ago.  I have been going to Wright State for 2 years, having transferred after 2 years at another school.  My current classes are Web Development 1, Data Structures and Algorithms, Human Computer Interaction, Mobil Application Development, and Introduction to IT Systems."
);
populatArticle(
  "favoritesInfo",
  "Other Hobbies",
  "My favorite video game genres are Shooters and MOBAs.  I play them with my girlfriend, who also enjoys thos games with me.  We spend a couple of hours on the weekend playing games together.  We also like to cook together.  She is a good baker, and I am pretty decent at grilling.  We like to make a bunch of different kinds of foods."
);

function updateFooter() {
  var footer = document.querySelector("footer");
  var currentYear = new Date().getFullYear();
  footer.textContent =
    "\u00A9 " + currentYear + "Trevor Hollack || WSU. All rights reserved.";
}

updateFooter();
