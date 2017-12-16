package Controllers;

import Models.Admin;
import Models.Session;
import Models.StoreOwner;
import Models.User;

import java.util.HashMap;

public class UserController {
	public Models.User user;

	public static boolean register(HashMap<String, String> userData) {
		if (User.exists(userData.get("username"))) return false;
		String type = userData.get("type").toLowerCase();
		if(type.equals("user"))
			User.addUser(new User(userData));
		else if(type.equals("storeowner"))
			User.addUser(new StoreOwner(userData));
		else if(type.equals("admin"))
			User.addUser(new Admin(userData));
		else return false;
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
