package consumerDao;

import consumerDao.ConsumerDao;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springTest.Consumer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Service
public class ConsumerDaoImp implements ConsumerDao {


    private SqlSession sqlSession;

    @Autowired
    public void setSqlSessionFactory(SqlSession sqlSession){

        this.sqlSession =sqlSession;
    }


    public String additem(Consumer consumer) {



        sqlSession.selectOne("additem",consumer);

        return "success";
    }

    public List<Consumer> showtable(String username){
        System.out.println("test showtable");
       List<Consumer> consumers=sqlSession.selectList("showtable",username);
       if(consumers!=null){
           System.out.println("success to showtable");
           return consumers;
       }else {
           return consumers;
       }

    }


}
