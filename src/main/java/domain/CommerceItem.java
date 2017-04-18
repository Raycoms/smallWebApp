package domain;

import java.math.BigDecimal;

/**
 * Commercial representation of the product with unique id, product id,
 * quantity and the total price (quantity * price).
 */
public class CommerceItem
{
    /**
     *  The commerce item id, unique per commerce item, used to identify the
     *  commerce item inside the shopping cart.
     */
    private final String id;

    /**
     * The product id inside this commerce item.
     */
    private final String productId;

    /**
     * The quantity added to the shopping cart.
     */
    private int quantity;

    /**
     * Item amount, calculated multiplying quantity by the product price.
     */
    private BigDecimal amount;

    /**
     * Standard constructor for empty CommerceItem.
     */
    public CommerceItem()
    {
        id = "";
        productId = "";
    }

    /**
     * Constructor used by application to create commerceItem.
     * @param id unique id of the item.
     * @param productId unique id of the product.
     */
    public CommerceItem(final String id, final String productId)
    {
        this.id = id;
        this.productId = productId;
    }

    public String getId()
    {
        return id;
    }

    public String getProductId()
    {
        return productId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(final int quantity)
    {
        this.quantity = quantity;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(final BigDecimal amount)
    {
        this.amount = amount;
    }

    /**
     * Increase amount by value i.
     * Calculate new amount and calculate new quantity.
     * @param i increased by this.
     */
    public void increaseAmountBy(final int i)
    {
        final BigDecimal price = amount.divide(new BigDecimal(quantity));
        amount = price.multiply(new BigDecimal(quantity + i));
        quantity += i;
    }
}
