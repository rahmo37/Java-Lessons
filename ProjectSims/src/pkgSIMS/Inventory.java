package pkgSIMS;

/****************************************************************
 * Project Name:	prjSIMS
 * Class:			Inventory
 * Author:			Kim Moorning
 * Date:			September 21, 2022
 * Purpose:			This class reflects the products on hand.	
 ***************************************************************/

public class Inventory {
	private long upc;
	private int quantity;
	
	public Inventory() {
		super();
		this.upc = 0;
		this.quantity = 0;
	}
	
	
	public Inventory(long upc, int quantity) {
		super();
		this.upc = upc;
		this.quantity = quantity;
	}
	
	public long getUpc() {
		return upc;
	}
	public void setUpc(long upc) {
		this.upc = upc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
