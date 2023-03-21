
public class Product {
	//Instance field declarations
		private String productName;
		private int productPrice;
		private int noOfUnits;
		private int itemNumber;
		private boolean active;
		//THis is default constructor helps to initialize the variables with default vlaues
		public Product() {
			productName="MS Dhoni Album";
			productPrice=350;
			noOfUnits=4;
			itemNumber=1;
			active=true;
		}
		public Product(int number,String name,int qty,int price) {
			this.productName=name;
			this.itemNumber=number;
			this.noOfUnits=qty;
			this.productPrice=price;
			this.active=true;
		}
		
		public void addToInventory(int quantity) {
			this.noOfUnits+=quantity;
		}
		
		public void deductToInventory(int quantity) {
			this.noOfUnits-=quantity;
		}
		
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		//This are getters and setters helps to access the private class varibles using accessor methods
		//And mutators methods helps to change any private fields 
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
		public int getNoOfUnits() {
			return noOfUnits;
		}
		public void setNoOfUnits(int noOfUnits) {
			this.noOfUnits = noOfUnits;
		}
		public int getItemNumber() {
			return itemNumber;
		}
		public void setItemNumber(int itemNumber) {
			this.itemNumber = itemNumber;
		}
		
		public int getInventoryValue() {
			return getProductPrice()*getNoOfUnits();
		}
		
		public String toString() {
			String val=this.isActive()?"Active":"Discontinued";
			String s="Item Number	:"+getItemNumber()+"\n"+"Name	:"+getProductName()+"\n"+"Quantity in Stock:"+getNoOfUnits()+"\n"+"Price	:"+getProductPrice()
					+"\nProduct Status	:"+val+"\nStock Value	:"+getInventoryValue()	;
			return s;
		}	
}

