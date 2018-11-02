package accounts;

import dbService.dataSets.UsersDataSet;
import dbService.executor.DBException;
import dbService.executor.DBServiceImp;
import dbService.DBService;

public class AccountService {

    //private final Map<String,UserProfile> loginToProfile;
    private DBService dbServiceImp;

    public AccountService(DBService dbServiceImp) {

        this.dbServiceImp = dbServiceImp;
        //loginToProfile = new HashMap<>();
    }

    public void addNewUser(String login,String password){
        try {
            dbServiceImp.addUser(login, password);
        } catch (DBException e) {
            e.printStackTrace();
        }
        //loginToProfile.put(userProfile.getLogin(),userProfile);
    }

    public UsersDataSet getUserByLogin(String login) {
        try {
            return dbServiceImp.getUser(login);
        } catch (DBException e) {
            e.printStackTrace();
            return null;
        }
        //return loginToProfile.get(login);
    }

}
