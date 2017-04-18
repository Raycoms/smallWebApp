$(document).ready(function()
{
    $(function()
    {
         $("button.del").on("click", function()
                {
                    console.log($(this).attrs('data-idx'));
                    $.delete("shoppingcart/items{"+ $(this).data('id') +"}", "", function(){location.reload();});
                });

    });

});
