$(document).ready(function() {
  $(".container").mousemove(function(event) {
    var xPos = event.pageX;
    var yPos = event.pageY;
    
    var containerWidth = $(this).width();
    var containerHeight = $(this).height();
    var imageWidth = $(".image").width();
    var imageHeight = $(".image").height();
    
    var maxX = containerWidth - imageWidth;
    var maxY = containerHeight - imageHeight;
    
    var moveX = (xPos / containerWidth) * maxX;
    var moveY = (yPos / containerHeight) * maxY;
    
    $(".image").css("transform", "translate(" + moveX + "px, " + moveY + "px)");
  });
});