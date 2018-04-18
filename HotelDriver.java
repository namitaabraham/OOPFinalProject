//add scanner, read user input to test all methods, add exceptions
import java.util.Scanner;

public class HotelDriver {

	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
	
		HotelRoom[] HotelArray = new HotelRoom[10];
		HotelRoom room1 = new HotelRoom(1, "single");
		HotelRoom room2 = new HotelRoom(2, "double");
		HotelRoom room3 = new HotelRoom(3, "triple");
		HotelRoom room4 = new HotelRoom(4, "single");
		HotelRoom room5 = new HotelRoom(5, "double");
		HotelRoom room6 = new HotelRoom(6, "triple");
		HotelRoom room7 = new HotelRoom(7, "single");
		HotelRoom room8 = new HotelRoom(8, "double");
		HotelRoom room9 = new HotelRoom(9, "triple");
		HotelRoom room10 = new HotelRoom(10, "single");
		
		HotelArray[0]= room1;
		HotelArray[1]= room2;
		HotelArray[2]= room3;
		HotelArray[3]= room4;
		HotelArray[4]= room5;
		HotelArray[5]= room6;
		HotelArray[6]= room7;
		HotelArray[7]= room8;
		HotelArray[8]= room9;
		HotelArray[9]= room10;
		
		while(true){
			
			System.out.println("New or returning customer?");

			String answer = console.next(); 

			if(answer.equalsIgnoreCase("new")){
				newCustomer(HotelArray);
			} else {
				returningCustomer(HotelArray);
			}
		}
		
	}
	
	
	public static void returningCustomer(HotelRoom[] arr){
		Scanner console = new Scanner(System.in); 
		int roomNum = 0;
		System.out.println("What is your name?");
		String cusName = console.next(); 
		for(int i=0; i<arr.length; i++){
			if( arr[i].customerName.equals(cusName)){
				roomNum = i +1;
			} else {
				continue;
			}
		}
		System.out.println("Are you ready to check out? y/n");
		String checkOutAnswer = console.next();
		if (checkOutAnswer.equalsIgnoreCase("Y")) {
			getTotalBill(cusName, arr);
			customerCheckOut(cusName, arr);
			return;
		} else {
			return;
		}
	}
	
	public static void newCustomer(HotelRoom[] arr){
		Scanner console = new Scanner(System.in);
		System.out.println("What is your name?");
		String cusName = console.next();
		System.out.println("What type of room would you like? (single, double, or triple)");
		String rmType = console.next();
		//add exceptions later
		assignRoomToCustomer(cusName, rmType, arr);
		
		
		//ask customer about room service
//		System.out.println("Would you like room service?");
		
		//ask customer is ready to check out-- if yes, call method to print total bill, call customerCheckOut
		System.out.println("Are you ready to check out? y/n");
		String checkOutAnswer = console.next();
		if (checkOutAnswer.equalsIgnoreCase("Y")) {
			getTotalBill(cusName, arr);
			customerCheckOut(cusName, arr);
			return;
		} else {
			return;
		}
		
	}

	public static void assignRoomToCustomer(String CustomerName, String roomType, HotelRoom[] arr){
		int freeRoom = -1;
		for(int i=0; i<arr.length; i++){
			if (arr[i].isVacant && arr[i].roomType.equals(roomType)){
					freeRoom= i;
					break;
			}
			 else {
				continue;
			}
		}
		if (freeRoom == -1) {
			System.out.println("There are no rooms available.");
			return;
		}
			//add customer name to this room
		arr[freeRoom].customerName = CustomerName;
		System.out.println(CustomerName+" is now in Room "+ (freeRoom+1)+".");
				//toggle vacancy
		arr[freeRoom].toggleVacancy();
	}
	
	public static void customerCheckOut(String cusName, HotelRoom[] arr){
		int roomNum=0;
		for(int i=0; i<arr.length; i++){
			if( arr[i].customerName.equals(cusName)){
				roomNum = i +1;
			} else {
				continue;
			}
		}
		//toggle vacancy
		arr[roomNum-1].toggleVacancy();
		System.out.println(arr[roomNum-1].customerName + " has checked out.");
		//erase customerNAme from room
		arr[roomNum-1].customerName = "";
		return;
	}
	
	public static void getTotalBill(String cusName, HotelRoom[] arr){
		Scanner console = new Scanner(System.in);
		System.out.println("How many days did you stay?");
		int daysStayed= console.nextInt();
		
		int roomNum=0;
		for(int i=0; i<arr.length; i++){
			if( arr[i].customerName.equals(cusName)){
				roomNum = i +1;
			} else {
				continue;
			}
		}
		double bill = (daysStayed * arr[roomNum-1].costPerNight) + arr[roomNum-1].roomServiceFee;
	//if roomService called
		System.out.println("Your total bill is: $"+ bill); //use printf for formatting (complexity)
		
	}

}
