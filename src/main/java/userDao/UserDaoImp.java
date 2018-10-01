package userDao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.User;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Service
public class UserDaoImp implements UserDao {


    private SqlSession sqlSession;

    @Autowired
    public void setSqlSessionFactory(SqlSession sqlSession){

        this.sqlSession =sqlSession;
    }


    public String addUser(User user){
        sqlSession.selectOne("addUsers",user);
        return "ok";
    }


    public String login(User user){
       if(sqlSession.selectOne("login",user)!=null) {
           return "ok";
       }else {
           return "false";
       }
    }



}
