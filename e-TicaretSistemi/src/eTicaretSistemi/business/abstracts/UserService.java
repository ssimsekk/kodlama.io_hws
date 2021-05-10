package eTicaretSistemi.business.abstracts;

import eTicaretSistemi.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(User user, boolean isGoogleUsed);
	void logout(User user);
}
