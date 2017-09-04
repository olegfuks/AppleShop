var cart=[];
var lastseen=[];
$('document').ready(function () {
    checkKorsuna();
    showKorsuna();
    checkLastSeen();
    showLastSeen();
    $('.content-left').hide();
});


$('#searchproduct').click(function () {
    checkLastSeen();
    showLastSeen();
    $('.content-left').show();
    $('.changeview').show();
    $('.threeproduct').css("background-color", "grey");$('.fourproduct').css("background-color", "snow");
    $.ajax({
        url : '/searchproduct',
        type : 'GET',
        success : function (response) {
            $('.content-right').empty();
            for(var i=0;i<response.length;i++){
                if(response[i].productname.includes($('#searchinput').val())) {
                    $('<div/>',{class:"productcontent"+response[i].id}).appendTo('.content-right').addClass('productcontent')
                        .append($('<img/>',{class:"singleproductshowimg",src:response[i].productpicture,data_art:JSON.stringify(response[i])}),
                        $('<h3/>',{class:"singleproductshow",text:response[i].productname,data_art:JSON.stringify(response[i])}),
                        $('<h4/>',{text:response[i].price+' $'}),
                            $('<p/>',{class:"addkorsuna",text:"В корзину",data_art:JSON.stringify(response[i])}));
                }
            }
            $('.singleproductshow , .singleproductshowimg').on('click',singleProduct);
            $('.addkorsuna').on('click',addToKorsuna);
        },
        error : function () {
            alert('Error');
        }
    })
});


function addToKorsuna() {
    var articul=JSON.parse($(this).attr('data_art'));
    cart.push(articul);
    localStorage.setItem('cart',JSON.stringify(cart));
    showKorsuna();
}

function checkKorsuna() {
    if(localStorage.getItem('cart')!=null){
        cart=JSON.parse(localStorage.getItem('cart'));
    }
}

function showKorsuna() {
    if(cart.length==0){
        $('.showingcart').append($('<h2/>',{text:"Корзина пуста"}))
    }
    for(var w in cart){
        $('<div/>',{class:"showingcartproduct"}).append($('<img/>',{src:cart[w].productpicture}),
            $('<h3/>',{text:cart[w].productname}),$('<h4/>',{text:cart[w].price+' $'}),
        $('<h2/>',{class:'buyfromcart',data_url:"/show-cart-"+JSON.stringify(cart[w].id),text:"Купити",data_cart:JSON.stringify(cart[w])}),
        $('<h2/>',{class:'deletefromcart',text:"Видалити",data_id:JSON.stringify(cart[w])}))
            .appendTo('.showingcart');
    }
    $('.deletefromcart').on('click',deleteFromKorsuna);
    $('.buyfromcart').on('click',buyFromCart);
    $('#cartt').empty();
    $('#cartt').append('Корзина ('+cart.length+')');
}
function buyFromCart() {
    var deletee=JSON.parse($(this).attr('data_cart'));

    $.ajax({
        url :$(this).attr('data_url'),
        type :'GET',
        success : function () {
            alert('Check was sent on your e-mail!');
            cart = cart.filter(function(el) {
                return el.productname !== deletee.productname;
            });
            localStorage.setItem('cart',JSON.stringify(cart));
            $('.showingcart').empty();
            checkKorsuna();
            showKorsuna();
        },
        error : function () {
            alert('Fail! Sign in or check e-mail!');
        }
    })
}

function deleteFromKorsuna() {
    var deletedindex=JSON.parse($(this).attr('data_id'));
    cart = cart.filter(function(el) {
        return el.productname !== deletedindex.productname;
    });
    localStorage.setItem('cart',JSON.stringify(cart));
    $('.showingcart').empty();
    checkKorsuna();
    showKorsuna();
}

$('.categorycontent img,h3, .topnavigation img,p').click(function () {
    checkLastSeen();
    showLastSeen();
    $('.content-left').show();
    $('.changeview').show();
    $('.threeproduct').css("background-color", "grey");$('.fourproduct').css("background-color", "snow");
    $.ajax({
        url : $(this).attr('class'),
        type : 'GET',
        success : function (result) {
            $('.content-right').empty();
            for(var j=0;j<result.length;j++){
            $('<div/>',{class:"productcontent"+result[j].id}).appendTo('.content-right').addClass('productcontent')
                .append($('<img/>',{class:"singleproductshowimg",data_art:JSON.stringify(result[j]),src:result[j].productpicture}),
                   $('<h3/>',{class:"singleproductshow",data_art:JSON.stringify(result[j]),text:result[j].productname}),
                    $('<h4/>',{text:result[j].price+' $'}),
                    $('<p/>',{class:"addkorsuna",text:"В корзину",data_art:JSON.stringify(result[j])}));
            }
            $('.addkorsuna').on('click',addToKorsuna);
            $('.singleproductshow , .singleproductshowimg').on('click',singleProduct);
        },
        error : function () {
            alert('Error');
        }
    })
});


function singleProduct() {
    $('.changeview').hide();
    var www=JSON.parse($(this).attr('data_art'));
    $('.content-right').empty();
    $('.content-right').append($('<h2/>',{class:"singleproducth2",text:www.productname}),$('<img/>',{src:www.productpicture,class:"singleimg"}),
        $('<div/>',{class:"singleproductdiv"}).append($('<a/>',{class:"addkorsuna",text:"В корзину",data_art:JSON.stringify(www)}),
        $('<h3/>',{text:www.price+" $"}),$('<p/>',{text:www.productdescription})));
    $('.addkorsuna').on('click',addToKorsuna);
    lastseen.push(www);
    localStorage.setItem('lastseen',JSON.stringify(lastseen));
}

function checkLastSeen() {
    if(localStorage.getItem('lastseen')!=null){
        lastseen=JSON.parse(localStorage.getItem('lastseen'));
    }
}
function showLastSeen() {
    if(lastseen.length!=0){
        $('.lastseen').empty().append($('<h3/>',{text:"Нещодавно оглянули :"}),
            $('<img/>',{class:"singleproductshowimglastseen",data_art:JSON.stringify(lastseen[lastseen.length-1]),src:lastseen[lastseen.length-1].productpicture}),
        $('<h4/>',{class:"singleproductshowlastseen",data_art:JSON.stringify(lastseen[lastseen.length-1]),text:lastseen[lastseen.length-1].productname}),
        $('<h5/>',{text:lastseen[lastseen.length-1].price+" $"}));
    }
    $('.singleproductshowlastseen , .singleproductshowimglastseen').on('click',singleProduct);
}

$('.threeproduct').click(function () {
    $('.productcontent').width('30%').height('400px');
    $('.singleproductshowimg').width('92%').height('70%');
    $('.threeproduct').css("background-color", "grey");
    $('.fourproduct').css("background-color", "snow");

});
$('.fourproduct').click(function () {
    $('.productcontent').width('22%').height('350px');
    $('.singleproductshowimg').width('90%').height('60%');
    $('.fourproduct').css("background-color", "grey");
    $('.threeproduct').css("background-color", "snow");
});
