package kpfu.itis.group907.Economic.Service.Impl;

import kpfu.itis.group907.Economic.Dao.DefaultUserDao;
import kpfu.itis.group907.Economic.Dao.Impl.DefaultUserDaoImpl;
import kpfu.itis.group907.Economic.Models.DefaultUser;
import kpfu.itis.group907.Economic.Service.DefaultUserService;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class DefaultUserServiceImpl implements DefaultUserService {
    private final DefaultUserDao dao = new DefaultUserDaoImpl();

    @Override
    public DefaultUser get(String login, String password) throws SQLException {
        return dao.get(login, password);
    }

    @Override
    public void save(DefaultUser defaultUser) throws NoSuchAlgorithmException, SQLException {
        dao.save(new DefaultUser(defaultUser.getLogin(), defaultUser.getPassword(), defaultUser.getLAST_NAME(), defaultUser.getFIRST_NAME(), defaultUser.getEMAIL()));
    }
}
