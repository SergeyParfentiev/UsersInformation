package engine;

import java.util.List;

public interface UserDAO {
    void add(User user);
    List<User> users();
}
