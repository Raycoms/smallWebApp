package Controller;

import domain.CommerceItem;
import domain.Product;
import domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import util.Log;

import java.math.BigDecimal;

@Controller
@RestController
@ComponentScan("domain")
@Scope("session")
public class RequestController
{
    private static final Product[] products = new Product[]
    {
        new Product("0", "Blue Lightsaber", "images/blueLightSaber.png", new BigDecimal(100)),
        new Product("1", "Magenta Lightsaber", "images/magentaLightSaber.png", new BigDecimal(200)),
        new Product("2", "Red Lightsaber", "images/redLightSaber.png", new BigDecimal(500)),
        new Product("3", "Lightsaber-kit", "images/LightSabers.png", new BigDecimal(5000))
    };

    @Autowired
    private ShoppingCart cart = new ShoppingCart();

    @RequestMapping("/")
    public String redirect()
    {
        return "/index.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/shoppingcart")
    public ShoppingCart getShoppingCart()
    {
        if(cart == null)
        {
            cart = new ShoppingCart();
        }
        return cart;
    }

    @RequestMapping(method = RequestMethod.GET, value ="/products")
    public Product[] getProducts()
    {
        return products;
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/shoppingcart/items/{id}")
    public void deleteItem(@PathVariable String id)
    {
        if (cart == null)
        {
            return;
        }
        Log.getLogger().info("Removing item: " + id);
        cart.removeItem(id);
    }

    @RequestMapping(method = RequestMethod.POST, value ="/shoppingcart/items")
    public CommerceItem commerceItem(@RequestParam(value = "product_id", defaultValue = "1") final String id, @RequestParam(value = "quantity", defaultValue = "1") final String quantity)
    {
        Log.getLogger().info("Post: " + id);
        if(cart == null)
        {
            cart = new ShoppingCart();
        }

        final int qty = Integer.parseInt(quantity);
        final CommerceItem item = new CommerceItem(cart.getNextItemId(), id);
        item.setQuantity(qty);
        item.setAmount(products[Integer.parseInt(id)].getPrice().multiply(new BigDecimal(qty)));
        cart.addItem(item);

        Log.getLogger().info(cart.getItems().length);

        return item;
    }
}
