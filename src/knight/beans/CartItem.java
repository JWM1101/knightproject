package knight.beans;

public class CartItem {

	private String description;
	private String name;
	private double price;
	private String foodID;
	private int quantity;
	private double subtotal;
	
public CartItem(Food food, int quantity) {
	foodID =food.getId();
	name = food.getName();
	description = food.getDescription();
	price = food.getPrice();
	this.quantity = quantity;
	subtotal = Math.round(price*quantity*100.)/100.;
}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
		subtotal = Math.round(price*quantity*100.)/100.;
	}
	
	
	public String getFoodID() {
		return foodID;
	}
	public void setFoodID(String foodID) {
		this.foodID = foodID;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		subtotal = Math.round(price*quantity*100.)/100.;
	}
	
	
	public double getSubtotal() {
		return subtotal;
	}
	
	
	
}
