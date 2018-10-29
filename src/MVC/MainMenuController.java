package MVC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController extends Controller{

    @FXML
    /* function listens for opening the Search Form */
    private void readUserData(ActionEvent event){
        super.myController.setScreen(MVC.Main.screenReadDataID);
    }

    @FXML
    /* function listens for opening the Update Form */
    private void updateUserData(ActionEvent event){
        super.myController.setScreen(Main.screenUpdateDataID);
    }

    @FXML
    /* function listens for opening the Deletion Form */
    private void deleteUser(ActionEvent event){
        super.myController.setScreen(Main.screenDeleteUserID);
    }
}
