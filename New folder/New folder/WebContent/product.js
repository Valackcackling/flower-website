// data for productList
const roses = [
  {
	id:"r1",
    name: "Mr.Lincoln",
    image: "red-rose.jpg",
    price: 150,
    description: "Roses are erect, they come in many shades",
    discount: "20%",
  },
  {
		id:"r2",
    name: "Black rose",
    image: "rose.jpg",
    price: 200,
    description: "Black roses are symbols features in fiction with many different meanings and titles",
    discount: "10%",
  },
  {
		id:"r3",
    name: "Yellow rose",
    image: "yellow.jpg",
    price: 300,
    description: "Roses are erect, they come in many shades",
    discount: "5%",
  },
  {
		id:"r4",
    name: "Red rose",
    image: "r.jpg",
    price: 200,
    description: "Roses are erect, they come in many shades",
    discount: "10%",
  },
  {
		id:"r5",
    name: "White rose",
    image: "white.jpg",
    price: 400,
    description: "Black roses are symbols features in fiction with many different meanings and titles",
    discount: "20%",
  },
  {

		id:"r5",
    name: "Rose",
    image: "ro.jpg",
    price: 200,
    description: "Black roses are symbols features in fiction with many different meanings and titles",
    discount: "5%",
  },
  
];

const tulips = [
  {

		id:"t1",
    name: "Tulip",
    image: "tulip.jpg",
    price: 100,
    discription:"Tulip Blossoms",
    discount:"10%",
  },
  {
		id:"t2",
    name: "Tulip plant",
    image: "tul.jpeg",
    price: 500,
    description: "Tulips grow as a single stem and flower for each plant",
    discount: "20%",
  },
  {

		id:"t3",
    name: "Tulip",
    image: "tuli.jpg",
    price: 300,
    description: "Tulips grow as a single stem and flower for each plant",
    discount: "15%",
  },
  {

		id:"t4",
    name: "Tulip",
    image: "t.jpg",
    price: 250,
    description: "Tulips grow as a single stem and flower for each plant",
    discount: "10%",
  },
  {

		id:"t5",
    name: "Tulip",
    image: "R.png",
    price: 100,
    description: "Tulips grow as a single stem and flower for each plant",
    discount: "150%",
  },
  {
		id:"t6",
    name: "Tulip",
    image: "pic.jpeg",
    price: 150,
    description: "Tulips grow as a single stem and flower for each plant",
    discount: "20%",
  },
];
const carnation = [
{
	id:"c1",
  name: "Carnation",
  image: "Carnation.jpg",
  price: 250,
  description:"Commonly knows as the carnation or clove pink",
  discount:"10%",
},
  {
	id:"c2",
    name: "Carnation",
    image: "carnation.jpg",
    price: 150,
    description: "Commonly knows as the carnation or clove pink",
    discount: "20%",
  },
  {
		id:"c3",
    name: "Carnation",
    image: "carnation-flower.jpg",
    price: 150,
    description: "Commonly knows as the carnation or clove pink",
    discount: "20%",
  },
{
		id:"c4",
  name: "Carnation",
  image: "carna.jpeg",
  price: 200,
  description: "Commonly knows as the carnation or clove pink",
  discount: "20%",
},
{
	id:"c5",
  name: "Carnation",
  image: "carnation-flowers.jpg",
  price: 150,
  description: "Commonly knows as the carnation or clove pink",
  discount: "15%",
},
{
	id:"c6",
  name: "Carnation",
  image: "carnation-flower.jpg",
  price: 100,
  description: "Commonly knows as the carnation or clove pink",
  discount: "9%",
},
{
	id:"c7",
  name: "Carnation",
  image: "carnu.jpeg",
  price: 190,
  description: "Commonly knows as the carnation or clove pink",
  discount: "20%",
},
];

const flowers = ["roses", roses, "tulips", tulips, "carnation", carnation];

//writing logic
var mainDiv = document.getElementById("product-container");

for (var i = 0; i < flowers.length; i += 2) {
  var flowerHeader = document.createElement("div");
  flowerHeader.classList.add("flower-header");
  flowerHeader.innerHTML = ` <h2 style="border-bottom: 1px outset blue">${flowers[i]}</h2>`;
  mainDiv.appendChild(flowerHeader);

  var div = document.createElement("div");
  div.classList.add("flowerType");

  //div.innerHTML = `<h2>${flowers[i]}</h2>`;

  for (var j = 0; j < flowers[i + 1].length; j++) {
    var flower_container = document.createElement('form');
    flower_container.classList.add("flower-container");
    flower_container.action='productDetail';
    flower_container.method='post';

    flower_container.innerHTML = `
                       <img src="img/${flowers[i + 1][j].image}"/>
                       <input name="id" style="display:none" value="${flowers[i + 1][j].id}:${flowers[i + 1][j].description}:${flowers[i + 1][j].image}:${flowers[i + 1][j].price}:${flowers[i + 1][j].name}:${flowers[i + 1][j].discount}">
                       <p name="name">${flowers[i + 1][j].name}</p>
                       <p name="price">${flowers[i + 1][j].price}</p>
                       <button type='submit' >Check Out</button>`;
    div.appendChild(flower_container);
  }

  mainDiv.appendChild(div);
}
//for cart 
$('#mycartbtn').click(function(e){
	e.preventDefault();
	
	$.ajax({
		url:'profileServlet',
		type:"get",
		data:{id:"de42a4"},
		cache:false,
		success:function(data){
			if(data!="null"){
				$('#mycartform').submit();
			}
			else{
				alert("please login First");
			}
		}
	})
})


//for hero Section Slide
var myIndex = 0;
carousel();
function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  myIndex++;
  if (myIndex > x.length) {
    myIndex = 1;
  }
  x[myIndex - 1].style.display = "block";
  setTimeout(carousel, 3000);
}