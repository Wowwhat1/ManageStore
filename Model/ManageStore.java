package ManageStore.Model;

import java.util.ArrayList;
import java.util.Objects;

public class ManageStore {
    private ArrayList<Item> itemList;
    private String choices;
    private String fileName;

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ManageStore() {
        this.itemList = new ArrayList<Item>();
        this.choices = "";
        this.fileName="";
    }

    public ManageStore(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public void insert(Item item) {
        this.itemList.add(item);
    }

    public void remove(Item item) {
        this.itemList.remove(item);
    }

    public void update(Item item) {
        this.itemList.remove(item);
        this.itemList.add(item);
    }

    public boolean isExist(Item item) {
        for(Item product: itemList) {
            if(Objects.equals(product.getId(), item.getId()))
                return true;
        }
        return false;
    }
}
