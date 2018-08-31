package exception;

import entity.User;

public class UserShortLengthLoginException extends Exception {
    public UserShortLengthLoginException(User user) {
    }

    public UserShortLengthLoginException(String message) {
        super(message);
    }
}
