package eTicaretSistemi.core;

public class ConfirmationEmailManager {
	public void sendEMail(String eMail) {
		System.out.println("Do�rulama linki " +eMail + " adresine g�nderildi.");
	}
	
	public boolean checkConfirmation() {
		return true;
	}
}
