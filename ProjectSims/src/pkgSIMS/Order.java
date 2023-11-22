package pkgSIMS;

/****************************************************************
 * Project Name:	prjSIMS
 * Class:			Order
 * Author:			Kim Moorning
 * Date:			September 21, 2022
 * Purpose:			This class reflects customer orders.	
 ***************************************************************/


//MUST UPDATE THIS CLASS
public class Order {
	
	private int upc;
	private int quantity;
	private int suppliernum;
	private String orderdate;
	
	
	public Order() {
		super();
		this.upc = 0;
		this.quantity = 0;
		this.suppliernum = 0;
		this.orderdate = "";
	}
	
	public Order(int upc, int quantity, int suppliernum, String orderdate) {
		super();
		this.upc = upc;
		this.quantity = quantity;
		this.suppliernum = suppliernum;
		this.orderdate = orderdate;
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
	public int getSuppliernum() {
		return suppliernum;
	}
	public void setSuppliernum(int suppliernum) {
		this.suppliernum = suppliernum;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}


}
