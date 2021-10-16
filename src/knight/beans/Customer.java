package knight.beans;

public class Customer {

	private String customerName = "";
	private String serverName = "";
	private String ccName = "";
	private String ccNumber = "";
	private String ccExpiryDate = "";
	private String orderDate ="";
	
	
	
	public String getOrderDate() {
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf =
				new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.orderDate = sdf.format(dt);
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getCcExpiryDate() {
		return ccExpiryDate;
	}
	public void setCcExpiryDate(String ccExpiryDate) {
		this.ccExpiryDate = ccExpiryDate;
	}
	
	
}
