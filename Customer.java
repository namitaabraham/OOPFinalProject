/*
 * Fields:
totalFees = (num of days stayed * costPerNight) + roomServicePrice
int numDaysStayed
Int roomNumber
Methods:
Constructor (numDays)
getRoomService
requestRoomCleaning // call HotelRoom obj. cleanRoom()
checkOut
hotelRoom becomes vacant
checkIn (Driver.getFreeRoom)
Loop thru array of hotelRooms to find isVacant
Assign them to a vacant room (both Customer and hotelRoom objects)
-getTotalFees

 */
public class Customer {
	//fields
	double totalFees;
//	int numDaysStayed;
	int roomNumber;
	
	//constructor
	public Customer(){
		
	}
	
	public void displayInfo(){
		
	}
}
