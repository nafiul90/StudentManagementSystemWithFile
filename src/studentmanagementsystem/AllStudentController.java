/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author nafiul
 */
public class AllStudentController implements Initializable {

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> nameColl;
    @FXML
    private TableColumn<Student, String> emailColl;
    @FXML
    private TableColumn<Student, String> departmentColl;
    @FXML
    private TableColumn<Student, String> addressColl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AddStudentLayoutController.stdList.clear();
        try {
            File file=new File("data.txt");
            if(!file.exists())file.createNewFile();
            
            Scanner sc=new Scanner(file);
            while(sc.hasNext()){
                String str=sc.nextLine();
                String parts[]=str.split("#");
                
                Student std=new Student(parts[0],parts[1],parts[2],parts[3]);
                AddStudentLayoutController.stdList.add(std);
            }
            
            nameColl.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
            emailColl.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
            departmentColl.setCellValueFactory(new PropertyValueFactory<Student,String>("department"));
            addressColl.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
            
            studentTable.setItems(AddStudentLayoutController.stdList);
        } catch (IOException ex) {
            Logger.getLogger(AllStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
