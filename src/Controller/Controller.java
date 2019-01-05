package Controller;

import View.Main;
import Model.Model;
import Model.*;
import View.ScreensController;
import View.Vacation.FlightReqController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller class responsible for communicating between the View and Model classes
 *
 * @author Matan Bruker, Matan Parker, Meytal Meshulam, Edo Lior
 * @version 3.0
 * @since 26/10/18
 */

public class Controller implements ControlledScreen {

    public View.ScreensController myController;

    @FXML
    private Text output;
    @FXML
    private TextField textField_UserName;
    @FXML
    private PasswordField textField_Pass;
    @FXML
    private Text pleaseEnter;

    private Model model = new Model();
    private int checkSold = 0;
    private int checktoPay = 0;
    private int checkDeclined = 0;
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
        Main.staticController =screenParent;
    }


    /* function checks if the username and password match the DB */
    @FXML
    private void logInAttempt(ActionEvent event) {
        System.out.println("Login Attempt!");
        if(model.isMember(textField_UserName.getText(),textField_Pass.getText())){
            System.out.println("User Loged In");
            try {
                pleaseEnter.setText("Login Success");
                pleaseEnter.setFill(Color.GREEN);
                Main.signedUserName = textField_UserName.getText();
                showMainMenu();
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Login Failed");
            pleaseEnter.setText("Login Failed - wrong UesrName or Password");
            pleaseEnter.setFill(Color.RED);
        }
    }

    @FXML
    /* function listens for opening the Create Form */
    private void signUp(ActionEvent event) {
        myController.setScreen(View.Main.screenSignUpID);
    }

    /* function listens to open the Create Form */
    public void showMainMenu() throws IOException {
        myController.setScreen(View.Main.screenMainMenuID);
        Main.loginController = this;
        checkVactionsUpdate();
    }

    /* function listens to open the Main Menu */
    public void showLoginScreen() throws IOException{
        Main.signedUserName="";
        myController.setScreen(Main.screenLoginID);
    }

    /* checks for sold vacations */
    public void checkVactionsUpdate() throws IOException {
        ArrayList<ArrayList<String>> resultSetListApprovePayment = null;
        ArrayList<ArrayList<String>> resultSetListToPay = null;
        ArrayList<ArrayList<String>> resultSetListDeclinedRequests = null;
        ArrayList<ArrayList<String>> resultSetListSwapR_A = null;
        ArrayList<ArrayList<String>> resultSetListSwapR_B = null;
        SelectApp selectApp = new SelectApp();
        DeleteApp deleteApp = new DeleteApp();
        FlightReqController frc = new FlightReqController();
        if (this.checkSold == 0)
        {
            this.checkSold = 1;
            resultSetListApprovePayment = selectApp.selectApprovePayVacations();
            if(resultSetListApprovePayment.size() > 0) {
                showMessage("Appending User Confirmation", "One or more of your Vacations Awating Payment. \nPlease confirm cash Transfer to complete the deal. ");
                frc.setRequestList(resultSetListApprovePayment);
                frc.showTable();
            }
        }
        if (this.checktoPay == 0)
        {
            resultSetListToPay = selectApp.selectToPayVacations();
            this.checktoPay = 1 ;
            if(resultSetListToPay.size() > 0) {
                String seller_id = "";
                String vId_s = resultSetListToPay.get(0).get(0);
                int vId = Integer.parseInt(vId_s);
                seller_id = selectApp.selectUserByVID(vId);
                if (seller_id != null) {
                    showMessage("Paymet needed", seller_id + "\nhas approved a deal with you.\nPlease Transfer him payment in cash to complete the sale");
                }
            }
        }
        if (this.checkDeclined == 0)
        {
            resultSetListDeclinedRequests = selectApp.selectDeclinedRequests();
            this.checkDeclined = 1 ;
            if(resultSetListDeclinedRequests.size() > 0) {
                String seller_id = "";
                for (int i = 0; i <resultSetListDeclinedRequests.size() ; i++) {
                    String vId_s = resultSetListDeclinedRequests.get(i).get(0);
                    int vId = Integer.parseInt(vId_s);
                    seller_id = resultSetListDeclinedRequests.get(i).get(1);
                    if (seller_id != null) {
                        showMessage("Request Declined", "UsesId: "+seller_id + "\nhas Declined your offer.\non vacation #"+vId_s +"\nGood luck next time!");
                        deleteApp.deleteVacationRequest(vId,Main.signedUserName);
                    }
                }

            }
        }

    }
    /* checks for sold vacations */
    public void showMessage(String title,String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    /* function listens to close window and to open the Main Menu */
    private void done() throws IOException{
        myController.setScreen(View.Main.screenMainMenuID);
    }

    @FXML
    /* function listens to close window to open the Main Menu */
    private void cancel() throws IOException{
        myController.setScreen(View.Main.screenMainMenuID);
    }

    @FXML
    /* function listens to open the Main Menu */
    private void read() throws IOException{
        myController.setScreen(View.Main.screenMainMenuID);
    }

    @FXML
    private void SearchVacation (ActionEvent event) {myController.setScreen(View.Main.screenFindVacationID);}
}