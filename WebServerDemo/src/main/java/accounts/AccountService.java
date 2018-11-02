package accounts;

import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;
import dbService.executor.DBException;
import dbService.executor.DBService;

import java.util.*;

public class AccountService {

    //private final Map<String,UserProfile> loginToProfile;
    private DBService dbService;

    public AccountService(DBService dbService) {

        this.dbService=dbService;
        //loginToProfile = new HashMap<>();
    }

    public void addNewUser(String login,String password){
        try {
            dbService.addUser(login, password);
        } catch (DBException e) {
            e.printStackTrace();
        }
        //loginToProfile.put(userProfile.getLogin(),userProfile);
    }

    public UsersDataSet getUserByLogin(String login) {
        try {
            return dbService.getUser(login);
        } catch (DBException e) {
            e.printStackTrace();
            return null;
        }
        //return loginToProfile.get(login);
    }

}
