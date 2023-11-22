
public class SoonToBePromoted extends Member {

	int vote;
	int noOfMonths;

	SoonToBePromoted() {
		vote = 0;
		noOfMonths = 0;
	}

	SoonToBePromoted(String name, String id, String department, String position, String phoneNum, String bloodGrp,
			String email, int noOfSemester, int vote, int noOfMonths, boolean isAdmin) {
		super(name, id, department, position, phoneNum, bloodGrp, email, noOfSemester, isAdmin);
		this.vote = vote;
		this.noOfMonths = noOfMonths;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public int getNoOfMonths() {
		return noOfMonths;
	}

	public void setNoOfMonths(int noOfMonths) {
		this.noOfMonths = noOfMonths;
	}
}
