package ArrayOfObject2;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		payee p1 = new payee("Obaedur Rahman",45.00, 15.00);
		payee p2 = new payee("Rakib Hasan",35.00, 15.00);
		payee p3 = new payee("Krishna Das",40.00, 15.00);
		payee p4 = new payee("Atanu Das",25.00, 15.00);

		payee[] totPay = {p1,p2,p3,p4};
		
		for(int i = 0; i < totPay.length; i++) {
			System.out.println(totPay[i]);
		}

	}

}
