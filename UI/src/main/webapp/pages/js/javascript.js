$(document).ready(function(){
    $('#added').click(function(){
        $('.alert').show();
        window.setTimeout(function() {
            $("#alert_message").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 3000);
    })
});

$('.close').click(function() {

    $('.alert').hide();

})