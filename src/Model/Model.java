package Model;

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

    public void addVacation(int iAdultAmount,int iChildAmount,int iBabyAmount, int iTotalPrice, String strDestination, String strAirline, String strDepDate, String strArrivalDate,String strVacType, String sLodge, String sReturn, String strLuggageDetails) {
        insertApp.insertVacation(iAdultAmount, iChildAmount, iBabyAmount, iTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate,strVacType, sLodge, sReturn, strLuggageDetails);
    }

    public String[] readVacation(String destination) {return selectApp.selectVacation(destination);}

    public void updateVacation(int iAdultAmount, int iChildAmount, int iBabyAmount, int iTotalPrice, String strDestination, String strAirline, String strDepDate, String strArrivalDate, String strVacType, String sLodge, String sReturn, String strLuggageDetails) {
        updateApp.updateVacation(iAdultAmount, iChildAmount, iBabyAmount, iTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate, strVacType, sLodge, sReturn, strLuggageDetails);
    }

    public void deleteVacation(String strVacationID){
        deleteApp.deleteVacation(strVacationID);
    }

}