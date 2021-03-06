package View;

import java.io.IOException;
import java.util.HashMap;

import Controller.*;
import View.Vacation.SwapRequestController;
import View.Vacation.SwapVacationsController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * Class adds and loads stages of the gui using hashmap data structure.
 */

public class ScreensController  extends StackPane {
    //Holds the screens to be displayed

    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController() {
        super();
    }

    /**
     * function adds the screen to the collection
     * @param name name of the screen
     * @param screen node of the screen
     */
    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    /**
     * getter function for returning the screen
     * @param name name of the screen
     * @return Node
     */
    public Node getScreen(String name) {
        return screens.get(name);
    }

    /**
     * function loads the fxml file, add the screen to the screens collection and
     * finally injects the screenPane to the controller.
     * @param name name of the screen
     * @param resource file of the screen
     * @param width width of scene
     * @param height height of scene
     * @return boolean if loaded successfully
     */
    public boolean loadScreen(String name, String resource, int width, int height) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            Scene currScene = new Scene(loadScreen,width,height);
            Main.pStage.setScene(currScene);
            Main.pStage.setResizable(false);
            Main.pStage.sizeToScene();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * function displays the screen with a predefined name.
     * First it makes sure the screen has been already loaded.  Then if there is more than
     * one screen the new screen is been added second, and then the current screen is removed.
     * If there isn't any screen being displayed, the new screen is just added to the root.
     * @param name name of the screen
     * @return boolean if sets screen successfully
     */
    public boolean setScreen(final String name) {
        if (screens.get(name) != null) {   //screen loaded
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {    //if there is more than one screen
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                getChildren().remove(0);                    //remove the displayed screen
                                getChildren().add(0, screens.get(name));     //add the screen
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();
                Main.pStage.setTitle(name);
                Main.pStage.setResizable(true);
                Main.pStage.sizeToScene();
                Main.pStage.show();
                if (name.equals(Main.screenSwapVacationID)) {
                    SwapVacationsController svc = new SwapVacationsController();
                    try {
                        svc.initSwapScreen();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));       //no one else been displayed, then just show
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(1000), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }

    }

    //
    /**
     * function removes the screen with the given name from the collection of screens
     * @param name name of the screen
     * @return boolean if unloaded screen successfully
     */
    public boolean unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }
}
