package Models;

import Controllers.UserController;

public class Session {
    public static Models.User User = null;

    public static boolean IsLoggedIn()
    {
        return User != null;
    }

}
