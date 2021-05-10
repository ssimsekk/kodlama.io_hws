package eTicaretSistemi.core;

public class ConfirmationEmailManager {
	public void sendEMail(String eMail) {
		System.out.println("Doðrulama linki " +eMail + " adresine gönderildi.");
	}
	
	public boolean checkConfirmation() {
		return true;
	}
}
