package exception;

import entity.User;

public class UserShortLengthPasswordException extends Exception {
    public UserShortLengthPasswordException(User user) {
    }

    public UserShortLengthPasswordException(String message) {
        super(message);
    }
}
