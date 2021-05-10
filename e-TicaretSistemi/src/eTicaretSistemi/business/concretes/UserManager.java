package eTicaretSistemi.business.concretes;

import eTicaretSistemi.business.abstracts.UserService;
import eTicaretSistemi.core.ConfirmationEmailManager;
import eTicaretSistemi.core.GoogleLoginManagerAdapter;
import eTicaretSistemi.core.ValidatorManager;
import eTicaretSistemi.dataAccess.abstracts.UserDao;
import eTicaretSistemi.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private ConfirmationEmailManager confirmationEmailService;
	private GoogleLoginManagerAdapter googleLoginManagerAdapter;

	public UserManager(UserDao userDao, ConfirmationEmailManager confirmationEmailService) {
		super();
		this.userDao = userDao;
		this.confirmationEmailService = confirmationEmailService;
	}
	
	public UserManager(UserDao userDao, GoogleLoginManagerAdapter googleLoginManagerAdapter) {
		super();
		this.userDao = userDao;
		this.googleLoginManagerAdapter = googleLoginManagerAdapter;
	}

	@Override
	public void register(User user) {
		if(!ValidatorManager.validatePassword(user.getPassword())) {
			System.out.println("Parola en az 6 karakter olmalýdýr.");
			return;
		}
		
		if(!ValidatorManager.validateEMail(user.geteMail())) {
			System.out.println("Hatalý e-mail!");
			return;
		}
		
		if(!ValidatorManager.validateNameLenght(user.getFirstName(), user.getLastName())) {
			System.out.println("Ad-Soyad 2 karakterden kýsa olamaz!");
			return;
		}
		
		if(ValidatorManager.isUsedEMail(userDao.getAllEMail(), user.geteMail())) {
			System.out.println("E-mail daha önce kullanýlmýþ.");
			return;
		}
		
		this.confirmationEmailService.sendEMail(user.geteMail());
		if(this.confirmationEmailService.checkConfirmation()==false) {
			System.out.println("Mail adresi doðrulamasý tamamlanmadý.");
			return;
		}
		this.userDao.add(user);
		
		
		
	}

	@Override
	public void login(User user, boolean isGoogleUsed) {
		if(isGoogleUsed==true) {
		this.googleLoginManagerAdapter.login(user.geteMail(), user.getPassword());
		}else {
			System.out.println("Login olundu: " +user.getFirstName() );
		}
		
	}

	@Override
	public void logout(User user) {
		// TODO Auto-generated method stub
		
	}

}
