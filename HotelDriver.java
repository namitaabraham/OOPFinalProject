
public class HotelDriver {

	public static void main(String[] args) {
		HotelRoom room1 = new HotelRoom(1, "single");
		HotelRoom[] HotelArray = new HotelRoom[5];
		HotelArray[1]= room1;
		HotelArray[1].DisplayInfo();
	}
	public int getFreeRoom(HotelRoom[] arr){
		for(int i=0; i<arr.length; i++){
			if (arr[i].isVacant){
				return arr[i].roomNumber;
			} else {
				continue;
			}
		}
		return 5;
	}
	
	public void assignRoomToCustomer(){
		System.out.println("A customer has checked in to Room "+ this.getFreeRoom(HotelArray));
	}

}
