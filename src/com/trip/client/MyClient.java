package com.trip.client;

import java.util.Scanner;

import com.trip.presentation.UserInterface;
import com.trip.presentation.UserInterfaceImpl;

public class MyClient {

	public static void main(String args[]) {
		UserInterface userInterface = new UserInterfaceImpl();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			userInterface.showMenu();
			System.out.println("Enter Choice : ");
			int choice = scanner.nextInt();
			userInterface.performOnMenu(choice);
		}
	}
}
