function createLinks(link) {
  var a = document.createElement("a");
  a.href = "none";
  a.textContent = link;
  return a;
}
function createHeader(header) {
  var h1 = document.getElementsByTagName("h1")[0];
  h1.textContent = header;
  return header;
}

function renderHeader(header1) {
  var header = document.getElementsByTagName("header")[0];
  var header1 = createHeader(header1);

  header.appendChild(header1);
}

function renderLinks(link1, link2, link3) {
  var ul = document.createElement("ul");
  var li = document.createElement("li");
  var nav = document.getElementsByTagName("nav")[0];
  var Link1 = createLinks(link1);
  var Link2 = createLinks(link2);
  var Link3 = createLinks(link3);

  li.appendChild(Link1);
  li.appendChild(Link2);
  li.appendChild(Link3);
  ul.appendChild(li);
  nav.appendChild(ul);
}

renderLinks("Home", "About", "Contact");
renderHeader("Trevor Hollack: Assignment 7");
