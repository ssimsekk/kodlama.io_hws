package eTicaretSistemi.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaretSistemi.dataAccess.abstracts.UserDao;
import eTicaretSistemi.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("Veritabanýna eklendi: " +user.getFirstName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Veritabanýnda güncellendi: " +user.getFirstName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Veritabanýndan silindi: " +user.getFirstName());
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllEMail() {
		List<String> eMailList = new ArrayList<String>();
		eMailList.add("suleyman@suleyman.com");
		eMailList.add("melis@simsek.com");
		return eMailList;
	}

}
