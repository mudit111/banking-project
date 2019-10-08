package com.trip.util;

import java.util.Scanner;

import com.trip.entity.User;

public class UserHelper {
	public static User userInput() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your ID:");
			String id = scanner.next();
			System.out.println("Enter your Name:");
			String name = scanner.next();
			System.out.println("Enter your Age:");
			int age = scanner.nextInt();
			System.out.println("Enter the password of your choice:");
			String password = scanner.next();
			String type = "user";
			User user = new User(id,name,age,type,password);
			return user;
	}
}
