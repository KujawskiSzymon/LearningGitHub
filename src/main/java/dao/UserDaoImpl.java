package dao;

import api.UserDao;
import entity.User;
import entity.parser.UserParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    String filename;
    public UserDaoImpl(String filename){
        this.filename = filename;
    }

    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    public void saveUsers(List<User> users) {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(filename,true));
        for(User user: users){
            printWriter.write(user.toString()+"\n");
        }
        printWriter.close();

    }

    public void removeUserById(Long id) throws IOException {
        List<User> users = getAllUsers();
        for(int i=0;i<users.size();i++){
            boolean isFound = users.get(i).getId().equals(id);
            if(isFound){
                users.remove(i);
            }
        }
        saveUsers(users);

    }

    public void removerUserByName(String username) throws IOException {
        List<User> users = getAllUsers();
        for(int i=0;i<users.size();i++){
            boolean isFound = users.get(i).getLogin().equals(username);
            if(isFound){
                users.remove(i);
            }
        }
        saveUsers(users);
    }

    public List<User>  getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String readline = bufferedReader.readLine();
        while(readline!=null){
            User user = UserParser.stringToUser(readline);
            if(user!=null)
                users.add(user);

        }
    bufferedReader.close();
        return users;
    }

    public User getUserById(Long id) throws IOException {
        List<User> users = getAllUsers();
        for(User user: users){
            Boolean isFound = user.getId().equals(id);
            if(isFound){
                return user;
            }
        }
        return null;
    }

    public User getUserByName(String name) throws IOException {
        List<User> users = getAllUsers();
        for(User user: users){
            Boolean isFound = user.getLogin().equals(name);
            if(isFound){
                return  user;
            }
        }
        return null;

    }
}
