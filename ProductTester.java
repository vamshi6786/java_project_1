import java.util.*;

public class ProductTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in=new Scanner(System.in);
		int menuChoice;
		int maxSize=getNumProducts(in);
		if(maxSize==0) {
			System.out.println("No products Required!");
		}
		else {
			 Product[] products=new Product[maxSize];
			 in.nextLine();
			 addToInventory(products,in);
			 do {
				 menuChoice=getMenuOption(in);
				 executeMenuChoice(menuChoice,products,in);
			 }while(menuChoice!=0);
		}
	}
	
	public static void addStock(Product products[],Scanner in) {
		int productChoice;
		int updateValue=-1;
		productChoice=getProductNumber(products,in);
		
		if(products[productChoice].isActive()==false) {
			System.out.println("As the active is discontinued you can't add stocsk to this products");
			return;
		}
		
		System.out.println("How many products do you want to add?");
		do {
			try {
				updateValue=in.nextInt();
				if(updateValue<0) {
					System.out.println("Incorrect Value Entered");
				}
			}
			catch(Exception e) {
				System.out.println("Incorrect Datatype Entered");
				in.nextLine();
				updateValue=-1;
			}
		}while(updateValue<0);
		products[productChoice].addToInventory(updateValue);
	}
	
	public static void addToInventory(Product[] products,Scanner in) {
		int stockChoice=-1;
		System.out.println("1: CD\r\n"
				+ "2: DVD\r\n"
				+ "Please enter the product type:");
		do {
			try {
				stockChoice=in.nextInt();
				if(stockChoice<1 || stockChoice>2) {
					System.out.println("Only numbers 1 or 2 allowed!");
				}
			}
			catch(Exception e) {
				System.out.println("Invalid Data Type");
				in.nextLine();
				stockChoice=-1;
			}
		}while(stockChoice<1 || stockChoice>2);
		
		switch(stockChoice) {
		case 1:CD.addCDToInventory(products,in);
				break;
		case 2:DVD.addDVDToInventory(products,in);
			break;		
		}
	}
	
	
	public static void discontinueInventory(Product products[],Scanner in) {
		int productChoice;
		productChoice=getProductNumber(products,in);
		products[productChoice].setActive(false);
	}
	
	
	
	public static void deductStock(Product products[],Scanner in) {
		int productChoice;
		int updateValue=-1;
		productChoice=getProductNumber(products,in);
		System.out.println("“How many products do you want to deduct?");
		do {
			try {
				updateValue=in.nextInt();
				if(updateValue<0) {
					System.out.println("Incorrect Value Entered");
				}
			}
			catch(Exception e) {
				System.out.println("Incorrect Datatype Entered");
				in.nextLine();
				updateValue=-1;
			}
		}while(updateValue<0);
		products[productChoice].deductToInventory(updateValue);
	}
	
	
	public static void displayInventory(Product[] products) {
		for(Product temp:products) {
			System.out.println(temp.toString());
			System.out.println();
		}
	}
	
	public static void executeMenuChoice(int menuChoice,Product products[],Scanner in) {
		switch(menuChoice) {
		case 1:displayInventory(products);
				break;
		case 2:addStock(products,in);
				break;
		case 3:deductStock(products,in);
				break;
		case 4:discontinueInventory(products,in);
				break;
		}
	}
	
	public static int getNumProducts(Scanner in) {
		int maxSize=-1;
		System.out.println("Enter the number of products you would like to add\r\n"
				+ " Enter 0 (zero) if you do not wish to add products");
		do {
			try {
				maxSize=in.nextInt();
				if(maxSize<0) {
					System.out.println("Incorrect Value Entered");
				}
			}
			catch(Exception e) {
				System.out.println("Incorrect Datatype Entered");
				in.nextLine();
				maxSize=-1;
			}
		}while(maxSize<0);
		return maxSize;
	}
	
	public static int getMenuOption(Scanner in) {
		
		System.out.println("1.View Inventory\r\n"
				+ "2. Add Stock\r\n"
				+ "3. Deduct Stock\r\n"
				+ "4. Discontinue Product\r\n"
				+ "0. Exit\r\n"
				+ "Please enter a menu option:");
		
		int choice=-1;
		do {
			try {
				choice=in.nextInt();
				if(choice<0 || choice>4) {
					System.out.println("Number is out of required range");
				}
			}
			catch(Exception e) {
				in.nextLine();
				System.out.println("Invalid datatype");
				choice=-1;
			}
		}while(choice <0 || choice >4);
		return choice;
	}
	
	public static int getProductNumber(Product products[],Scanner in) {
		for(int i=0;i<products.length;i++) {
			System.out.println("Ind:"+i+",Product name:"+products[i].getProductName());
		}
		int productChoice=-1;
		do {
			try {
				productChoice=in.nextInt();
				if(productChoice<0 || productChoice>(products.length-1)) {
					System.out.println("Incorrect Value Entered");
				}
			}
			catch(Exception e) {
				System.out.println("Incorrect Datatype Entered");
				in.nextLine();
				productChoice=-1;
			}
		}while(productChoice<0 || productChoice>(products.length-1));
		
		return productChoice;
	}
}
