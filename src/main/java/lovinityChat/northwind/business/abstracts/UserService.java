package lovinityChat.northwind.business.abstracts;

import lovinityChat.northwind.core.entities.User;
import lovinityChat.northwind.core.utilities.results.DataResult;
import lovinityChat.northwind.core.utilities.results.Result;

public interface UserService {
    Result Add(User user);
    DataResult<User> getByEmail(String email);
}
