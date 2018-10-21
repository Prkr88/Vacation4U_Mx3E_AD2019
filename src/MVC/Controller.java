package MVC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


import java.io.IOException;

public class Controller implements ControlledScreen{

    public ScreensController myController;

    @FXML
    private Text output;
    @FXML
    private TextField textField_UserName;
    @FXML
    private PasswordField textField_Pass;
    @FXML
    private Text pleaseEnter;

    private Model model = new Model();

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }


    //checks if the user name and password match the DB
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
    private void signUp(ActionEvent event) {

        myController.setScreen(MVC.Main.screenSignUpID);
    }



    public void showMainMenu() throws IOException{
        myController.setScreen(MVC.Main.screenMainMenuID);
    }

    public void showLoginScreen() throws IOException{
        Main.signedUserName="";
        myController.setScreen(Main.screenLoginID);
    }

    @FXML
    private void done() throws IOException{
        myController.setScreen(MVC.Main.screenMainMenuID);
    }

    @FXML
    private void cancel() throws IOException{
        myController.setScreen(MVC.Main.screenMainMenuID);
    }


}