import java.util.Scanner;

public class CD extends Product {
	String artist;
	int noOfSongs;
	String label;
	public CD(int number,String name,int qty,int price,String artist,int noOfSongs,String label) {
		super(number,name,qty,price);
		this.label=label;
		this.noOfSongs=noOfSongs;
		this.artist=artist;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getNoOfSongs() {
		return noOfSongs;
	}
	public void setNoOfSongs(int noOfSongs) {
		this.noOfSongs = noOfSongs;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String toString() {
		String val=this.isActive()?"Active":"Discontinued";
		String s="Item Number	:"+getItemNumber()+"\n"+"Name	:"+getProductName()+"\nArtist	:"+getArtist()+"\nSongs on Album	:"+getNoOfSongs()+"\nRecord label	:"+getLabel()+"\n"+"Quantity in Stock:"+getNoOfUnits()+"\n"+"Price	:"+getProductPrice()
				+"\nProduct Status	:"+val+"\nStock Value	:"+getInventoryValue()	;
		return s;
	}
	
	public static void addCDToInventory(Product[] cds,Scanner in) {
		int tempNumber;
		int tempPrice;
		int tempQty;
		String tempName;
		String tempArtist;
		int tempnoOfSongs;
		String templabel;
		
		for(int i=0;i<cds.length;i++) {
		 	System.out.println("Enter The Name of the CD:");
			tempName=in.next();
			System.out.println("Enter The Quantity of the CD's:");
			tempQty=in.nextInt();
			in.nextLine();//buffer
			System.out.println("Enter The Price of the CD:");
			tempPrice=in.nextInt();
			in.nextLine();//buffer
			System.out.println("Enter The Item Number of the CD:");
			tempNumber=in.nextInt();
			in.nextLine();//buffer
			System.out.println("Enter Artist of the CD:");
			tempArtist=in.next();
			System.out.println("Enter The Number of Songs in the CD:");
			tempnoOfSongs=in.nextInt();
			in.nextLine();//buffer
			System.out.println("Enter The Label of the CD:");
			templabel=in.next();
			
			
			//products[i]=new Product(tempNumber,tempName,tempQty,tempPrice);
			cds[i]=new CD(tempNumber,tempName,tempQty,tempPrice,tempArtist,tempnoOfSongs,templabel);
	 }
	}
}
