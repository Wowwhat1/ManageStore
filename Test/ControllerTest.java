//package ManageStore.Test;
//
//import ManageStore.Controller.MsController;
//import ManageStore.Model.Category;
//import ManageStore.Model.Item;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ManageStore.View.ManageForm;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ControllerTest {
//    public ManageForm view = new ManageForm();
//    public MsController controller = view.;
//
//
//    @BeforeEach
//    public void init() {
//        Date date = new Date(2003, 1, 26);
//        Course course = CourseList.getCourseById("1618");
//        Student studentExpected = new Student("Minh", "Male","GCD210237",
//                date, course, 10, "Pass");
//        Student studentExpected2 = new Student("Chien", "Male","GCD210237",
//                date, course, 10, "Pass");
//        view.addStudentToTable(studentExpected);
//        view.model.addStudent(studentExpected);
//        view.addStudentToTable(studentExpected2);
//        view.model.addStudent(studentExpected2);
//    }
//    @Test
//    void addButton() {
//        // Check the table have the Student information or not
//
//    }
//    @Test
//    void getStudentFromTableTest() {
//        view.table.setRowSelectionInterval(0,0);
//        Student studentActual = controller.getStudentFromTable();
//        Date date = new Date(2003, 1, 26);
//        Course course = studentActual.getCourse();
//        Student studentExpected = new Student("Chien", "Male","GCD210237",
//                date, course, 10, "Pass");
//        // Check if the student is Chien
//        assertTrue(studentExpected.equals(studentActual));
//    }
//
//    @Test
//    void updateButton() {
//        // Change name "Minh" to "Chien"
//        view.table.setRowSelectionInterval(0,0);
//        view.formInputView.setCommand("Update");
//        Student student = controller.getStudentFromTable();
//        view.formInputView.setFormFromTable(student);
//        view.formInputView.textField_name.setText("Chien");
//        // get student from form
//        view.formInputView.student();
//        Student studentUpdate = view.formInputView.student;
//        assertEquals("Chien", studentUpdate.getName());
//    }
//
//    @Test
//    void deleteButton() {
//        view.table.setRowSelectionInterval(0,0);
//        controller.deleteButton();
//        // Check the rows is 1 or not
//        assertEquals(1, view.table.getRowCount());
//    }
//
//    @Test
//    void searchButton() {
//        // Check if Chien information has in table
//        view.textField_search.setText("Chien");
//        controller.searchButton();
//        int rows = view.table.getRowCount();
//        assertEquals(1,rows);
//    }
//
//    @Test
//    void clearSearchButton() {
//        controller.clearSearchButton();
//        int rows = view.table.getRowCount();
//        assertEquals(2,rows);
//    }
//
//    @Test
//    void menupen() {
//    }
//
//    @Test
//    void menuSave() {
//    }
//}