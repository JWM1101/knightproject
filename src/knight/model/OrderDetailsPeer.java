package knight.model;

import java.util.Hashtable;
import java.util.Enumeration;
import java.sql.SQLException;
import java.sql.Statement;
import knight.beans.CartItem;

public class OrderDetailsPeer {
	
	 public static void insertOrderDetails(Statement stmt, long orderId,
		      Hashtable<String, CartItem> shoppingCart) throws SQLException {
		    String sql;
		    Enumeration<CartItem> enumList = shoppingCart.elements();
		    while (enumList.hasMoreElements()) {
		      CartItem item = (CartItem)enumList.nextElement();
		      sql = "insert into order_details (order_id, food_id, quantity,"
		          + " price, name) values ('" + orderId + "','"
		          + item.getFoodID() + "','" + item.getQuantity() + "','"
		          + item.getPrice() + "','"
		          + item.getName() + "')"
		          ;
		      stmt.executeUpdate(sql);
		      }
		    }
}

