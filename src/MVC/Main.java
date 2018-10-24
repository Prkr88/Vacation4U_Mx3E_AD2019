package MVC;

        import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.stage.Stage;


public class Main extends Application {
    public static Stage pStage;

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
    public static String signedUserName;

    @Override
    public void start(Stage primaryStage) throws Exception {
        pStage = primaryStage;
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


    public static void main(String[] args) {
        launch(args);
    }
}