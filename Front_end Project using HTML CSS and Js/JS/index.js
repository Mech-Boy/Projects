
const scroll = new LocomotiveScroll({
    el: document.querySelector('#main'),
    smooth: true
});

var elementc=document.querySelector("#elem-contain");
var fixed=document.querySelector("#fixed-image");

elementc.addEventListener("mouseenter",function(){
fixed.style.display="block"; 

        });
 elementc.addEventListener("mouseleave",function(){
            fixed.style.display="none"; 
            
        });

var elems=document.querySelectorAll(".elem");
elems.forEach(function(elem){
    elem.addEventListener("mouseenter",function(){
       var image=elem.getAttribute("data-image");
       fixed.style.backgroundImage=`url(${image})`;
            });
});

var swiper = new Swiper(".mySwiper", {
    slidesPerView: "auto",
    centeredSlides: true,
    spaceBetween: 40,
    initialSlide: 2, 
  });


var menu=document.querySelector("#menuu");
var full=document.querySelector("#blank-full-scr");
var slide=0;
var opa=document.querySelector("#opacity");
menu.addEventListener("click",function(){
 full.style.top=0;
 if(slide==0){
    full.style.top=0;
    slide=1;
    opa.style.opacity=0;
 }else{
   full.style.top="-100%";
    slide=0;
    opa.style.opacity=1;
 }
});