package View.Vacation;

import Controller.Controller;
import Model.Model;
import View.Main;
import View.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class UpdateController extends Controller{

    public ScreensController myController;
    private Model model = new Model();

    @FXML
    private TextField TXTBX_adult_amount;
    @FXML
    private TextField TXTBX_child_amount;
    @FXML
    private TextField TXTBX_baby_amount;
    @FXML
    private TextField TXTBX_adult_price;
    @FXML
    private TextField TXTBX_child_price;
    @FXML
    private TextField TXTBX_baby_price;
    @FXML
    private TextField TXTBX_destination;
    @FXML
    private TextField TXTBX_airline_company;
    @FXML
    private TextField TXTBX_arrival_DD;
    @FXML
    private TextField TXTBX_arrival_MM;
    @FXML
    private TextField TXTBX_arrival_YYYY;
    @FXML
    private TextField TXTBX_departure_DD;
    @FXML
    private TextField TXTBX_departure_MM;
    @FXML
    private TextField TXTBX_departure_YYYY;
    @FXML
    private TextField TXTBX_luggage_details;
    @FXML
    private CheckBox CHKBX_lodging_included;
    @FXML
    private CheckBox CHKBX_return_flight_included;
    @FXML
    private ImageView beachImage;
    @FXML
    private ImageView hikingImage;
    @FXML
    private ImageView urbanImage;
    @FXML
    private Label selectedType;
    @FXML
    private ComboBox<String> comboType;

    @FXML
    public void updateAction(ActionEvent event) {
        String strAdultAmount = TXTBX_adult_amount.getText();
        String strChildAmount = TXTBX_child_amount.getText();
        String strBabyAmount = TXTBX_baby_amount.getText();
        String strAdultPrice = TXTBX_adult_price.getText();
        String strChildPrice = TXTBX_child_price.getText();
        String strBabyPrice = TXTBX_baby_price.getText();
        int iAdultAmount = 0, iChildAmount = 0, iBabyAmount = 0;
        int iAdultPrice = 0, iChildPrice = 0, iBabyPrice = 0;
        try { iAdultAmount = Integer.parseInt(strAdultAmount); } catch (Exception e) {}
        try { iChildAmount = Integer.parseInt(strChildAmount); } catch (Exception e) {}
        try { iBabyAmount = Integer.parseInt(strBabyAmount); } catch (Exception e) {}
        try { iAdultPrice = Integer.parseInt(strAdultPrice); } catch (Exception e) {}
        try { iChildPrice = Integer.parseInt(strChildPrice); } catch (Exception e) {}
        try { iBabyPrice = Integer.parseInt(strBabyPrice); } catch (Exception e) {}
        int iTotalAmount = iAdultAmount + iChildAmount + iBabyAmount;
        int iTotalPrice = iAdultPrice + iChildPrice + iBabyPrice;
        String strDepDD = TXTBX_departure_DD.getText();
        String strDepMM = TXTBX_departure_MM.getText();
        String strDepYYYY = TXTBX_departure_YYYY.getText();
        String strDepDate = strDepYYYY + "-" + strDepMM + "-" + strDepDD;
        String strArriveDD = TXTBX_arrival_DD.getText();
        String strArriveMM = TXTBX_arrival_MM.getText();
        String strArriveYYYY = TXTBX_arrival_YYYY.getText();
        String strArrivalDate = strArriveYYYY + "-" + strArriveMM + "-" + strArriveDD;
        String strDestination = TXTBX_destination.getText();
        String strAirline = TXTBX_airline_company.getText();
        Boolean boolLodge = CHKBX_lodging_included.isSelected();
        Boolean boolReturnFlight = CHKBX_return_flight_included.isSelected();
        String sLodge;
        String sReturn;
        if (boolLodge)
            sLodge = "yes";
        else
            sLodge = "no";
        if (boolReturnFlight)
            sReturn = "yes";
        else
            sReturn = "no";
        String strLuggageDetails = TXTBX_luggage_details.getText();
        String strVacType = comboType.getValue();
        //model.updateVacation(iAdultAmount, iChildAmount, iBabyAmount, iTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate, strVacType, sLodge, sReturn, strLuggageDetails);
        try {
            super.showMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }
}
