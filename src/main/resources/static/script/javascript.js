$(document).ready(function()
{
    $(function()
    {
        $("button.sword").on("click", function()
        {
            console.log($(this).data('id'));
            $.post("shoppingcart/items",
            {
                product_id: $(this).data('id'),
                quantity : "1"
            });
        });

    });

});
