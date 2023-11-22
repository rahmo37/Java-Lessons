import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ClubManagementSystem {

	ArrayList<GeneralMembers> membersG = new ArrayList<>();
	ArrayList<SeniorGeneralMembers> membersS = new ArrayList<>();

	public void loadMembers() throws IOException {
		FileReader fr = new FileReader("Members.txt");
		BufferedReader br = new BufferedReader(fr);

		String n = "";
		String p = "";
		int ns = 0;
		
		
		String eachLine = "";
		StringTokenizer st;
		eachLine = br.readLine();
		while (eachLine != null) {
			st = new StringTokenizer(eachLine, ",");
			while (st.hasMoreTokens()) {
				n = st.nextToken();
				p = st.nextToken();
				ns = Integer.parseInt(st.nextToken());

				if (ns >= 4) {
					membersS.add(new SeniorGeneralMembers(n, p, ns));
				} else {
					membersG.add(new GeneralMembers(n, p, ns));
				}

				eachLine = br.readLine();
			}
		}
		System.out.println(membersS.get(0).toString());
		System.out.println(membersG.get(0).toString());
		br.close();
		System.out.println("Members data loaded!");
	}
}
