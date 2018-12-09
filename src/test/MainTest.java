

import MVC.Main;
import Sqlite.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import java.awt.*;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import MVC.*;

public class MainTest extends ApplicationTest {
    private SqlApp sqlApp = new SqlApp();
    public static String screenSignUpID = "Registration Form";
    public static String screenSignUpFile = "SignUpXML.fxml";
    public static String screenLoginID = "Login Window";
    public static String screenLoginFile = "LoginXML.fxml";
    public static String screenMainMenuID = "Main Menu";
    public static String screenMainMenuFile = "MenuXML.fxml";
    public static String screenReadDataID = "Search Form";
    public static String screenReadDatFile = "ReadXML.fxml";
    public static String screenUpdateDataID = "Update Form";
    public static String screenUpdateDataFile = "UpdateXML.fxml";
    public static String screenDeleteUserID = "Deletion Form";
    public static String screenDeleteUserFile = "DeleteXML.fxml";


    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.pStage = primaryStage;

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(screenLoginID, screenLoginFile,675,450);
        mainContainer.loadScreen(screenMainMenuID, screenMainMenuFile,500,500);
        mainContainer.loadScreen(screenReadDataID, screenReadDatFile,675,450);
        mainContainer.loadScreen(screenUpdateDataID, screenUpdateDataFile,675,450);
        mainContainer.loadScreen(screenDeleteUserID, screenDeleteUserFile,150,100);
        mainContainer.loadScreen(screenSignUpID, screenSignUpFile,675,450);

        mainContainer.setScreen(screenLoginID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

//    @Before
//    public void setUp () throws Exception {
//    }
//
//    @After
//    public void tearDown () throws Exception {
//        FxToolkit.hideStage();
//        release(new KeyCode[]{});
//        release(new MouseButton[]{});
//    }


    //Test Good LogIn
    @Test
    public void GoodLogIn() {
        Text status;
        try {
            clickOn("#textField_UserName");
            sleep(1000);
            write("edoLior");
            clickOn("#textField_Pass");
            write("123456");

            clickOn("#login_button");
        } catch (Exception e) {
            System.out.println("Stupid Exception");
        }
        WaitForAsyncUtils.clearExceptions();
        status = GuiTest.find("#pleaseEnter");
       // System.out.println(status.getText());
        assertEquals(status.getText(), "Login Success");

    }

    //Bad User Name
    @Test
    public void BadUserName() {
        Text status;
        try {
            clickOn("#textField_UserName");
            write("edo");
            clickOn("#textField_Pass");
            write("123456");
            clickOn("#login_button");
        } catch (Exception e) {
            System.out.println("Stupid Exception");
        }
        WaitForAsyncUtils.clearExceptions();
        status = GuiTest.find("#pleaseEnter");
       // System.out.println(status.getText());
        assertNotEquals(status.getText(), "Login Success");
    }

    //Bad User Password
    @Test
    public void BadPassword() {
        Text status;
        try {
            clickOn("#textField_UserName");
            write("edoLior");
            clickOn("#textField_Pass");
            write("12");
            clickOn("#login_button");
        } catch (Exception e) {
            System.out.println("Stupid Exception");
        }
        WaitForAsyncUtils.clearExceptions();
        status = GuiTest.find("#pleaseEnter");
        //System.out.println(status.getText());
        assertNotEquals(status.getText(), "Login Success");
    }


    //Delete user one
    @Test
    public void deleteAndSignUp() {
        String userName = sqlApp.checkIfUserInDB("Prkr");
        if(userName!=null) {
            logInPrkr();
            deleteUser();
            userName = sqlApp.checkIfUserInDB("Prkr");
            assertEquals(userName, null);
        }else {
            signUp();
            userName = sqlApp.checkIfUserInDB("Prkr");
            assertEquals(userName,"Prkr");
            deleteUser();
            userName = sqlApp.checkIfUserInDB("Prkr");
            assertEquals(userName, null);
        }
    }

    @Test
    public void deleteAndSignUp2() {
        String userName = sqlApp.checkIfUserInDB("Prkr");
        if(userName!=null) {
            logInPrkr();
            deleteUser();
            userName = sqlApp.checkIfUserInDB("Prkr");
            assertEquals(userName, null);
        }else {
            signUp();
            userName = sqlApp.checkIfUserInDB("Prkr");
            assertEquals(userName,"Prkr");
            deleteUser();
            userName = sqlApp.checkIfUserInDB("Prkr");
            assertEquals(userName, null);
        }
    }

    @Test
    public void read() {
        Text userName;
        Text firstName;
        Text lastName;
        logInEdo();
        sleep(4000);
        clickOn("#read_button");
        sleep(4000);
        clickOn("#user_name");
        write("edoLior");
        clickOn("#btn_done");
        userName = GuiTest.find("#username_read");
        firstName = GuiTest.find("#first_name_read");
        lastName = GuiTest.find("#last_name_read");
        assertEquals(userName.getText(), "edoLior");
        assertEquals(firstName.getText(), "edo");
        assertEquals(lastName.getText(), "Lior");



    }

    public void signUp(){
        clickOn("#button_signup");
        sleep(4000);
        clickOn("#signUP_first_name");
        write("matan");
        clickOn("#signUP_last_name");
        write("parker");
        clickOn("#signUP_user_name");
        write("Prkr");
        clickOn("#signUP_password");
        write("123456");
        clickOn("#signUP_DD");
        write("23");
        clickOn("#signUP_MM");
        write("12");
        clickOn("#signUP_YYYY");
        write("1988");
        clickOn("#signUP_city");
        write("BeerSheva");
        clickOn("#btn_done");

    }


    public void deleteUser(){
        sleep(4000);
        clickOn("#deleteUser_button");
        sleep(4000);
        clickOn("#yes_delete");
        write("123456");
        clickOn("OK");
        clickOn("OK");
        sleep(3000);
    }

    public void logInPrkr(){
        clickOn("#textField_UserName");
        write("Prkr");
        clickOn("#textField_Pass");
        write("123456");
        clickOn("#login_button");
    }

    public void logInEdo(){
        clickOn("#textField_UserName");
        write("edoLior");
        clickOn("#textField_Pass");
        write("123456");
        clickOn("#login_button");
    }

}

