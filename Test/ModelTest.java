package ManageStore.Test;

import ManageStore.Model.Category;
import ManageStore.Model.Item;
import ManageStore.Model.ManageStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    ManageStore model = new ManageStore();
    @BeforeEach
    void init() {
        model.setFileName("data4.txt");
        Category category = Category.getCatById(2);
        Item studentExpected1 = new Item("Meat", "1", category, "Viet Nam", 200, 4, "Available");
        Item studentExpected2 = new Item("Apple", "2", category, "US", 200, 4, "Available");
        Item studentExpected3 = new Item("Banana", "3", category, "Korea", 200, 4, "Available");
        model.insert(studentExpected1);
        model.insert(studentExpected2);
        model.insert(studentExpected3);
    }

    @Test
    void getItemList() {
        ArrayList<Item> itemListExpected = new ArrayList<Item>();
        Category category = Category.getCatById(2);
        Item studentExpected1 = new Item("Meat", "1", category, "Viet Nam", 200, 4, "Available");
        Item studentExpected2 = new Item("Apple", "2", category, "US", 200, 4, "Available");
        Item studentExpected3 = new Item("Banana", "3", category, "Korea", 200, 4, "Available");
        itemListExpected.add(studentExpected1);
        itemListExpected.add(studentExpected2);
        itemListExpected.add(studentExpected3);
        ArrayList<Item> itemListActual = model.getItemList();
        for (int i = 0; i < itemListActual.size(); i++) {
            assertEquals(itemListExpected.get(i), itemListActual.get(i));
        }
    }

    @Test
    void addStudent() {
        Category category = Category.getCatById(2);
        Item studentExpected4 = new Item("Pineapple", "4", category, "Viet Nam", 200, 4, "Available");
        model.insert(studentExpected4);
        ArrayList<Item> itemListActual = model.getItemList();
        Item itemActual = itemListActual.get(itemListActual.size() - 1);
        assertEquals(itemActual, studentExpected4);
    }

    @Test
    void setFileName() {
        model.setFileName("FileRename.txt");
        assertEquals("FileRename.txt", model.getFileName());
    }

    @Test
    void getFileName() {
        assertEquals("data4.txt", model.getFileName());
    }

    @Test
    void deleteStudent() {
        ArrayList<Item> itemListActual = model.getItemList();
        assertEquals(3, itemListActual.size());
        model.remove(model.getItemList().get(2));
        itemListActual = model.getItemList();
        assertEquals(2, itemListActual.size());
    }

    @Test
    void updateStudent() {
        Category category = Category.getCatById(2);
        Item studentExpected4 = new Item("Pineapple", "4", category, "Viet Nam", 200, 4, "Available");
        model.update(studentExpected4);
        ArrayList<Item> itemList = model.getItemList();
        assertEquals(itemList.get(3), studentExpected4);
    }
}

