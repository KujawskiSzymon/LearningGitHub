package entity.parser;

import entity.Product;
import entity.User;

public class UserParser {
    public static User stringToUser(String userstr){
        String [] userInformations = userstr.split(User.USER_SEPARATOR);
        Long id = Long.parseLong(userInformations[0]) ;
        String login=userInformations[1];
        String passwd=userInformations[2];
        return new User(id,login,passwd);
    }
}
