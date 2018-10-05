package userDao;

import users.User;

import java.util.List;


public interface UserDao {
    User login (User user);

   String addUser(User user);

    List<User> showTable(int id);

}
