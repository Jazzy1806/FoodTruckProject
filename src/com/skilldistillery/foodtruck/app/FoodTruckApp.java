package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;
import java.util.Scanner;

public class FoodTruckApp {

		static Scanner scan = new Scanner(System.in);
		public static void main(String[] args) {
			FoodTruckApp app = new FoodTruckApp();
			app.run();
		}
		
		public void run() {
			FoodTruck[] fleet = new FoodTruck[5];
			
			System.out.println("When you've entered all of the food trucks, type \"quit\" to see the option menu.");
			for (int counter = 0; counter <= 4; counter++) {
				fleet[counter] = addFoodTruck();
				if (fleet[counter] == null) {
					break;
				}
			}
			if (fleet[4] != null) {
				System.out.println("\n\nWhoops! You can only add 5 food trucks at a time.");
			}
			menu(fleet);
		}
		
		public FoodTruck addFoodTruck() {
			FoodTruck truck = null;

			System.out.println("\nEnter the name of the food truck?");
			String truckName = scan.nextLine();
			
			if (!truckName.equals("quit")) {
				System.out.println("What type of food is it? ");
				String foodType = scan.nextLine();
				
				System.out.println("On a scale of 1 - 5, with 1 being the worst and 5 being the best, how would you rate this food truck? ");
				int truckRating = scan.nextInt();
				
				while (truckRating > 5) {
						System.out.println("That's not a valid rating. Enter a rating between 1 and 5: ");
						truckRating = scan.nextInt();
				}
				scan.nextLine(); //Refresh the scanner
				truck = new FoodTruck(truckName, foodType, truckRating);
			}
			return truck;
		}
		
		public void menu(FoodTruck[] fleet) {
			if (fleet[0] == null) {
				System.out.println("You didn't enter any food trucks.");
				System.out.println("\nTo end the program, type \"quit\". \nPress <Enter> to restart.");
				String response = scan.nextLine();
				if (response.toLowerCase().equals("quit")) {
					quit();
				}
				run();
			}
			
			boolean keepGoing = true;
			
			while(keepGoing) {
				System.out.println("\nWhat would you like to do? \n");
				System.out.println("List all existing food trucks: type \"list\"" +
								 "\nSee the average rating of food trucks: type \"average\"" +
								 "\nDisplay the highest-rated food truck: type \"best\"" +
								 "\nQuit the program: type \"quit\"");
				String selection = (scan.nextLine()).toLowerCase();
				while (true) {
					if (!selection.equals("list") && !selection.equals("average") &&
						!selection.equals("best") && !selection.equals("quit")) {
							System.out.println("Hmm... that's not an option. What would you like to do? ");
							selection = (scan.nextLine()).toLowerCase();
					}
					break;
				}
				switch (selection) {
					case "list": listAllTrucks(fleet); break;
					case "average": averageRating(fleet); break;
					case "best": highestRating(fleet); break;
					default: quit(); keepGoing = false;
				}
			}
		}
		
		public void listAllTrucks(FoodTruck[] fleet) {
			for (FoodTruck truck : fleet) {
				if (truck != null) {
					System.out.println(truck);
				}
			}
		}
		
		private void averageRating(FoodTruck[] fleet) {
			int totalRatings = 0;
			int numberOfTrucks = 0;
			
			for (FoodTruck truck : fleet) {
				if (truck != null) {
					totalRatings += truck.getTruckRating();
					numberOfTrucks++;
				}
			}
			double average = (double) totalRatings/numberOfTrucks;
			System.out.println("Average Rating: " + average);
		}
		
		private void highestRating(FoodTruck[] fleet) {
			int highestRating = 0;
			String bestTruck = null;
			
			for (FoodTruck truck : fleet) {
				if (truck != null && truck.getTruckRating() > highestRating) {
					highestRating = truck.getTruckRating();
					bestTruck = truck.toString();
				}
			}
			System.out.println("Best Truck: " + bestTruck);
		}
		
		private void quit() {
			System.out.println("Thanks-have a good day!");
			scan.close();
			System.exit(0);
		}
	}
