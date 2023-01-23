const botaoTrailer = document.querySelector(".botao-trailer");
const botaoFecharModal = document.querySelector(".fechar-modal");
const video = document.getElementById("video");
const modal = document.querySelector(".modal");

function alternarModal() {
    modal.classList.toggle("aberto");
}

botaoTrailer.addEventListener("click", () =>{
    alternarModal();
    video.setAttribute("src", "https://www.youtube.com/embed/Cb4WV4aXBpk");
} );

botaoFecharModal.addEventListener("click", () =>{
    alternarModal();
    video.setAttribute("src", "");
});


 

 


