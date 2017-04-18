$(document).ready(function()
{
    $(function()
    {
        $("button.sword").on("click", function()
        {
            $.post("shoppingcart/items",
            {
                product_id: $(this).data('id'),
                quantity : "1"
            });
            location.reload();
        });

    });

});
