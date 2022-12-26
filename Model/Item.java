package ManageStore.Model;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
    private String name;
    private String id;
    private Category category;
    private String origin;
    private double price;
    private int quantity;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Item(String name, String id, Category category, String origin, double price, int quantity, String status) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", category=" + category +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item itemModel = (Item) o;
        return Double.compare(itemModel.price, price) == 0 && quantity == itemModel.quantity && Objects.equals(name, itemModel.name) && Objects.equals(id, itemModel.id) && Objects.equals(category, itemModel.category) && Objects.equals(origin, itemModel.origin) && Objects.equals(status, itemModel.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, category, origin, price, quantity, status);
    }
}
