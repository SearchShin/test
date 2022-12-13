Fancybox.bind('[data-fancybox="gallery"]', {
    caption: function (fancybox, carousel, slide) {
      return (
        `${slide.index + 1} / ${carousel.slides.length} <br />` + slide.caption
      );
    },
  });



function onDisplay() { 

$('.attr_4').show();

    } 

​

function offDisplay() { 

$('.attr_4').hide(); 

} 