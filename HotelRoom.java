/* Michael Scott Paper Company
 * Sarah Ahmed sa1145
 * Namita Abraham
 * Michael Epstein
 * HotelRoom class
 */
public class HotelRoom {
	//fields
	int roomNumber;
	String roomType;  //single, double, triple
	boolean isVacant;
	double costPerNight;
	double roomServiceFee = 50;
	String customerName = "";

	
	//Constructor
	public HotelRoom(int num, String type){
		roomNumber = num;
		roomType = type;
		if (roomType.equals("single")) costPerNight = 100.00;
		else if (roomType.equals("double")) costPerNight = 150.00;
		else costPerNight = 200.00;
		isVacant= true;
	}
	
	//when a customer checks out
	public void cleanRoom(){
		System.out.println("Room "+ roomNumber+ " has been cleaned.");
	}
	
	public void DisplayInfo(){ //FIX FORMATING
		System.out.printf("Room: %19s\n", this.roomNumber);
		System.out.printf("Room type: %14s\n", this.roomType);
		System.out.printf("Cost per night:   $%3.2f\n",this.costPerNight);
		System.out.print("Room status:       ");
		if (isVacant) System.out.println("Vacant\n");
		else {
			System.out.println("Occupied\n");
		}
	}
	
public void toggleVacancy(){
		if(this.isVacant){
			isVacant= false;
			System.out.println("Room " +this.roomNumber+" is now occupied.");
		} else{
			isVacant= true;
			System.out.println("Room " +this.roomNumber+" is now vacant.");
		}
	}
	
}
