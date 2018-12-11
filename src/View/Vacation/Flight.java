package View.Vacation;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.scene.control.CheckBox;


public class Flight {

    private SimpleIntegerProperty FDATA_id;
    private SimpleStringProperty FDATA_f_departure;
    private SimpleStringProperty FDATA_f_return;
    private SimpleStringProperty FDATA_destination;
    private SimpleStringProperty FDATA_cost;
    private CheckBox FDATA_check;

    public Flight(int id, String f_departure, String f_return, String destination, String cost) {
        this.FDATA_id = new SimpleIntegerProperty(id);
        this.FDATA_f_departure = new SimpleStringProperty(f_departure) ;
        this.FDATA_f_return = new SimpleStringProperty(f_return);
        this.FDATA_destination = new SimpleStringProperty(destination);
        this.FDATA_cost = new SimpleStringProperty(cost);
        this.FDATA_check = new CheckBox();
    }

    public int getFDATA_id() {
        return FDATA_id.get();
    }

    public SimpleIntegerProperty FDATA_idProperty() {
        return FDATA_id;
    }

    public void setFDATA_id(int FDATA_id) {
        this.FDATA_id.set(FDATA_id);
    }

    public String getFDATA_f_departure() {
        return FDATA_f_departure.get();
    }

    public SimpleStringProperty FDATA_f_departureProperty() {
        return FDATA_f_departure;
    }

    public void setFDATA_f_departure(String FDATA_f_departure) {
        this.FDATA_f_departure.set(FDATA_f_departure);
    }

    public String getFDATA_f_return() {
        return FDATA_f_return.get();
    }

    public SimpleStringProperty FDATA_f_returnProperty() {
        return FDATA_f_return;
    }

    public void setFDATA_f_return(String FDATA_f_return) {
        this.FDATA_f_return.set(FDATA_f_return);
    }

    public String getFDATA_destination() {
        return FDATA_destination.get();
    }

    public SimpleStringProperty FDATA_destinationProperty() {
        return FDATA_destination;
    }

    public void setFDATA_destination(String FDATA_destination) {
        this.FDATA_destination.set(FDATA_destination);
    }

    public String getFDATA_cost() {
        return FDATA_cost.get();
    }

    public SimpleStringProperty FDATA_costProperty() {
        return FDATA_cost;
    }

    public void setFDATA_cost(String FDATA_cost) {
        this.FDATA_cost.set(FDATA_cost);
    }

    public CheckBox getFDATA_check() {
        return FDATA_check;
    }

    public void setFDATA_check(CheckBox FDATA_check) {
        this.FDATA_check = FDATA_check;
    }
}
