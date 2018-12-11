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
    private SimpleIntegerProperty FDATA_cost;
    private SimpleStringProperty FDATA_back;
    private SimpleStringProperty FDATA_company;
    private SimpleStringProperty FDATA_vacType;
    private SimpleIntegerProperty FDATA_A;
    private SimpleIntegerProperty FDATA_K;
    private SimpleIntegerProperty FDATA_B;
    private SimpleStringProperty FDATA_seller;
    private CheckBox FDATA_check;

    public Flight(int FDATA_id, String FDATA_f_departure, String FDATA_f_return, String FDATA_destination, int FDATA_cost, String FDATA_back, String FDATA_company, String FDATA_vacType, int FDATA_A, int FDATA_K, int FDATA_B, String FDATA_seller) {
        this.FDATA_id = new SimpleIntegerProperty(FDATA_id);
        this.FDATA_f_departure = new SimpleStringProperty(FDATA_f_departure);
        this.FDATA_f_return = new SimpleStringProperty(FDATA_f_return);
        this.FDATA_destination = new SimpleStringProperty(FDATA_destination);
        this.FDATA_cost = new SimpleIntegerProperty(FDATA_cost);
        this.FDATA_back = new SimpleStringProperty(FDATA_back);
        this.FDATA_company = new SimpleStringProperty(FDATA_company);
        this.FDATA_vacType = new SimpleStringProperty(FDATA_vacType);
        this.FDATA_A = new SimpleIntegerProperty(FDATA_A);
        this.FDATA_K = new SimpleIntegerProperty(FDATA_K);
        this.FDATA_B = new SimpleIntegerProperty(FDATA_B);
        this.FDATA_seller = new SimpleStringProperty(FDATA_seller);
        this.FDATA_check = new CheckBox(Integer.toString(FDATA_id));
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


    public int getFDATA_cost() {
        return FDATA_cost.get();
    }

    public SimpleIntegerProperty FDATA_costProperty() {
        return FDATA_cost;
    }

    public void setFDATA_cost(int FDATA_cost) {
        this.FDATA_cost.set(FDATA_cost);
    }

    public String getFDATA_back() {
        return FDATA_back.get();
    }

    public SimpleStringProperty FDATA_backProperty() {
        return FDATA_back;
    }

    public void setFDATA_back(String FDATA_back) {
        this.FDATA_back.set(FDATA_back);
    }

    public String getFDATA_company() {
        return FDATA_company.get();
    }

    public SimpleStringProperty FDATA_companyProperty() {
        return FDATA_company;
    }

    public void setFDATA_company(String FDATA_company) {
        this.FDATA_company.set(FDATA_company);
    }

    public String getFDATA_vacType() {
        return FDATA_vacType.get();
    }

    public SimpleStringProperty FDATA_vacTypeProperty() {
        return FDATA_vacType;
    }

    public void setFDATA_vacType(String FDATA_vacType) {
        this.FDATA_vacType.set(FDATA_vacType);
    }

    public int getFDATA_A() {
        return FDATA_A.get();
    }

    public SimpleIntegerProperty FDATA_AProperty() {
        return FDATA_A;
    }

    public void setFDATA_A(int FDATA_A) {
        this.FDATA_A.set(FDATA_A);
    }

    public int getFDATA_B() {
        return FDATA_B.get();
    }

    public SimpleIntegerProperty FDATA_BProperty() {
        return FDATA_B;
    }

    public void setFDATA_B(int FDATA_B) {
        this.FDATA_B.set(FDATA_B);
    }

    public int getFDATA_K() {
        return FDATA_K.get();
    }

    public SimpleIntegerProperty FDATA_CProperty() {
        return FDATA_K;
    }

    public void setFDATA_K(int FDATA_C) {
        this.FDATA_K.set(FDATA_C);
    }

    public String getFDATA_seller() {
        return FDATA_seller.get();
    }

    public SimpleStringProperty FDATA_sellerProperty() {
        return FDATA_seller;
    }

    public void setFDATA_seller(String FDATA_seller) {
        this.FDATA_seller.set(FDATA_seller);
    }

    public CheckBox getFDATA_check() {
        return FDATA_check;
    }

    public void setFDATA_check(CheckBox FDATA_check) {
        this.FDATA_check = FDATA_check;
    }
}
