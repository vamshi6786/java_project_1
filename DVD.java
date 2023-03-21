import java.util.*;

public class DVD extends Product {
	int lenInMin;
	int ageRating;
	String FilmStudio;
	public DVD(int number,String name,int qty,int price,int length,int rating,String Fstudio) {
		super(number,name,qty,price);
		this.ageRating=rating;
		this.FilmStudio=Fstudio;
		this.lenInMin=length;
	}
	
	public int getLenInMin() {
		return lenInMin;
	}
	public void setLenInMin(int lenInMin) {
		this.lenInMin = lenInMin;
	}
	public int getAgeRating() {
		return ageRating;
	}
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}
	public String getFilmStudio() {
		return FilmStudio;
	}
	public void setFilmStudio(String filmStudio) {
		FilmStudio = filmStudio;
	}
	
	public int getInventoryValue() {
		//As i took integer i am making multiply by 2 else i need to take it as 1.05
		return (2)*this.getProductPrice()*this.getNoOfUnits();
	}
	
	public String toString() {
		String val=this.isActive()?"Active":"Discontinued";
		String s="Item Number	:"+getItemNumber()+"\n"+"Name	:"+getProductName()+"\nMovie Length:"+getLenInMin()+"\nAge Rating:"+getAgeRating()+"\nFilm Studio:"+getFilmStudio()+"\n"+"Quantity in Stock:"+getNoOfUnits()+"\n"+"Price	:"+getProductPrice()
				+"\nProduct Status	:"+val+"\nStock Value	:"+getInventoryValue()	;
		return s;
	}
	
	public static void addDVDToInventory(Product[] dvds,Scanner in) {
		int tempNumber;
		int tempPrice;
		int tempQty;
		String tempName;
		int templenInMin;
		int tempageRating;
		String tempFilmStudio;
		
		for(int i=0;i<dvds.length;i++) {
		 	System.out.println("Enter The Name of the DVD:");
			tempName=in.next();
			System.out.println("Enter The Quantity of the DVD's:");
			tempQty=in.nextInt();
			in.nextLine();//buffer
			System.out.println("Enter The Price of the DVD:");
			tempPrice=in.nextInt();
			in.nextLine();//buffer
			System.out.println("Enter The Item Number of the DVD:");
			tempNumber=in.nextInt();
			in.nextLine();//buffer
			System.out.println("Enter Length of Movie in the DVD:");
			templenInMin=in.nextInt();
			in.nextLine();//buffer
			System.out.println("Enter The Age Rating of the movie in DVD:");
			tempageRating=in.nextInt();
			in.nextLine();//buffer
			System.out.println("Enter The Film Studio of the Movie:");
			tempFilmStudio=in.next();
			
			
			//products[i]=new Product(tempNumber,tempName,tempQty,tempPrice);
			dvds[i]=new DVD(tempNumber,tempName,tempQty,tempPrice,templenInMin,tempageRating,tempFilmStudio);
	 }
	}
}
