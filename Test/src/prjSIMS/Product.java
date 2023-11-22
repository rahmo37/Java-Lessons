package prjSIMS;

/*********************************************************
 * 
 * Project Name: prjSIMS
 * Class: Employee
 * Author: Nathan, Keith, Aidan, Jordan, John
 * Date: September 21st 2022
 * Purpose: This class reflects the products
 * *******************************************************/

public class Product {
	
	        private long upc;
	        private String productName;
	        private String deptNum;
	        private double price;
	        private int expDays;
	        private int supplierNum;

	        public Product (long upc, String productName, String deptNum, double price, int expDays, int supplierNum) {

	            this.upc = upc;
	            this.productName = productName;
	            this.deptNum = deptNum;
	            this.price = price;
	            this.expDays = expDays;
	            this.supplierNum = supplierNum;


	        }

	        public Product() {
	            this.upc = 0;
	            this.productName = "NULL";
	            this.deptNum = "NULL";
	            this.price = 0.00;
	            this.expDays = 0;
	            this.supplierNum = 0;
	        }

	        public long getUpc() {
	            return upc;
	        }

	        public void setUpc(long upc) {
	            this.upc = upc;
	        }

	        public String getProductName() {
	            return productName;
	        }

	        public void setProductName(String productName) {
	            this.productName = productName;
	        }

	        public String getDeptNum() {
	            return deptNum;
	        }


	        public void setDeptNum(String deptNum) {
	            this.deptNum = deptNum;
	        }

	        public double getPrice() {
	            return price;
	        }

	        public void setPrice(double price) {
	            this.price = price;
	        }

	        public int getExpDays() {
	            return expDays;
	        }

	        public void setExpDays(int expDays) {
	            this.expDays = expDays;
	        }

	        public int getSupplierNum() {
	            return supplierNum;
	        }

	        public void setSupplierNum(int supplierNum) {
	            this.supplierNum = supplierNum;
	        }

	
	

}
