package restmethods;

import java.util.Arrays;

public class product {
	
	private String Name;
	private int Price;
	private String color;
	String sellerNames[];
	
	public product(String name, int price, String color, String[] sellerNames) {
		Name = name;
		Price = price;
		this.color = color;
		this.sellerNames = sellerNames;
	}
	
	@Override
	public String toString() {
		return "product [Name=" + Name + ", Price=" + Price + ", color=" + color + ", sellerNames="
				+ Arrays.toString(sellerNames) + "]";
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String[] getSellerNames() {
		return sellerNames;
	}
	public void setSellerNames(String[] sellerNames) {
		this.sellerNames = sellerNames;
	}

}
