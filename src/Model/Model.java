package Model;

import java.util.ArrayList;

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

    /* USER */

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

    /* VACATION */

    public int addVacation(int iAdultAmount,int iChildAmount,int iBabyAmount, int iTotalPrice, String strDestination, String strAirline, String strDepDate, String strArrivalDate,String strVacType, String sLodge, String sReturn, String strLuggageDetails) {
        int opp = 0;
        opp = insertApp.insertVacation(iAdultAmount, iChildAmount, iBabyAmount, iTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate,strVacType, sLodge, sReturn, strLuggageDetails);
        return opp;
    }

    public ArrayList<ArrayList<String>> displayVacation() { return selectApp.displayVacations(); }

    public ArrayList<ArrayList<String>> displaySwapVacation() { return selectApp.displaySwapVacations(); }

    public String[] readVacation(String destination) {return selectApp.selectVacation(destination);}

    public void updateVacation(int iVacID, int iAdultAmount, int iChildAmount, int iBabyAmount, int iTotalPrice, String strDestination, String strAirline, String strDepDate, String strArrivalDate, String strVacType, String sLodge, String sReturn, String strLuggageDetails) {
        updateApp.updateVacation(iVacID, iAdultAmount, iChildAmount, iBabyAmount, iTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate, strVacType, sLodge, sReturn, strLuggageDetails);
    }

    public void deleteOfferedVacations(int iVacationID){
        deleteApp.deleteOfferedVacations(iVacationID);
    }

    public void swapInsertVacation(int iVacationID){
        insertApp.insertSwapVacation(iVacationID);
    }

    public void swapInsertRequest(int vac_A, String user_A, int vac_B, String user_B){
        insertApp.insertSwapRequestVacation(vac_A, user_A, vac_B, user_B);
    }

    public void swapRequestUpdate(){updateApp.swapRequestUpdate();
    }

}