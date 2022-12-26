package ManageStore.View;

import ManageStore.Controller.MsController;
import ManageStore.Model.Category;
import ManageStore.Model.ManageStore;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.util.ArrayList;

public class ManageForm extends JFrame {
    public ManageStore model;
    public JPanel contentPane;
    public JTable table;
    public JTextField nameFilText;
    public JTextField idFilText;
    public JTextField originFilText;
    public JTextField statusFilText;
    public JTextField txtName;
    public JTextField txtId;
    public JTextField txtOrigin;
    public JTextField txtPrice;
    public JTextField txtQuantity;
    public JTextField txtStatus;
    public JComboBox<Object> catFilComboBox;
    public JComboBox<Object> catComboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageForm frame = new ManageForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ManageForm() {
        this.model = new ManageStore();
        setTitle("Manage Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1247, 870);

        Action action = new MsController(this);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        fileMenu.addActionListener(action);
        menuBar.add(fileMenu);

        JMenuItem openMenu = new JMenuItem("Open");
        openMenu.addActionListener(action);
        fileMenu.add(openMenu);

        JMenuItem saveMenu = new JMenuItem("Save File");
        saveMenu.addActionListener(action);
        fileMenu.add(saveMenu);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.setBounds(1, 25, 450, 0);
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Name", "ID", "Category", "Origin", "Price", "Quantity", "Status"
                }
        ));
        contentPane.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(35, 50, 900, 518);
        contentPane.add(scrollPane);

        nameFilText = new JTextField();
        nameFilText.setFont(new Font("Arial", Font.ITALIC, 14));
        nameFilText.setText("Name");
        nameFilText.setBounds(1030, 56, 178, 40);
        contentPane.add(nameFilText);
        nameFilText.setColumns(10);

        JButton btnFilter = new JButton("Filter");
        btnFilter.addActionListener(action);
        btnFilter.setFont(new Font("Arial", Font.BOLD, 14));
        btnFilter.setBounds(953, 10, 115, 33);
        contentPane.add(btnFilter);

        JLabel nameFilLabel = new JLabel("Name");
        nameFilLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameFilLabel.setBounds(953, 67, 67, 17);
        contentPane.add(nameFilLabel);

//        JLabel idFilLable = new JLabel("ID");
//        idFilLable.setFont(new Font("Arial", Font.BOLD, 14));
//        idFilLable.setBounds(953, 128, 67, 17);
//        contentPane.add(idFilLable);
//
//        idFilText = new JTextField();
//        idFilText.setText("ID");
//        idFilText.setFont(new Font("Arial", Font.ITALIC, 14));
//        idFilText.setColumns(10);
//        idFilText.setBounds(1030, 117, 178, 40);
//        contentPane.add(idFilText);
//
//        originFilText = new JTextField();
//        originFilText.setText("Origin");
//        originFilText.setFont(new Font("Arial", Font.ITALIC, 14));
//        originFilText.setColumns(10);
//        originFilText.setBounds(1030, 178, 178, 40);
//        contentPane.add(originFilText);
//
//        statusFilText = new JTextField();
//        statusFilText.setText("Status");
//        statusFilText.setFont(new Font("Arial", Font.ITALIC, 14));
//        statusFilText.setColumns(10);
//        statusFilText.setBounds(1030, 240, 178, 40);
//        contentPane.add(statusFilText);
//
//        JLabel originFilLabel = new JLabel("Origin");
//        originFilLabel.setFont(new Font("Arial", Font.BOLD, 14));
//        originFilLabel.setBounds(953, 189, 67, 17);
//        contentPane.add(originFilLabel);
//
//        JLabel statusFilLabel = new JLabel("Status");
//        statusFilLabel.setFont(new Font("Arial", Font.BOLD, 14));
//        statusFilLabel.setBounds(953, 251, 67, 17);
//        contentPane.add(statusFilLabel);
//
        catFilComboBox = new JComboBox<>();
        ArrayList<Category> listCat = Category.getCatList();
        catFilComboBox.setModel(new DefaultComboBoxModel<>(listCat.toArray()));
        catFilComboBox.setFont(new Font("Arial", Font.ITALIC, 14));
        catFilComboBox.setBounds(1030, 301, 178, 40);
        contentPane.add(catFilComboBox);

        JLabel catFilLabel = new JLabel("Category");
        catFilLabel.setFont(new Font("Arial", Font.BOLD, 14));
        catFilLabel.setBounds(953, 313, 67, 17);
        contentPane.add(catFilLabel);
//
//        JSlider slider = new JSlider();
//        slider.setBounds(1023, 369, 200, 22);
//        contentPane.add(slider);
//
//        JLabel priceFilLabel = new JLabel("Price");
//        priceFilLabel.setFont(new Font("Arial", Font.BOLD, 14));
//        priceFilLabel.setBounds(953, 369, 67, 17);
//        contentPane.add(priceFilLabel);

        JLabel nameFilLabel_1 = new JLabel("Name");
        nameFilLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
        nameFilLabel_1.setBounds(35, 614, 67, 17);
        contentPane.add(nameFilLabel_1);

        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Arial", Font.BOLD, 14));
        lblId.setBounds(35, 670, 67, 17);
        contentPane.add(lblId);

        JLabel lblOrigin = new JLabel("Origin");
        lblOrigin.setFont(new Font("Arial", Font.BOLD, 14));
        lblOrigin.setBounds(35, 721, 67, 17);
        contentPane.add(lblOrigin);

        txtName = new JTextField();
        txtName.setText("Name");
        txtName.setFont(new Font("Arial", Font.ITALIC, 14));
        txtName.setColumns(10);
        txtName.setBounds(101, 602, 258, 45);
        contentPane.add(txtName);

        txtId = new JTextField();
        txtId.setText("ID");
        txtId.setFont(new Font("Arial", Font.ITALIC, 14));
        txtId.setColumns(10);
        txtId.setBounds(101, 657, 258, 40);
        contentPane.add(txtId);

        txtOrigin = new JTextField();
        txtOrigin.setText("Origin");
        txtOrigin.setFont(new Font("Arial", Font.ITALIC, 14));
        txtOrigin.setColumns(10);
        txtOrigin.setBounds(101, 707, 258, 40);
        contentPane.add(txtOrigin);

        txtPrice = new JTextField();
        txtPrice.setText("Price");
        txtPrice.setFont(new Font("Arial", Font.ITALIC, 14));
        txtPrice.setColumns(10);
        txtPrice.setBounds(458, 602, 258, 45);
        contentPane.add(txtPrice);

        JLabel nameFilLabel_1_1 = new JLabel("Price");
        nameFilLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
        nameFilLabel_1_1.setBounds(392, 614, 67, 17);
        contentPane.add(nameFilLabel_1_1);

        txtQuantity = new JTextField();
        txtQuantity.setText("Quantity");
        txtQuantity.setFont(new Font("Arial", Font.ITALIC, 14));
        txtQuantity.setColumns(10);
        txtQuantity.setBounds(458, 657, 258, 40);
        contentPane.add(txtQuantity);

        JLabel nameFilLabel_1_2 = new JLabel("Quantity");
        nameFilLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
        nameFilLabel_1_2.setBounds(392, 670, 67, 17);
        contentPane.add(nameFilLabel_1_2);

        txtStatus = new JTextField();
        txtStatus.setText("Status");
        txtStatus.setFont(new Font("Arial", Font.ITALIC, 14));
        txtStatus.setColumns(10);
        txtStatus.setBounds(458, 707, 258, 40);
        contentPane.add(txtStatus);

        JLabel nameFilLabel_1_3 = new JLabel("Status");
        nameFilLabel_1_3.setFont(new Font("Arial", Font.BOLD, 14));
        nameFilLabel_1_3.setBounds(392, 719, 67, 17);
        contentPane.add(nameFilLabel_1_3);

        JLabel nameFilLabel_1_4 = new JLabel("Category");
        nameFilLabel_1_4.setFont(new Font("Arial", Font.BOLD, 14));
        nameFilLabel_1_4.setBounds(392, 769, 67, 17);
        contentPane.add(nameFilLabel_1_4);

        catComboBox = new JComboBox<>();
        catComboBox.setModel(new DefaultComboBoxModel(listCat.toArray()));
        catComboBox.setFont(new Font("Arial", Font.ITALIC, 14));
        catComboBox.setBounds(458, 757, 258, 40);
        contentPane.add(catComboBox);

        JButton btnAdd = new JButton("ADD");
        btnAdd.addActionListener(action);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
        btnAdd.setBounds(749, 602, 115, 33);
        contentPane.add(btnAdd);

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(action);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
        btnUpdate.setBounds(874, 602, 115, 33);
        contentPane.add(btnUpdate);

        JButton btnRemove = new JButton("REMOVE");
        btnRemove.addActionListener(action);
        btnRemove.setFont(new Font("Arial", Font.BOLD, 14));
        btnRemove.setBounds(749, 654, 115, 33);
        contentPane.add(btnRemove);

        JButton btnSave = new JButton("SAVE");
        btnSave.addActionListener(action);
        btnSave.setFont(new Font("Arial", Font.BOLD, 14));
        btnSave.setBounds(874, 654, 115, 33);
        contentPane.add(btnSave);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(action);
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.setBounds(1093, 10, 115, 33);
        contentPane.add(btnBack);
    }
}
