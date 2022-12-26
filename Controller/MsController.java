package ManageStore.Controller;

import ManageStore.Model.Category;
import ManageStore.Model.Item;
import ManageStore.View.ManageForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.ArrayList;

public class MsController implements Action {
    public ManageForm view;

    public MsController(ManageForm view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCmd = e.getActionCommand();
        switch (actionCmd) {
            case "ADD" -> {
                this.view.model.setChoices("ADD");
                int optionPanel = JOptionPane.showConfirmDialog(view, "Are you sure you want to save this product?", "Confirm Save", JOptionPane.YES_NO_CANCEL_OPTION);
                int catId = this.view.catComboBox.getSelectedIndex();
                String name = this.view.txtName.getText();
                Category cat = Category.getCatById(catId);
                String origin = this.view.txtOrigin.getText();
                if (optionPanel == 0) {
                    try {
                        double price = Double.parseDouble(this.view.txtPrice.getText());
                        int quantity = Integer.parseInt(this.view.txtQuantity.getText());
                        String id = this.view.txtId.getText();
                        if (isDuplicate(id)) {
                            JOptionPane.showMessageDialog(this.view, "ID is duplicate, please enter another ID!");
                        } else
//                            if (isDuplicate(name, cat, origin)) {
//                            updatedPriceQuantity(price, quantity);
//                            JOptionPane.showMessageDialog(this.view, "It's already exist an item like this, it will be combine together!");
//                            this.delForm();
//                        } else
                        {
                            this.addItem();
                            this.delForm();
                        }
                    } catch (NumberFormatException ea) {
                        JOptionPane.showMessageDialog(this.view, "Input mismatch exception, make sure that price and quantity are number!");
                    }
                }
            }
            case "UPDATE" -> {
                try {
                    this.showSelectedItem();
                } catch (ArrayIndexOutOfBoundsException ea) {
                    JOptionPane.showMessageDialog(this.view, "Please choose one item in the table to update!");
                }
            }
            case "SAVE" -> {
//                try {
                    int optionPanel = JOptionPane.showConfirmDialog(view, "Are you sure you want to save this product?", "Confirm Save", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (optionPanel == 0) {
                            this.addItem();
                            this.delForm();
                    }
//                } catch (NumberFormatException e2) {
//                    JOptionPane.showMessageDialog(this.view, "Please enter integer number in Price field");
//                }
            }
            case "REMOVE" -> {
                try {
                    this.delItem();
                } catch (ArrayIndexOutOfBoundsException e3) {
                    JOptionPane.showMessageDialog(this.view, "You are not select any item yet, please choose an item!");
                }
            }
            case "Filter" -> this.searchButton();
            case "Back" -> this.clearSearchButton();
            case "More" -> this.showMore();
            case "Open" -> this.openFile();
            case "Save File" -> this.saveFile();
        }
    }

    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public void putValue(String key, Object value) {

    }

    @Override
    public void setEnabled(boolean b) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean accept(Object sender) {
        return Action.super.accept(sender);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }

    public void delForm() {
        this.view.txtName.setText("Name");
        this.view.txtId.setText("ID");
        this.view.txtOrigin.setText("Origin");
        this.view.txtPrice.setText("Price");
        this.view.txtQuantity.setText("Quantity");
        this.view.txtStatus.setText("Status");
        this.view.catComboBox.setSelectedIndex(0);
    }

    public void addItem() {
        double price;
        int quantity;
        String name, id, origin, status;
        Category cat;
        name = this.view.txtName.getText();
        id = this.view.txtId.getText();
        int catId = this.view.catComboBox.getSelectedIndex();
        cat = Category.getCatById(catId);
        origin = this.view.txtOrigin.getText();
        try {
            price = Double.parseDouble(this.view.txtPrice.getText());
            quantity = Integer.parseInt(this.view.txtQuantity.getText());
        status = this.view.txtStatus.getText();
        if (this.containsNumberOrSpecialChar(name)) {
            JOptionPane.showMessageDialog(this.view, "Field name must contains only character!");
        } else if (name == null || name.equals("Name")|| id == null || id.equals("ID")|| cat.getName().equals("") || origin == null || origin.equals("Origin")
                || this.view.txtPrice.getText().equals("Price") || quantity == 0 || this.view.txtQuantity.getText().equals("Quantity")) {
            JOptionPane.showMessageDialog(this.view, "Please fulfill the form!");
        } else {
            Item item = new Item(name, id, cat, origin, price, quantity, status);
            this.addOrUptItem(item);
            this.delForm();
        }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.view, "Please enter correct format of number (double for price field and integer for quantity field)!");
        }
    }

    public void addItemToTable(Item item) {
        DefaultTableModel model_table = (DefaultTableModel) this.view.table.getModel();
        model_table.addRow(new Object[] { item.getName() + "", item.getId() + "", item.getCategory().getName() + "",
                item.getOrigin() + "", item.getPrice() + "", item.getQuantity() + "",
                item.getStatus() + ""});
    }

    public void addOrUptItem(Item item) {
        DefaultTableModel model_table = (DefaultTableModel) this.view.table.getModel();
        if (!this.view.model.isExist(item)) {
            this.view.model.insert(item);
            this.addItemToTable(item);
        } else {
            this.view.model.update(item);
            int numOfRow = model_table.getRowCount();
            for (int i = 0; i < numOfRow; i++) {
                String id = model_table.getValueAt(i, 1) + "";
                if (id.equals(item.getId() + "")) {
                    model_table.setValueAt(item.getName() + "", i, 0);
                    model_table.setValueAt(item.getId() + "", i, 1);
                    model_table.setValueAt(item.getCategory().getName() + "", i, 2);
                    model_table.setValueAt(item.getOrigin() + "", i, 3);
                    model_table.setValueAt(item.getPrice() + "", i, 4);
                    model_table.setValueAt(item.getQuantity() + "", i, 5);
                    model_table.setValueAt(item.getStatus() + "", i, 6);
                }
            }
        }
    }

    public void showSelectedItem() {
        Item item = getSelectedItem();

        this.view.txtName.setText(item.getName() + "");
        this.view.txtId.setText(item.getId() + "");
        this.view.catComboBox.setSelectedItem(item.getCategory());
        this.view.txtOrigin.setText(item.getOrigin() + "");
        this.view.txtPrice.setText(item.getPrice() + "");
        this.view.txtQuantity.setText(item.getQuantity() + "");
        this.view.txtStatus.setText(item.getStatus() + "");
    }

    public Item getSelectedItem() {
        DefaultTableModel model_table = (DefaultTableModel) this.view.table.getModel();
        int i_row = this.view.table.getSelectedRow();

        String name = model_table.getValueAt(i_row, 0) + "";
        String id = model_table.getValueAt(i_row, 1) + "";
        Category category = Category.getCatByName(model_table.getValueAt(i_row, 2) + "");
        String origin = model_table.getValueAt(i_row, 3) + "";
        double price = Double.parseDouble(model_table.getValueAt(i_row, 4) + "");
        int quantity = Integer.parseInt(model_table.getValueAt(i_row, 5) + "");
        String status = model_table.getValueAt(i_row, 6) + "";

        return new Item(name, id, category, origin, price, quantity, status);
    }

    public void delItem() {
        DefaultTableModel model_table = (DefaultTableModel) this.view.table.getModel();
        int i_row = this.view.table.getSelectedRow();
        int choice = JOptionPane.showConfirmDialog(this.view, "Are you sure you want to delete this?");
        if (choice == JOptionPane.YES_OPTION) {
            Item item = getSelectedItem();
            this.view.model.remove(item);
            model_table.removeRow(i_row);
        }
    }

    public void searchButton() {
        int catIndex = this.view.catFilComboBox.getSelectedIndex();
        Category cat = Category.getCatById(catIndex);
        RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter(cat.getName(), 2);
        DefaultTableModel model_table = (DefaultTableModel) this.view.table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model_table);
        sorter.setRowFilter(rf);
        view.table.setRowSorter(sorter);
    }
    public void clearSearchButton() {
        Category cat = Category.getCatById(0);
        RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter(cat.getName(), 2);
        this.view.catFilComboBox.setSelectedIndex(0);
        DefaultTableModel model_table;
        model_table = (DefaultTableModel) view.table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model_table);
        sorter.setRowFilter(rf);
        this.view.table.setRowSorter(sorter);
    }

    public void showMore() {
        JOptionPane.showMessageDialog(this.view, "Manage Store App ver 1.x.x!");
    }

    public void openFile() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(view);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            openFile(file);
            reloadTable();
        }
    }
    public void openFile(File file) {
        ArrayList<Item> ds = new ArrayList<>();
        try {
            this.view.model.setFileName(file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Item item;
            while(ois.readObject() != null) {
                try {
                    item = (Item) ois.readObject();
                    ds.add(item);
                    System.out.println(item);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
            fis.close();
        } catch (StreamCorruptedException e) {
            JOptionPane.showMessageDialog(this.view, "Incorrect file format!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.view, e.getMessage());
        }
        this.view.model.setItemList(ds);
    }
    public void reloadTable() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) view.table.getModel();
            int rowNum = model_table.getRowCount();
            if(rowNum==0)
                break;
            else
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        for (Item item : this.view.model.getItemList()) {
            this.addItemToTable(item);
        }
    }

    public void saveFile(){
        if(this.view.model.getFileName().length()>0) {
            saveFile(this.view.model.getFileName());
        } else {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(this.view);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                saveFile(file.getAbsolutePath());
            }
        }
    }
    public void saveFile(String path) {
        try {
            this.view.model.setFileName(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Item item : this.view.model.getItemList()) {
                oos.writeObject(item);
                System.out.println(item);
            }
            oos.close();
            JOptionPane.showMessageDialog(null, "Save successful", "Save!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean containsNumberOrSpecialChar(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c) || !Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicate(String id) {
        boolean cond = false;
        for (int i = 0; i < this.view.model.getItemList().size(); i++) {
            cond = id.equals(this.view.model.getItemList().get(i).getId());
        }
        return cond;
    }

    public boolean isDuplicate(String name, Category cat, String origin) {
        boolean cond = false;
        for (int i = 0; i < this.view.model.getItemList().size(); i++) {
            if (name.equals(this.view.model.getItemList().get(i).getName()) &&
                    cat.equals(this.view.model.getItemList().get(i).getCategory()) &&
                    origin.equals(this.view.model.getItemList().get(i).getOrigin())) {
                cond = true;
                break;
            }
        }
        return cond;
    }

    public void updatedPriceQuantity(double plusPrice, int quantity) {
        DefaultTableModel model_table = (DefaultTableModel) this.view.table.getModel();
        for (int i = 0; i < this.view.model.getItemList().size(); i++) {
            if (isDuplicate(this.view.model.getItemList().get(i).getName(),
                    this.view.model.getItemList().get(i).getCategory(),
                    this.view.model.getItemList().get(i).getOrigin())) {
                double newPrice = this.view.model.getItemList().get(i).getPrice() + plusPrice;
                int newQuantity = this.view.model.getItemList().get(i).getQuantity() + quantity;
                model_table.setValueAt(newPrice + "", i, 4);
                model_table.setValueAt(newQuantity + "", i, 5);
                this.view.model.getItemList().get(i).setPrice(newPrice);
                this.view.model.getItemList().get(i).setQuantity(newQuantity);
            }
        }
    }
}
