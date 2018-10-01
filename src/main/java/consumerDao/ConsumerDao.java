package consumerDao;


import springTest.Consumer;

import java.util.List;


public interface ConsumerDao {
    String additem(Consumer consumer);


    List<Consumer> showtable(String username);
}
