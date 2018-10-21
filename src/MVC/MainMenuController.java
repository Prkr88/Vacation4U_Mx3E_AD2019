package MVC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController extends Controller{
    @FXML
    private void readUserData(ActionEvent event){
        super.myController.setScreen(MVC.Main.screenReadDataID);
    }

    @FXML
    private void updateUserData(ActionEvent event){
        super.myController.setScreen(Main.screenUpdateDataID);
    }

    @FXML
    private void deleteUser(ActionEvent event){
        super.myController.setScreen(Main.screenDeleteUserID);
    }
}
