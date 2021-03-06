package View.User;

import Controller.Controller;
import View.Main;
import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
public class UpdateController extends Controller {
    private Model model = new Model();
    @FXML
    private TextField update_fName;
    @FXML
    private TextField update_lname;
    @FXML
    private TextField update_password;
    @FXML
    private TextField update_city;
    @FXML
    private TextField update_DD;
    @FXML
    private TextField update_MM;
    @FXML
    private TextField update_YYYY;

    @FXML
    /* function listens for retrieving username details to be updated */
    public void updateUserData(ActionEvent event) {
        String fName = update_fName.getText();
        String lName = update_lname.getText();
        String password = update_password.getText();
        String city = update_city.getText();
        String DD = update_DD.getText();
        String MM = update_MM.getText();
        String YYYY = update_YYYY.getText();
        String bDate = YYYY + "-" + MM + "-" + DD;
        model.updateUserData(Main.signedUserName, password, bDate, fName, lName, city);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User Data");
        alert.setHeaderText(null);
        alert.setContentText("User Updated Successfully");
        alert.showAndWait();
        try {
            super.showMainMenu();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}