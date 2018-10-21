package MVC;

        import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.stage.Stage;


public class Main extends Application {
  //  public static Stage pStage;
    public static String screenSignUpID = "SignUp";
    public static String screenSignUpFile = "SignUpXML.fxml";
    public static String screenLoginID = "LogIn";
    public static String screenLoginFile = "LoginXML.fxml";
    public static String screenMainMenuID = "MainMenu";
    public static String screenMainMenuFile = "MenuXML.fxml";
    public static String screenReadDataID = "ReadData";
    public static String screenReadDatFile = "ReadXML.fxml";
    public static String screenUpdateDataID = "UpdateData";
    public static String screenUpdateDataFile = "UpdateXML.fxml";
    public static String screenDeleteUserID = "DeleteUser";
    public static String screenDeleteUserFile = "DeleteXML.fxml";
    public static String signedUserName;

    @Override
    public void start(Stage primaryStage) throws Exception {

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(screenLoginID, screenLoginFile);
        mainContainer.loadScreen(screenMainMenuID, screenMainMenuFile);
        mainContainer.loadScreen(screenReadDataID, screenReadDatFile);
        mainContainer.loadScreen(screenUpdateDataID, screenUpdateDataFile);
        mainContainer.loadScreen(screenDeleteUserID, screenDeleteUserFile);
        mainContainer.loadScreen(screenSignUpID, screenSignUpFile);
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