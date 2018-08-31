package validate;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserServiceImpl;

public class userValidator {

    private static userValidator instance = new userValidator();
    public static  userValidator getInstance() {
        return instance;
    }

    private userValidator() {

        }

        public void isValidate(User user){



        }


        private boolean isPasswordMeetsRequirement(User user) throws UserShortLengthPasswordException {
            if(user.getPassword().length()<6){
                throw new UserShortLengthPasswordException(user);
            }
            else
                return true;
        }

        private boolean isLoginMeetsRequirements(User user) throws UserShortLengthLoginException {
        if(user.getLogin().length()<4){
            throw new UserShortLengthLoginException(user);
        }
        else
            return true;
        }

        private boolean isLoginExist(User user){
            //todo
        }

    }


