package MVC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController extends Controller {

    public ScreensController myController;
    private Model model = new Model();

    @FXML
    private TextField signUP_first_name;
    @FXML
    private TextField signUP_last_name;
    @FXML
    private TextField signUP_user_name;
    @FXML
    private TextField signUP_password;
    @FXML
    private TextField signUP_city;
    @FXML
    private TextField signUP_DD;
    @FXML
    private TextField signUP_MM;
    @FXML
    private TextField signUP_YYYY;

    @FXML
    /* function listens for retrieving username details */
    private void registerUser(ActionEvent event) {
        String fName = signUP_first_name.getText();
        String lName = signUP_last_name.getText();
        String userName = signUP_user_name.getText();
        String password = signUP_password.getText();
        String city = signUP_city.getText();
        String DD = signUP_DD.getText();
        String MM = signUP_MM.getText();
        String YYYY = signUP_YYYY.getText();
        String bDate = YYYY + "-" + MM + "-" + DD;
        model.registerUserToDB(userName, password, bDate, fName, lName, city);
        Main.signedUserName = userName;
        try {
            super.showMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(MVC.Main.screenLoginID);
    }


}
