package knight.model;

import java.sql.SQLException;
import java.sql.Statement;
import knight.beans.Customer;

public class OrderPeer {

  public static void insertOrder(Statement stmt, long orderId,
      Customer customer) throws SQLException {
    String sql = "insert into orders (order_id, customer_name,"
        + " server_name, order_date, cc_name, cc_number, cc_expiry) values ('"
        + orderId + "','" + customer.getCustomerName() + "','"
        + customer.getServerName() + "','"
        + customer.getOrderDate() + "','"
        + customer.getCcName() + "','" + customer.getCcNumber()
        + "','" + customer.getCcExpiryDate() + "')"
        ;
    stmt.executeUpdate(sql);
    }
  }
