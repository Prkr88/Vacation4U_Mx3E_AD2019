package View;

        import View.Vacation.Flight;
        import View.Vacation.FlightDetController;
        import View.Vacation.Request;
        import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

/**
 * Welcome to Vacation4U database system.
 * Main class sets the View, Model and Controller classes representing the View model.
 * Initializes the first opening scene (Login).
 * SQL Database filename: "Vacation.db" in resources.
 * Maven projects included: SQL & JUnit integrations.
 *
 *
 * @author Matan Bruker, Matan Parker, Meytal Meshulam, Edo Lior
 * @version 3.0
 * @since 26/10/18
 */


public class Main extends Application {
    public static Stage pStage;
    public static Scene mainScene;
    public static String userPath = "User/";
    public static String vacationPath = "Vacation/";
    public static String paymentPath = "Payment/";
    public static String screenSignUpID = "Registration Form";
    public static String screenSignUpFile = userPath + "SignUpXML.fxml";
    public static String screenLoginID = "Login Window";
    public static String screenLoginFile = userPath + "LoginXML.fxml";
    public static String screenMainMenuID = "Main Menu";
    public static String screenMainMenuFile = "MenuXML.fxml";
    public static String screenReadDataID = "Search Form";
    public static String screenReadDatFile = userPath + "ReadXML.fxml";
    public static String screenUpdateDataID = "Update Form";
    public static String screenUpdateDataFile = userPath + "UpdateXML.fxml";
    public static String screenDeleteUserID = "Deletion Form";
    public static String screenDeleteUserFile = userPath + "DeleteXML.fxml";
    public static String signedUserName;
    public static int vacationBoght = -1;
    public static String screenCreateVacationID = "Create Vacation Window";
    public static String screenCreateVacationFile = vacationPath + "CreateXML.fxml";
    public static String screenReadVacationID = "Read Vacation Window";
    public static String screenReadVacationFile = vacationPath + "ReadXML.fxml";
    public static String screenUpdateVacationID = "Update Vacation Window";
    public static String screenUpdateVacationFile = vacationPath + "UpdateXML.fxml";
    public static String screenDeleteVacationID = "Delete Vacation Window";
    public static String screenDeleteVacationFile = vacationPath + "DeleteXML.fxml";
    public static String screenPaymentMethodID = "Payment Method Window";
    public static String screenPaymentMethodFile = paymentPath + "PaymentMethod.fxml";
    public static String screenPaypalID = "Paypal pay Window";
    public static String screenPaypalFile = paymentPath + "PayPal.fxml";
    public static String screenVisaID = "Visa pay Window";
    public static String screenVisaFile = paymentPath + "Visa.fxml";
    public static String screenFindVacationID = "Search Vacation Window";
    public static String screenFindVacationFile= vacationPath + "FindVacation.fxml";
    public ScreensController mainContainer = new ScreensController();
    public static ScreensController staticController;
    public static Flight toBuy;
    public static Request toAprove;

    @Override
    public void start(Stage primaryStage) throws Exception {
        pStage = primaryStage;

        mainContainer.loadScreen(screenLoginID, screenLoginFile,900,700);
        mainContainer.loadScreen(screenMainMenuID, screenMainMenuFile,900,700);
        mainContainer.loadScreen(screenReadDataID, screenReadDatFile,900,700);
        mainContainer.loadScreen(screenUpdateDataID, screenUpdateDataFile,900,700);
        mainContainer.loadScreen(screenDeleteUserID, screenDeleteUserFile,900,700);
        mainContainer.loadScreen(screenSignUpID, screenSignUpFile,675,450);
        mainContainer.loadScreen(screenCreateVacationID, screenCreateVacationFile,675,450);
        mainContainer.loadScreen(screenReadVacationID, screenReadVacationFile,675,450);
        mainContainer.loadScreen(screenUpdateVacationID, screenUpdateVacationFile,675,450);
        mainContainer.loadScreen(screenDeleteVacationID, screenDeleteVacationFile,675,450);
        mainContainer.loadScreen(screenPaymentMethodID, screenPaymentMethodFile,675,450);
        mainContainer.loadScreen(screenPaypalID, screenPaypalFile,675,450);
        mainContainer.loadScreen(screenVisaID, screenVisaFile,675,450);
        mainContainer.loadScreen(screenFindVacationID, screenFindVacationFile, 900, 600);

        mainContainer.setScreen(screenLoginID);
        //FlightDetController fdc = new FlightDetController();
        //fdc.showTable(primaryStage);
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}