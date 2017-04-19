$(document).ready(function()
{
    $(function()
    {
         $("button.del").on("click", function()
                {
                    $.ajax(
                    {
                        url: "shoppingcart/items/"+ $(this).data('id'),
                        type: 'DELETE'
                    });
                    location.reload();;
                });

    });

});
