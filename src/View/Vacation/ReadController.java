package View.Vacation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import Controller.*;
import View.*;

public class ReadController extends Controller {

    @FXML
    public void readVacationData(ActionEvent event) {}

        /*
        String[] res = model.readVacation();


        if(res != null) {
            username_read.setText(res[0]);
            first_name_read.setText(res[1]);
            last_name_read.setText(res[2]);
            bDate_read.setText(res[3]);
            city_read.setText(res[4]);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("user not found");
            alert.setHeaderText(null);
            alert.setContentText("there is no user called " + user);
            alert.showAndWait();
        }
    }
    */

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }
}

