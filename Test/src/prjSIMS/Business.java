package prjSIMS;

public class Business {
	
	private int storenum;
	private String storename;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String empid;
	

	public Business() {
		super();
		this.storenum = 0;
		this.storename = "";
		this.address ="";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.phone = "";
		this.empid = "";
	}
	
	public Business(int storenum, String storename, String address, String city, String state, String zip, String phone,
			String empid) {
		super();
		this.storenum = storenum;
		this.storename = storename;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.empid = empid;
	}
	
	
	public int getStorenum() {
		return storenum;
	}
	public void setStorenum(int storenum) {
		this.storenum = storenum;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	
	

}
