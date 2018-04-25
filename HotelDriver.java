//add exceptions and comments, maybe some new methods
/* Michael Scott Paper Company
 * Sarah Ahmed sa1145
 * Namita Abraham
 * Michael Epstein
 * This is a class that runs the Hotel Management program. 
 * */
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
			
			System.out.println("Please select an option: (enter letter only)");
			System.out.println("A: See Room Information");
			System.out.println("B: New customer");
			System.out.println("C: Returning customer");
			System.out.println("D: End program");
			
			String answer = console.next(); 
			
			if (answer.equalsIgnoreCase("D")) return;
			while (!(answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B")|| answer.equalsIgnoreCase("C"))){
				System.out.println("Please enter \'A\', \'B\', \'C\', or \'D\':" );
				answer = console.next();
			}
			if (answer.equalsIgnoreCase("A")){
				seeRoomInfo(HotelArray);
			} else if(answer.equalsIgnoreCase("B")){
				newCustomer(HotelArray);
			} else {
				returningCustomer(HotelArray);
			} 
		}
		
	}
	
	public static void seeRoomInfo(HotelRoom[] arr){
		Scanner console = new Scanner(System.in); 
		System.out.println("Which room would you like to learn about? Please enter the room number: ");
		int roomNum = console.nextInt();
		if (roomNum > arr.length) {
			System.out.println("There are only "+ arr.length+ " rooms in this hotel.");
			return;
		}
		arr[roomNum-1].DisplayInfo();
	}
	
	
	public static void returningCustomer(HotelRoom[] arr){
		Scanner console = new Scanner(System.in); 
		int roomNum = 0;
		System.out.println("What is your name?");
		String cusName = console.next(); 
		for(int i=0; i<arr.length; i++){
			if( arr[i].customerName.equalsIgnoreCase(cusName)){
				roomNum = i +1;
			} else {
				continue;
			}
		} 
		//ADD SOMETHING IF CUSTOMER NAME IS NOT FOUND. "You are not in our files. Please try again." or something
		
		System.out.println("Are you ready to check out? y/n");
		String checkOutAnswer = console.next();
		while (!(checkOutAnswer.equalsIgnoreCase("Y") || checkOutAnswer.equalsIgnoreCase("N"))) {
			System.out.println("Please print Y or N: ");
			checkOutAnswer = console.next();
		}
		if (checkOutAnswer.equalsIgnoreCase("Y")) {
			getTotalBill(cusName, arr);
			customerCheckOut(cusName, arr);
			return;
		} 
		
		System.out.println("Would you like to have your room cleaned? y/n");
		String cleaningAnswer = console.next();
		while (!(cleaningAnswer.equalsIgnoreCase("Y") || cleaningAnswer.equalsIgnoreCase("N"))) {
			System.out.println("Please print Y or N: ");
			cleaningAnswer = console.next();
		}
		if (cleaningAnswer.equalsIgnoreCase("Y")) {
			arr[roomNum].cleanRoom();
			return;
		} 
			
			return;
		
	}
	
	public static void newCustomer(HotelRoom[] arr){
		Scanner console = new Scanner(System.in);
		System.out.println("What is your name?");
		String cusName = console.next();
		System.out.println("What type of room would you like? (single, double, or triple)");
		String rmType = console.next();
//		while (!(rmType.equalsIgnoreCase("single")|| rmType.equalsIgnoreCase("double") || rmType.equalsIgnoreCase("triple"))){
//			System.out.println("Please enter a valid room type: (single, double or triple)");
//			rmType = console.next();
//		}
		assignRoomToCustomer(cusName, rmType, arr);
		
	}

	public static void assignRoomToCustomer(String CustomerName, String roomType, HotelRoom[] arr){
		int freeRoom = -1;
		for(int i=0; i<arr.length; i++){
			if (arr[i].isVacant && arr[i].roomType.equalsIgnoreCase(roomType)){
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
		System.out.println(CustomerName+" is now in Room "+ (freeRoom+1)+". It is a "+ arr[freeRoom].roomType+ " room.");
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
		System.out.println(arr[roomNum-1].customerName + " has checked out.");
		arr[roomNum-1].cleanRoom();
		
		//toggle vacancy
		arr[roomNum-1].toggleVacancy();
		
		//erase customerName from room
		arr[roomNum-1].customerName = "";
		return;
	}
	
	public static void getTotalBill(String cusName, HotelRoom[] arr){
		Scanner console = new Scanner(System.in);
		System.out.println("How many days did you stay? Please enter a postive integer.");
		int daysStayed= console.nextInt();
		//add exception or while loop to make sure input is an integer and greater than zero
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
