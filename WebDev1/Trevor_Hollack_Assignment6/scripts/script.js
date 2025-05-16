function displayArticle1() {
  var images = [
    "imagesFolder/img_1.png",
    "imagesFolder/img_2.png",
    "imagesFolder/img_3.png",
    "imagesFolder/img_4.png",
    "imagesFolder/img_5.png",
    "imagesFolder/img_6.png",
  ];
  var article = document.getElementById("articleOne");
  for (var i = 0; i < images.length; i++) {
    var div = document.createElement("div");
    var title = document.createElement("h2");
    title.textContent = "Title " + (i + 1);
    var img = document.createElement("img");
    img.src = images[i];
    img.alt = "Placeholder Image " + (i + 1);
    var description = document.createElement("p");
    description.textContent =
      "Lorem ipsum dolor sit, amet consectetur adipisicing elit. A tenetur fuga odit reiciendis debitis. Consectetur, laudantium? Ut rerum maiores quam itaque quo minus, est repellendus atque natus reiciendis, voluptatem quos.";
    div.appendChild(title);
    div.appendChild(img);
    div.appendChild(description);
    article.appendChild(div);
  }
}
displayArticle1();

function displayArticle2() {
  var images = [
    "imagesFolder/image_1.png",
    "imagesFolder/image_2.png",
    "imagesFolder/image_3.png",
    "imagesFolder/image_4.png",
    "imagesFolder/image_5.png",
  ];
  var article = document.getElementById("articleTwo");
  for (var i = 0; i < images.length; i++) {
    var img = document.createElement("img");
    img.src = images[i];
    img.alt = "Placeholder Image " + (i + 1);
    article.appendChild(img);
  }
}
displayArticle2();

function footerDate() {
  var currentYear = new Date().getFullYear();
  document.getElementById("currentYear").textContent = currentYear;
}
footerDate();
