document.onscroll = (event) => {
    if (window.pageYOffset > 0) {
        document.querySelector(".svg-icon").classList.add("blackColor");
        document.querySelector(".btn-hote").classList.add("blackColor");
        document.querySelector(".logo1").classList.add("d-none");
        document.querySelector(".logo2").classList.remove("d-none");
        document.querySelector("header").classList.add("fixed-header");
        document.querySelector(".search-bar").classList.add("d-none");
        document.querySelector(".search-bar-scroll").classList.add("search-bar-scroll-active");

    } else {
        document.querySelector(".svg-icon").classList.remove("blackColor");
        document.querySelector(".btn-hote").classList.remove("blackColor");
        document.querySelector(".logo1").classList.remove("d-none");
        document.querySelector(".logo2").classList.add("d-none");
        document.querySelector("header").classList.remove("fixed-header");
        document.querySelector(".search-bar").classList.remove("d-none");
        document.querySelector(".search-bar-scroll").classList.remove("search-bar-scroll-active");
    }
}