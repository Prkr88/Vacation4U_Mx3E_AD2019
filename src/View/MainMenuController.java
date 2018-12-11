package View;

import Controller.Controller;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController extends Controller {

    @FXML
    /* function listens for opening the Search Form */
    private void readUserData(ActionEvent event){
        super.myController.setScreen(View.Main.screenReadDataID);
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

    @FXML
    private void createVacation(ActionEvent event){
        super.myController.setScreen(Main.screenCreateVacationID);
    }

    @FXML
    private void readVacation(ActionEvent event){
        super.myController.setScreen(Main.screenReadVacationID);
    }

    @FXML
    private void updateVacation(ActionEvent event){
        super.myController.setScreen(Main.screenUpdateVacationID);
    }

    @FXML
    private void deleteVacation(ActionEvent event){
        super.myController.setScreen(Main.screenDeleteVacationID);
    }

    @FXML
    private void pay(ActionEvent event){
        super.myController.setScreen(Main.screenPaymentMethodID);
    }

    @FXML
    private void SearchVacation (ActionEvent event) {super.myController.setScreen(Main.screenFindVacationID);}

}
