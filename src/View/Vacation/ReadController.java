package View.Vacation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import Controller.*;
import Model.*;
import View.*;

public class ReadController extends Controller {

    @FXML
    public void readVacationData(ActionEvent event) {}

        String[] res = model.readVacation();


        if(res != null) {
            vacid_read.setText(res[0]);
            dest_read.setText(res[1]);
            price_read.setText(res[2]);
            sDate_read.setText(res[3]);
            eDate_read.setText(res[4]);
            num_adult_read.setText(res[5]);
            num_kid_read.setText(res[6]);
            num_baby_read.setText(res[7]);
            flight_back_read.setText(res[8]);
            flight_company_read.setText(res[9]);
            flight_vac_type.setText(res[10]);
            flight_accom_read.setText(res[11]);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("user not found");
            alert.setHeaderText(null);
            alert.setContentText("there is no vacation named " + user);
            alert.showAndWait();
        }
    }
    */

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }
}

