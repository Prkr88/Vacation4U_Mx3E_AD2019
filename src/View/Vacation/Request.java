package View.Vacation;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.scene.control.CheckBox;


public class Request {

    private SimpleIntegerProperty RDATA_id;
    private SimpleStringProperty RDATA_buyer_Request;
    private CheckBox RDATA_check;

    public Request(int RDATA_id, String RDATA_buyer_Request) {
        this.RDATA_id = new SimpleIntegerProperty(RDATA_id);
        this.RDATA_buyer_Request = new SimpleStringProperty(RDATA_buyer_Request);
        this.RDATA_check = new CheckBox(Integer.toString(RDATA_id));
    }

    public int getRDATA_id() {
        return RDATA_id.get();
    }

    public SimpleIntegerProperty RDATA_idProperty() {
        return RDATA_id;
    }

    public void setRDATA_id(int RDATA_id) {
        this.RDATA_id.set(RDATA_id);
    }

    public String getRDATA_buyer_Request() {
        return RDATA_buyer_Request.get();
    }

    public SimpleStringProperty RDATA_buyer_RequestProperty() {
        return RDATA_buyer_Request;
    }

    public void setRDATA_buyer_Request(String RDATA_buyer_Request) {
        this.RDATA_buyer_Request.set(RDATA_buyer_Request);
    }

    public CheckBox getRDATA_check() {
        return RDATA_check;
    }

    public void setRDATA_check(CheckBox RDATA_check) {
        this.RDATA_check = RDATA_check;
    }

    public boolean isChecked(){
        return RDATA_check.isSelected();
    }
}
