package Model;

import Model.InsertApp;
/**
 * The Model layer is responsible for:
 * (1) Creating a new user
 * (2) Searching for a user
 * (3) Updating certain information fields of the user
 * (4) Deleting the user
 *
 * @author Matan Bruker, Matan Parker, Meytal Meshulam, Edo Lior
 * @version 3.0
 * @since 26/10/18
 */



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
        insertApp.insertUser(userName ,password,bDate,pName,lName,city);
    }

    public void deleteUser(String userName,String password){
        deleteApp.deleteUser(userName,password);
    }

    public String[] readUser(String userName) {return selectApp.selectUser(userName);} // my addition

    public void updateUserData(String userName ,String password,String bDate,String pName,String lName,String city){
        updateApp.updateUser(userName,password,bDate,pName,lName,city);
    }
/*
    public void addVacation(Integer intTotalAmount, Integer intTotalPrice, String strDestination, String strAirline, String strDepDate, String strArrivalDate, Boolean boolLodge, Boolean boolReturnFlight, String strLuggageDetails) {
        insertApp.insertVacation(intTotalAmount, intTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate, boolLodge, boolReturnFlight, strLuggageDetails);
    }

    public void updateVacation(Integer intTotalAmount, Integer intTotalPrice, String strDestination, String strAirline, String strDepDate, String strArrivalDate, Boolean boolLodge, Boolean boolReturnFlight, String strLuggageDetails);
        updateApp.updateVacation(intTotalAmount, intTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate, boolLodge, boolReturnFlight, strLuggageDetails);
    }

    public void deleteVacation(String strVacationID){
        deleteApp.deleteVacation(strVacationID);
    }
*/
}