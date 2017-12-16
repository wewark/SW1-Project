package Controllers;

import Models.Session;
import Models.User;

import java.util.HashMap;

public class UserController {
	public Models.User user;

	public static boolean register(HashMap<String, String> userData) {
		if (User.exists(userData.get("username"))) return false;
		User.addUser(new User(userData));
		return true;
	}
	
	public static boolean login(String username, String password) {
		if (User.exists(username)) {
			User tmp = User.getUser(username);
			if (tmp.passwordHash.equals(password)) {
				//Save to Session
				Session.User = tmp;
				return true;
			}
		}
		return false;
	}

	public static boolean logout()	{
		Session.User = null;
		return true;
	}

	//	public void setProfilePicture(Image image) {
	//
	//	}
	//
	//	public void updateProfileInfo(Profile profile) {
	//
	//	}
}
