package eTicaretSistemi;

import eTicaretSistemi.business.concretes.UserManager;
import eTicaretSistemi.core.ConfirmationEmailManager;
import eTicaretSistemi.core.GoogleLoginManagerAdapter;
import eTicaretSistemi.dataAccess.concretes.HibernateUserDao;
import eTicaretSistemi.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "Süleyman", "Simsek", "melis@suleyman.com", "123456");
		User user1 = new User(2, "Melis", "Simsek", "melis@gmail.com", "987654");
		
		UserManager userManager = new UserManager(new HibernateUserDao(), new ConfirmationEmailManager());
		userManager.register(user);
		userManager.login(user, false);
		UserManager userManager2 = new UserManager(new HibernateUserDao(), new GoogleLoginManagerAdapter());
		userManager2.login(user1, true);
	}

}
