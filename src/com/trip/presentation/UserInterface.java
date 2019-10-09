package com.trip.presentation;

import com.trip.entity.User;

public interface UserInterface {

	public void showMainMenu();

	public void performOnMainMenu(int choice);
	
	public void showAdminMenu();
	
	public void showUserMenu();

	public void performOnAdminMenu(int choice, User user);
	
	public void performOnUserMenu(int choice, User user);
}
