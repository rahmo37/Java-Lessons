package pkgSIMS;

/****************************************************************
 * Project Name:	prjSIMS
 * Class:			Supplier
 * Author:			Kim Moorning
 * Date:			September 21, 2022
 * Purpose:			This class stores data for product suppliers.	
 ***************************************************************/

public class Supplier {
	private int supplierNum;
	private String supplierName;
	private String supplierAddress;
	private String supplierEmail;
	private String supplierPhone;
	
	public Supplier() {
		super();
		this.supplierNum = 0;
		this.supplierName = "";
		this.supplierAddress = "";
		this.supplierEmail = "";
		this.supplierPhone = "";
	}
	
	
	public Supplier(int supplierNum, String supplierName,  String supplierAddress,  String supplierEmail,  String supplierPhone) {
		super();
		this.supplierNum = supplierNum;
		this.supplierName = supplierName;
		this.supplierAddress = "";
		this.supplierEmail = "";
		this.supplierPhone = "";
	}
	
	public int getSuppliernum() {
		return supplierNum;
	}
	public void setSuppliernum(int suppliernum) {
		this.supplierNum = suppliernum;
	}
	public String getSuppliername() {
		return supplierName;
	}
	public void setSuppliername(String suppliername) {
		this.supplierName = suppliername;
	}


	public String getSupplierAddress() {
		return supplierAddress;
	}


	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}


	public String getSupplierEmail() {
		return supplierEmail;
	}


	public void setSupplieremail(String supplieremail) {
		this.supplierEmail = supplieremail;
	}


	public String getSupplierPhone() {
		return supplierPhone;
	}


	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

}
