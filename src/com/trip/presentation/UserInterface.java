package com.trip.presentation;

public interface UserInterface {

	public void showMainMenu();

	public void performOnMainMenu(int choice);
	
	public void showAdminMenu();
	
	public void showUserMenu();

	public void performOnAdminMenu(int choice);
	
	public void performOnUserMenu(int choice);
}
