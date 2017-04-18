package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Shopping cart, containing items and their summed value.
 */
@Component
@Scope("session")
public class ShoppingCart
{
    /**
     * All the commerce items on the current shopping cart.
     */
    private CommerceItem[] items;

    /**
     * Order total value, calculated summing the amount of all commerce items.
     */
    private BigDecimal amount;

    public ShoppingCart()
    {
        items = new CommerceItem[0];
    }

    public CommerceItem[] getItems()
    {
        return items;
    }

    public void setItems(final CommerceItem[] items)
    {
        this.items = items;
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
     * Add item to shopping cart.
     * Increase quantity if exists already.
     *
     * @param newItem the item to add
     */
    public void addItem(final CommerceItem newItem)
    {
        final List<CommerceItem> list = new ArrayList<>();
        boolean itemFound = false;
        for (final CommerceItem item : items)
        {
            if (item.getProductId().equals(newItem.getProductId()))
            {
                itemFound = true;
                item.increaseAmountBy(1);
            }
            list.add(item);
        }

        if (!itemFound)
        {
            list.add(newItem);
        }

        items = list.toArray(new CommerceItem[list.size()]);
    }

    /**
     * Iterate through all items and remove the item with the ingoing id.
     *
     * @param id item to remove.
     */
    public void removeItem(final String id)
    {
        final List<CommerceItem> list = new ArrayList<>();
        for (final CommerceItem item : items)
        {
            if (!item.getId().equals(id))
            {
                list.add(item);
            }
        }
        items = list.toArray(new CommerceItem[list.size()]);
    }

    /**
     * Creates unique itemId of commerceItem.
     *
     * @return the id.
     */
    public String getNextItemId()
    {
        return Integer.toString(items.length);
    }
}
