package api;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {
    void saveUser(User user) throws IOException;
    void saveUsers(List<User> users ) throws FileNotFoundException;
    void removeUserById(Long id)throws IOException;
    void removerUserByName(String username)throws IOException;
    List<User>getAllUsers()throws IOException;
    User getUserById(Long id) throws IOException;
    User getUserByName(String name) throws IOException;
}
