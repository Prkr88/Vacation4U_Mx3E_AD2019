package Controller;

import View.Main;
import Model.*;
import View.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.io.IOException;

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
    @FXML
    private ImageView logoImage;

    private Model model = new Model();

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
                //checkSwapRequests();
                //checkSwapConfirmation();
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

    private void checkSwapRequests() {
        try {
            SelectApp sa = new SelectApp();
            String[] res = sa.selectSwapRequestVacation();
            if (res[0] != null && res[1] != null) {
                String otherUserID = res[0];
                String otherUserVac = res[1];
            }
        }
        catch (Exception e) {
            int i;
        }
    }

    public void checkSwapConfirmation() {
        try {
            SelectApp sa = new SelectApp();
            String res = sa.selectSwapConfirmation();
            if (res != null) {
                String confirm_A = res;
            }
        }
        catch (Exception e) {
            int i;
        }
    }

    @FXML
    /* function listens for opening the Create Form */
    private void signUp(ActionEvent event) {
        myController.setScreen(View.Main.screenSignUpID);
    }

    /* function listens to open the Create Form */
    public void showMainMenu() throws IOException { myController.setScreen(View.Main.screenMainMenuID); }

    /* function listens to open the Main Menu */
    public void showLoginScreen() throws IOException{
        Main.signedUserName="";
        myController.setScreen(Main.screenLoginID);
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