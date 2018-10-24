package MVC;

import Sqlite.*;
import java.sql.*;

public class Model {

    private DeleteApp deleteApp;
    private InsertApp insertApp;
    private SelectApp selectApp;
    private UpdateApp updateApp;

    public Model() {
        this.deleteApp = new DeleteApp();
        this.insertApp = new InsertApp();
        this.selectApp = new SelectApp();
        this.updateApp = new UpdateApp();
    }


    public boolean isMember(String userName, String password) {
        return selectApp.loogIn(userName, password);
    }

    public void registerUserToDB(String userName ,String password,String bDate,String pName,String lName,String city) {
        insertApp.insert(userName ,password,bDate,pName,lName,city);
    }

    public void deleteUser(String userName,String password){
        deleteApp.deleteUser(userName,password);
    }

    public String[] readUser(String userName) {return selectApp.selectUser(userName);} // my addition

    public void updateUserData(String userName ,String password,String bDate,String pName,String lName,String city){
        updateApp.updateUser(userName,password,bDate,pName,lName,city);
    }
}