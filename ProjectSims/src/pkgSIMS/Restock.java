package pkgSIMS;

public class Restock {

	private int upc;
	private int quantity;
	private int supplierNum;
	private String orderDate;
	
	
	public Restock() {
		super();
		this.upc = 0;
		this.quantity = 0;
		this.supplierNum = 0;
		this.orderDate = "";
	}
	
	public Restock(int upc, int quantity, int supplierNum, String orderDate) {
		super();
		this.upc = upc;
		this.quantity = quantity;
		this.supplierNum = supplierNum;
		this.orderDate = orderDate;
	}
	
	public int getUpc() {
		return upc;
	}
	public void setUpc(int upc) {
		this.upc = upc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSupplierNum() {
		return supplierNum;
	}
	public void setSupplierNum(int supplierNum) {
		this.supplierNum = supplierNum;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderdate(String orderDate) {
		this.orderDate = orderDate;
	}

	
	
}
