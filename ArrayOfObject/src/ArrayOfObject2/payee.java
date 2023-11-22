package ArrayOfObject2;

public class payee {
	private String name;
	private double hoursWorked;
	private double payRate;

	payee(String name, double hoursWorked, double payRate) {
		this.name = name;
		this.hoursWorked = hoursWorked;
		this.payRate = payRate;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public double getPayRate() {
		return payRate;
	}

	public double getGrossPay() {
		double regularPay, overtimePay;

		if (hoursWorked > 40) {
			regularPay = 40 * payRate;
			overtimePay = (hoursWorked - 40) * payRate * 1.5;
			return regularPay + overtimePay;
		} else {
			return hoursWorked * payRate;
		}
	}

	public String toString() {
		return "Employee : " + name + "\nHours Worked : " + getHoursWorked() + "\nPay Rate : " + getPayRate()
				+ "\nTotal pay : " + getGrossPay() + "\n";
	}
}
