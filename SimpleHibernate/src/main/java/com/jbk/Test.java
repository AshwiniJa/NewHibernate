package com.jbk;

import java.util.List;
import java.util.Scanner;

import com.jbk.entity.User;
import com.jbk.service.Service;

public class Test {

	public static void main(String[] args) {

		Service service = new Service();
		User user = new User();

		Scanner scanner = new Scanner(System.in);
		int choice;
		char ch;

		do {
			System.out.println("1.Save User");
			System.out.println("2.Get User By Id");
			System.out.println("3.Update User");
			System.out.println("4.List of User");
			System.out.println("5.List of User By (ASC-By Name) ");
			choice = scanner.nextInt();
			switch (choice) {

			case 1:
				user = service.prepareUser();
				String msg = service.saveUser(user);
				System.out.println(msg);
				break;

			case 2:
				System.out.println("Enter Id");
				int id = scanner.nextInt();

				User userId = service.getUserById(id);
				System.out.println(userId);
				break;

			case 3:
				user = service.prepareUser();
				String msg1 = service.updateUser(user);
				System.out.println(msg1);
				break;

			case 4:

				List<User> users = service.listOfUser();
				for (User u : users) {
					System.out.println(u);
				}
				break;

			case 5:
				List<User> u = service.listOfUser_ASC_Name();
				for (User uu : u) {
					System.out.println(uu);
				}
				break;
			
			case 6:
				System.out.println("Enter Salary");
				double salary=scanner.nextInt();
				List<User> u1 = service.maxSalaryUsers(salary);
				for (User uu : u1) {
					System.out.println(uu);
				}
				break;

			default:
				System.out.println("Invalid Choice");
				break;

			}
			System.out.println("Do you Want to Continue:y/n");
			ch = scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

		System.out.println("Yes Did It!!!!!!!!");

	}
}