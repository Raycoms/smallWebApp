package domain;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * A certain product including a unique id, name, image and its price.
 */
public class Product
{
    /**
     * A unique identifier for the product.
     */
    @NotNull
    private final String id;

    /**
     * String Display name of product.
     */
    @NotNull
    private final String name;

    /**
     * String Image URL representing the product.
     */
    @NotNull
    private final String image;

    /**
     * The price of the product.
     */
    @NotNull
    private BigDecimal price;

    /**
     * Standard constructor for empty product.
     */
    public Product()
    {
        this.id = "";
        this.name = "";
        this.image = "";
    }

    /**
     * Constructor to instantiate product with:
     * @param id unique id.
     * @param name the name.
     * @param image image link.
     */
    public Product(final String id, final String name, final String image)
    {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    /**
     * Constructor to instantiate product with:
     * @param id unique id.
     * @param name the name.
     * @param image image link.
     */
    public Product(final String id, final String name, final String image, final BigDecimal price)
    {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getImage()
    {
        return image;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(final BigDecimal price)
    {
        this.price = price;
    }
}
