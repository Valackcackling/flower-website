const mainSection = document.getElementById("mainSection");

var flower = document.getElementById("flowerID").textContent.split(':');
console.log(flower);
const id=flower[0];
const description = flower[1]
const image = flower[2];
const price = flower[3];
const name = flower[4];
const discount = flower[5].slice(0,flower[5].length-1);

var isInCart = (document.getElementById("flowerpresent").textContent=='true'?true:false);
console.log("flower:: "+id+" ::Is In Cart::"+isInCart);

mainSection.innerHTML = `<table border="0" width="100%">
        <tr>
            <td width="30%"><img src="img/${image}" width="100%"></td>
            <td><b><font size="5">${description}</font></b>
                <br>
                <br>
                <font color="green">Special Price</font>
                <br>
                <br>
               <font size="5"><b>Rs${price}/-</b></font> <s style="color: red;text-decoration-style: wavy;text-decoration-thickness: 15%"><font color="grey">Rs ${Math.ceil(price*(100/(100-discount*1)))}/-</font></s> <font color="green">${discount}% off</font>
               <br>
               <br>
               <ul>
              <li><font size="4">Special Price Get extra 16% off (Price inclusive of discount)T&C</li>
               <li>Bank Offer 10% Instant Discount with Axis bank Credit and Debit Cards T&C</li>
               <li>Bank Offer 10% Instant Discount on Mastercard on Fashion for First 3 Prepaid Payment T&C</li>
              <li>Bank Offer 10% Instant Discount on ICICI Bank Credit Card T&C</font></li>
              </ul>
              <br>
              <br>
              <input type="button" value=${(isInCart)?"Remove":"Add"} id="addToCart" style="background-color: orange;color: white; width: 125px; height: 35px;">
            </td>
        </tr>
    </table>`;

$(document).ready(function(){
	$('#addToCart').click(function(e){
		e.preventDefault();
		
		$.ajax({
			url:'cart',
			type:"post",
			data:{id:id,isInCart:isInCart},
			cache:false,
			success:function(data){
				if(!isInCart){
					alert("Item added to cart");
					$('#addToCart')[0].value = "Remove";
					isInCart = true;
				}
				else{
					alert("Item removed from cart");
					$('#addToCart')[0].value = "ADD";
					isInCart = false;
				}
				
				console.log(data);//$('#addToCart')[0].value);
			}
		})
	})
})