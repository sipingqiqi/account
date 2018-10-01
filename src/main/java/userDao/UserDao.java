package userDao;

import users.User;

public interface UserDao {

   String login (User user);

   String addUser(User user);

}
