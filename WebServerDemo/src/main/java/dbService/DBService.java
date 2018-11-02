package dbService;

import dbService.dataSets.UsersDataSet;
import dbService.executor.DBException;

public interface DBService {

    void addUser(String login, String password) throws DBException;
    UsersDataSet getUser(String login) throws DBException;

}
