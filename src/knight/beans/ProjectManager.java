package knight.beans;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.component.html.HtmlInputText;
import javax.faces.model.ListDataModel;
import knight.model.DataManager;

public class ProjectManager {

	private Food food;
	private List<Food> foods;
	private ListDataModel<List<Food>> foodsDataModel = new ListDataModel<List<Food>>();
	private ListDataModel<CartItem> cartItems = new ListDataModel<CartItem>();
	private ListDataModel<Category> categoriesDataModel = new ListDataModel<Category>();
	private String        categoryName;
	  private Customer      customer;
	  private DataManager   dataManager = new DataManager();
	  private long          orderId;
	  private double        orderTotal;
	  private HtmlInputText searchTxt = new HtmlInputText();
	  private Hashtable<String, CartItem>
	                        shoppingCart = new Hashtable<String, CartItem>();
	  
	public String addToCart() {
		CartItem item = shoppingCart.get(food.getId());
		if (item == null) {
			item = new CartItem(food, 1);
			shoppingCart.put(food.getId(), item);
		}
		else {
			item.setQuantity(item.getQuantity()+1);
		}
		return "showCart";
	}
	
	public String checkOut() {
		orderId = dataManager.insertOrder(customer, shoppingCart);
		if (orderId != 0) {
			customer = null;
			shoppingCart.clear();
		}
		return "orderConfirmation";
	}
	
	public String deleteItem() {
		CartItem item = (CartItem)cartItems.getRowData();
		shoppingCart.remove(item.getFoodID());
		return null;
	}

	public Food getFood() {
		return food;
	}
	
	public ListDataModel<List<Food>> getFoods() {
	    if (foods == null) {
	      foodsDataModel.setWrappedData(new LinkedList<Food>());
	      }
	    else {
	      foodsDataModel.setWrappedData(foods);
	      }
	    return foodsDataModel;
	    }
	
	public ListDataModel<Category> getCategories() {
	    categoriesDataModel.setWrappedData(dataManager.getCategories());
	    return categoriesDataModel;
	    }

	public String getCategoryName() {
		return categoryName;
	}
	
	public String getCustomerName() {
	    return getCustomer().getCustomerName();
	    }

	public Customer getCustomer() {
	    if (customer == null) {
	      customer = new Customer();
	      }
	    return customer;
	    }
	
	public String getOrderId() {
	    if (orderId == 0) return "";
	    return Long.toHexString(orderId).toUpperCase();
	    }
	
	 public double getOrderTotal() {
		    orderTotal = 0.;
		    Enumeration<CartItem> items = shoppingCart.elements();
		    while (items.hasMoreElements()) {
		      orderTotal += items.nextElement().getSubtotal();
		      }
		    orderTotal = Math.round(orderTotal*100.)/100.;
		    return orderTotal;
		    }
	 
	 public HtmlInputText getSearchTxt() {
		    return searchTxt;
		    }
	 
	 public ListDataModel<CartItem> getShoppingCart() {
		    ArrayList<CartItem> itemList =
		        new ArrayList<CartItem>(shoppingCart.values());
		    cartItems.setWrappedData(itemList);
		    return cartItems;
		    }
	 
	 public boolean isShoppingCartEmpty() {
		    return shoppingCart.isEmpty();
		    }
	 
	 public String searchFoods() {
		 categoryName = null;
		 String searchKeyword = (String)searchTxt.getSubmittedValue();
		 foods = (List<Food>)dataManager.getSearchResults(searchKeyword);
		 return "listFoods";
	 }
	 
	 public String selectFood() {
		    food = (Food)foodsDataModel.getRowData();
		    return "showFood";
		    }
	 
	 public String selectCategory() {
		    Category category = (Category)categoriesDataModel.getRowData();
		    categoryName = category.getName();
		    foods = (List<Food>)dataManager.getFoodsInCategory(
		    		  Integer.toString(category.getId())
		    		  );
		    return "listFoods";
		    }
	 
	 public void setCustomerName(String customerName) {
		 getCustomer().setCustomerName(customerName);
	 }
	 
	 public void setCustomer(Customer order) {
		 this.customer = order;
	 }
	 
	 public void setSearchTxt(HtmlInputText val) {
		    searchTxt = val;
		    }

	 public String updateItem() {
		    return null;
		    }
	 
	 
}
