package ManageStore.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Category implements Serializable {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setDescription(int id) {
        this.id = id;
    }

    public Category() {};

    public Category(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static ArrayList<Category> getCatList() {
        String[] catArr = {"", "Food", "Clothing", "Shoes", "Furniture and deco", "Office equipment", "Pet care"};
        ArrayList<Category> catList = new ArrayList<Category>();
        for (int i = 0; i < catArr.length; i++) {
            Category cat = new Category(catArr[i], i);
            catList.add(cat);
        }
        return catList;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return Objects.equals(name, that.name) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public static Category getCatById(int catNum) {
        return Category.getCatList().get(catNum);
    }

    public static Category getCatByName(String name) {
        ArrayList<Category> catList = Category.getCatList();
        for (Category cat : catList) {
            if(cat.name.equals(name))
                return cat;
        }
        return null;
    }
}
