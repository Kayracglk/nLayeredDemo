package lovinityChat.northwind.business.concretes;

import lovinityChat.northwind.business.abstracts.UserService;
import lovinityChat.northwind.core.dataAccess.UserDao;
import lovinityChat.northwind.core.entities.User;
import lovinityChat.northwind.core.utilities.results.DataResult;
import lovinityChat.northwind.core.utilities.results.Result;
import lovinityChat.northwind.core.utilities.results.SuccessDataResult;
import lovinityChat.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result Add(User user) {
        userDao.save(user);
        return new SuccessResult("User Added");
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(userDao.findByEmail(email), "Data Listed");
    }
}
