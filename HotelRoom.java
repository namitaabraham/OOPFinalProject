/* Michael Scott Paper Company
 * Sarah Ahmed sa1145
 * Namita Abraham na126
 * Michael Epstein mae133
 * HotelRoom class. This class is for HotelRoom objects.
 */
public class HotelRoom {
	//fields
	int roomNumber;
	String roomType;  //single, double, triple
	boolean isVacant;
	double costPerNight;
	double roomServiceFee = 50; //standard service fee for every room booking.
	String customerName = "";

	
	/**
	 * Constructor. This constructs a HotelRoom Object.
	 * @param num Room Number
	 * @param type Type of room (single, double, or triple)
	 */
	public HotelRoom(int num, String type){
		roomNumber = num;
		roomType = type;
		if (roomType.equals("single")) costPerNight = 100.00;
		else if (roomType.equals("double")) costPerNight = 150.00;
		else costPerNight = 200.00;
		isVacant= true;
	}
	
	/**
	 * This method is called when a customer wants their room cleaned, or when a customer checks out.
	 */
	public void cleanRoom(){
		System.out.println("Room "+ roomNumber+ " has been cleaned.");
	}
	
	/**
	 * This method displays the information HotelRoom object, including: room number, room type, cost per night, and room status
	 *
	 **/
	
	public void DisplayInfo(){ 
		System.out.printf("Room: %19s\n", this.roomNumber);
		System.out.printf("Room type: %14s\n", this.roomType);
		System.out.printf("Cost per night:   $%3.2f\n",this.costPerNight);
		System.out.print("Room status:     ");
		if (isVacant) System.out.println("  Vacant\n");
		else {
			System.out.println("Occupied\n");
		}
	}
	
	
/**
 * This method checks whether or not a room is vacant. Then it reverses the vacancy status of the room (boolean isVacant)
 */
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
