package api2;

public interface Message {
	String print();
	String message();
	//////////////	추가	////////////////////
	void searchMember();
	void searchIdMember();
	void searchAddress(String addr);
}