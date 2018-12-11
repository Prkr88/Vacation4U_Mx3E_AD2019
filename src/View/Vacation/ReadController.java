package View.Vacation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import Controller.Controller;
import Model.Model;
import View.Main;
import View.ScreensController;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class ReadController extends Controller {

    //public ScreensController myController;
    private Model model = new Model();

    @FXML
    private TextField vac_id;
    @FXML
    private Text vacid_read;
    @FXML
    private Text dest_read;
    @FXML
    private Text price_read;
    @FXML
    private Text sDate_read;
    @FXML
    private Text eDate_read;
    @FXML
    private Text num_adult_read;
    @FXML
    private Text num_child_read;
    @FXML
    private Text num_baby_read;
    @FXML
    private Text back_read;
    @FXML
    private Text company_read;
    @FXML
    private Text vac_type_read;
    @FXML
    private Text accom_read;

    @FXML
    public void displayVacations(ActionEvent event) throws IOException {
        ArrayList<ArrayList<String>> result = model.displayVacation();
        FlightDetController fdc = new FlightDetController();
        fdc.setFlightList(result);
        fdc.showTable();
    }

    public void readVacationData(ActionEvent event) {
        String thisID = vac_id.getText();
        String[] res = model.readVacation(thisID);
        if (res != null) {
            vacid_read.setText(res[0]);
            dest_read.setText(res[1]);
            price_read.setText(res[2]);
            sDate_read.setText(res[3]);
            eDate_read.setText(res[4]);
            num_adult_read.setText(res[5]);
            num_child_read.setText(res[6]);
            num_baby_read.setText(res[7]);
            back_read.setText(res[8]);
            company_read.setText(res[9]);
            vac_type_read.setText(res[10]);
            accom_read.setText(res[11]);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("user not found");
            alert.setHeaderText(null);
            alert.setContentText("there is no vacation named " + thisID);
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }
}

