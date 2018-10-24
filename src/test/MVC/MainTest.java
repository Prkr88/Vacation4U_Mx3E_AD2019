//
//
//import Sqlite.*;
//import javafx.scene.text.Text;
//import javafx.scene.Scene;
//import javafx.scene.*;
//import javafx.stage.Stage;
//import org.junit.Test;
//import org.loadui.testfx.GuiTest;
//import org.testfx.framework.junit.ApplicationTest;
//import org.testfx.util.WaitForAsyncUtils;
//
//import static junit.framework.TestCase.assertTrue;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertThat;
//import MVC.Main;
//
//public class MainTest extends ApplicationTest {
//    private SqlApp sqlApp;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        ScreensController mainContainer = new ScreensController();
//        mainContainer.loadScreen(MVC.Main.screenLoginID, MVC.Main.screenLoginFile);
//        mainContainer.loadScreen(MVC.Main.screenMainMenuID, MVC.Main.screenMainMenuFile);
//        mainContainer.loadScreen(MVC.Main.screenReadDataID, MVC.Main.screenReadDatFile);
//        mainContainer.loadScreen(MVC.Main.screenUpdateDataID, MVC.Main.screenUpdateDataFile);
//        mainContainer.loadScreen(MVC.Main.screenDeleteUserID, MVC.Main.screenDeleteUserFile);
//        mainContainer.loadScreen(MVC.Main.screenSignUpID, MVC.Main.screenSignUpFile);
//
//        mainContainer.setScreen(MVC.Main.screenLoginID);
//
//        Group root = new Group();
//        root.getChildren().addAll(mainContainer);
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//    }
//
////    @Before
////    public void setUp () throws Exception {
////    }
////
////    @After
////    public void tearDown () throws Exception {
////        FxToolkit.hideStage();
////        release(new KeyCode[]{});
////        release(new MouseButton[]{});
////    }
//
//    //Test Good LogIn
//    @Test
//    public void GoodLogIn() {
//        Text status;
//        try {
//            clickOn("#textField_UserName");
//            sleep(1000);
//            write("edoLior");
//            clickOn("#textField_Pass");
//            write("123456");
//
//            clickOn("#login_button");
//        } catch (Exception e) {
//            System.out.println("Stupid Exception");
//        }
//        WaitForAsyncUtils.clearExceptions();
//        status = GuiTest.find("#pleaseEnter");
//        System.out.println(status.getText());
//        assertEquals(status.getText(), "Login Success");
//
//    }
//
//    //Bad User Name
//    @Test
//    public void BadUserName() {
//        Text status;
//        try {
//            clickOn("#textField_UserName");
//            write("edo");
//            clickOn("#textField_Pass");
//            write("123456");
//            clickOn("#login_button");
//        } catch (Exception e) {
//            System.out.println("Stupid Exception");
//        }
//        WaitForAsyncUtils.clearExceptions();
//        status = GuiTest.find("#pleaseEnter");
//        System.out.println(status.getText());
//        assertNotEquals(status.getText(), "Login Success");
//    }
//
//    //Bad User Password
//    @Test
//    public void BadPassword() {
//        Text status;
//        try {
//            clickOn("#textField_UserName");
//            write("edoLior");
//            clickOn("#textField_Pass");
//            write("12");
//            clickOn("#login_button");
//        } catch (Exception e) {
//            System.out.println("Stupid Exception");
//        }
//        WaitForAsyncUtils.clearExceptions();
//        status = GuiTest.find("#pleaseEnter");
//        System.out.println(status.getText());
//        assertNotEquals(status.getText(), "Login Success");
//    }
//
//    //Delete user
//    @Test
//    public void deleteAndSignUp() {
//        clickOn("#textField_UserName");
//        sleep(1000);
//        write("Prkr");
//        clickOn("#textField_Pass");
//        write("123456");
//        clickOn("#login_button");
//        clickOn("#deleteUser_Button");
//        clickOn("#yes_delete");
//        clickOn();
//        write("123456");
//        sleep(3000);
//    }
//
//
//}
//
