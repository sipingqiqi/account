package userDao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.User;

import java.util.List;


@Service
public class UserDaoImp implements UserDao {

    @Autowired
    private SqlSession sqlSession;

  


    public String addUser(User user){
        sqlSession.selectOne("addUsers",user);
        return "success";
    }


    public User login(User user){
      User result=  sqlSession.selectOne("login",user);
      return result;
    }

    public List<User> showTable(int id){
        List<User>users = sqlSession.selectList("select",id);
        return users;
    }



}
