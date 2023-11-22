import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import design.*;

import java.util.Scanner;

public class ClubManagmentSystem {

	ArrayList<newlyRecruitedMember> nrMember = new ArrayList<>();
	ArrayList<SenirGenMember> sgMember = new ArrayList<>();
	ArrayList<Executive> eMember = new ArrayList<>();
	ArrayList<SubExecutive> seMember = new ArrayList<>();
	ArrayList<SoonToBePromoted> stpMember = new ArrayList<>();
	ArrayList<String> idList = new ArrayList<>();
	ArrayList<ArrayList<Object>> pendingReqList = new ArrayList<ArrayList<Object>>();
	ArrayList<ArrayList<Object>> allMembers = new ArrayList<ArrayList<Object>>();
	ArrayList<ArrayList<Object>> filteredList = new ArrayList<ArrayList<Object>>();
	
	WelcomePage wp;
	AdminLoginDesign ald;
	AdminPanel ap;
	UserLoginDesign uld;
	UserPanel up;
	JoinAsAMember jam;
	customizeMember cm;
	AddAMember am;
	SearchForMembers sfm;
	RemoveAMember rm;
	ApprovePendingRequest apr;
	AlumniDesign ad;
	NoticeDesign nd;

	Scanner scan;
	int counter = 0;
	String memberId = "";

	public void initialize() throws IOException {
		loadMembers();
		loadPendingRequest();
		welcomePage();		
	}

	/*******************************************************
	 * Start of Load Members method
	 *****************************************************/
	public void loadMembers() {
		try {
			FileReader fr = new FileReader("Members.txt");
			BufferedReader br = new BufferedReader(fr);
			String n = "";
			String id = "";
			String dept = "";
			String pos = "";
			String pNum = "";
			String bg = "";
			String e = "";
			int sem = 0;
			int v = 0;
			int noM = 0;
			boolean admn = false;

			String eachLine = "";
			StringTokenizer st;
			eachLine = br.readLine();

			while (eachLine != null) {
				st = new StringTokenizer(eachLine, ",");
				while (st.hasMoreTokens()) {
					n = st.nextToken();
					id = st.nextToken();
					dept = st.nextToken();
					pos = st.nextToken();
					pNum = st.nextToken();
					bg = st.nextToken();
					e = st.nextToken();
					sem = Integer.parseInt(st.nextToken());
					v = Integer.parseInt(st.nextToken());
					noM = Integer.parseInt(st.nextToken());
					admn = Boolean.parseBoolean(st.nextToken());

					if (admn == true) {
						idList.add(id);
					}

					allMembers.add(new ArrayList<>(Arrays.asList(n, id, dept, pos, pNum, bg, e, sem, v, noM, admn)));

					if (noM < 4) {
						nrMember.add(new newlyRecruitedMember(n, id, dept, pos, pNum, bg, e, sem, v, noM, admn));
					} else if (v >= 30 && noM >= 4 && noM < 10) {
						sgMember.add(new SenirGenMember(n, id, dept, pos, pNum, bg, e, sem, v, noM, admn));
					} else if (v >= 50 && noM >= 10 && noM < 15) {
						seMember.add(new SubExecutive(n, id, dept, pos, pNum, bg, e, sem, v, noM, admn));
					} else if (v >= 70 && noM >= 15) {
						eMember.add(new Executive(n, id, dept, pos, pNum, bg, e, sem, v, noM, admn));
					} else {
						stpMember.add(new SoonToBePromoted(n, id, dept, pos, pNum, bg, e, sem, v, noM, admn));
					}
					eachLine = br.readLine();
				}
			}
			br.close();
			System.out.println(stpMember.get(0).getName());
			System.out.println("Members data loaded!");
		} catch (Exception e) {

		}
	}

	/*******************************************************
	 * End of Load Members method
	 *****************************************************/

	/*******************************************************
	 * Start of Load Members method
	 *****************************************************/
	public void loadPendingRequest() throws IOException {
		FileReader fr = new FileReader("PendingRequest.txt");
		BufferedReader br = new BufferedReader(fr);
		String n = "";
		String id = "";
		String dept = "";
		String pos = "";
		String pNum = "";
		String bg = "";
		String e = "";
		int sem = 0;

		String eachLine = "";
		StringTokenizer st;
		eachLine = br.readLine();

		while (eachLine != null) {
			st = new StringTokenizer(eachLine, ",");
			while (st.hasMoreTokens()) {
				n = st.nextToken();
				id = st.nextToken();
				dept = st.nextToken();
				pos = st.nextToken();
				pNum = st.nextToken();
				bg = st.nextToken();
				e = st.nextToken();
				sem = Integer.parseInt(st.nextToken());

				pendingReqList.add(new ArrayList<>(Arrays.asList(n, id, dept, pos, pNum, bg, e, sem)));
				eachLine = br.readLine();
			}
		}
		br.close();
		System.out.println("Pending Request data loaded!");
	}

	/*******************************************************
	 * End of Load Members method
	 *****************************************************/

	/*******************************************************
	 * Start of Welcome method
	 *****************************************************/
	public void welcomePage() {
		wp = new WelcomePage();
		wp.welcomeMsg.setText("WELCOME TO EWU CLUB MANAGEMENT SYSTEM");
		wp.adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wp.setVisible(false);
				try {
					AdminLogin();
				} catch (Exception e1) {
				}
			}
		});
		wp.userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wp.setVisible(false);
				try {
					userLogin();
				} catch (Exception e1) {
				}
			}
		});
	}

	/*******************************************************
	 * End of Welcome method
	 *****************************************************/

	/*******************************************************
	 * Start of Admin Login method
	 *****************************************************/
	public void AdminLogin() {
		ald = new AdminLoginDesign();
		counter = 0;
		ald.loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = ald.userNameText.getText();
				String pass = new String(ald.passwordValue.getPassword());
				try {
					if (isValidCredentials(user, pass)) {
						ald.frame.setVisible(false);
						viewAdminPanel();
					} else {
						counter++;
						System.out.println(counter);
						JOptionPane.showMessageDialog(ald.frame, "WRONG INFORMATION!", "Warning!",
								JOptionPane.WARNING_MESSAGE);
						ald.userNameText.setText(null);
						ald.passwordValue.setText(null);
						if (counter == 3) {
							JOptionPane.showMessageDialog(ald.frame, "TOO MANY ATTEMPTS! SYSTEM TERMINATING...",
									"ATTEMPTS EXCEEDED!", JOptionPane.ERROR_MESSAGE);
							System.exit(0);
						}
					}
				} catch (Exception e1) {

				}
			}
		});
	}

	// sub method of AdminLogin
	public boolean isValidCredentials(String user, String pass) throws Exception {
		FileReader fr = new FileReader("Password.txt");
		BufferedReader br = new BufferedReader(fr);
		String p;
		p = br.readLine();

		for (int i = 0; i < idList.size(); i++) {
			if (user.equals(idList.get(i))) {
				while (p != null) {
					if (pass.equals(p)) {
						return true;
					}
					p = br.readLine();
				}
				return false;
			}
		}
		return false;
	}

	/*******************************************************
	 * End of Admin Login method
	 *****************************************************/

	public void viewAdminPanel() {
		ap = new AdminPanel();
		ap.memberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ap.setVisible(false);
				customizeMemberMethod();
			}
		});
		ap.noticeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nd = new NoticeDesign();
				nd.adminNotice();
				ap.setVisible(false);
			}
		});
		ap.alumniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad = new AlumniDesign();
				ad.adminAlumni();
				ap.setVisible(false);
			}
		});

	}

	/*******************************************************
	 * Start of customize member method
	 *****************************************************/
	public void customizeMemberMethod() {
		cm = new customizeMember();
		cm.addBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.setVisible(false);
				addAMember();
			}
		});
		cm.removeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.setVisible(false);
				removeAMember();
			}
		});
		cm.pendingRequestBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.setVisible(false);
				approvePendingReqs();
			}
		});
		cm.searchBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.setVisible(false);
				searchForMember();
			}
		});
	}

	/*******************************************************
	 * End of customize member method
	 *****************************************************/

	/*******************************************************
	 * Start of Add a Member method
	 *****************************************************/

	public void addAMember() {

		try {
			am = new AddAMember();
			am.submitButton.addActionListener(new ActionListener() {
				ArrayList<Object> listTF = new ArrayList<>(Arrays.asList(am.nameTF, am.studentidTF, am.departmentTF,
						am.positionTF, am.phoneTF, am.bloodGroupTF, am.emailTF, am.noOfSemesterTF, am.voteTF,
						am.noOfMonthsTF, am.isAdminTF));

				public void actionPerformed(ActionEvent e) {
					if (HelperMethod.isEmpty(listTF)) {
						JOptionPane.showMessageDialog(am, "Please check for empty fields!", "Empty fields found!",
								JOptionPane.WARNING_MESSAGE);
					} else if (!HelperMethod.isValidId(((JTextField) listTF.get(1)).getText())) {
						JOptionPane.showMessageDialog(am, "Invalid ID format!\nCorrect format: (1234-5-67-890)",
								"Invalid ID format", JOptionPane.WARNING_MESSAGE);
					} else {
						HelperMethod.writeMemberInfo(listTF, "Members.txt", true);
						JOptionPane.showMessageDialog(am, "New member added!", "Satus", JOptionPane.WARNING_MESSAGE);
						am.setVisible(false);
						cm.setVisible(true);
						loadMembers();
					}
				}
			});
		} catch (Exception e) {

		}
	}

	/*******************************************************
	 * End of Add a Member Request method
	 *****************************************************/

	/*******************************************************
	 * Start of Remove a Member method
	 *****************************************************/

	public void removeAMember() {
		rm = new RemoveAMember();
		counter = 0;
		for (int i = 0; i < allMembers.size(); i++) {
			rm.addRecordsToTable((String) allMembers.get(i).get(0), (String) allMembers.get(i).get(1));
		}
		rm.idTF.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				counter = 1;
				for (int i = rm.model.getRowCount() - 1; i >= 0; i--) {
					rm.model.removeRow(i);
				}
				String partialId = rm.idTF.getText();
				System.out.println(partialId);
				filteredList = HelperMethod.filter(allMembers, partialId);
				if (!filteredList.isEmpty()) {
					for (int i = 0; i < filteredList.size(); i++) {
						rm.addRecordsToTable((String) filteredList.get(i).get(0), (String) filteredList.get(i).get(1));
					}
				}
			}
		});
		rm.table.addMouseListener(new MouseAdapter() {
			int selectedRow = -1;

			public void mouseClicked(MouseEvent e) {
				rm.removeBTN.setVisible(true);
				StringBuilder build = new StringBuilder();
				memberId = "";
				selectedRow = rm.table.getSelectedRow();
				if (counter == 0) {
					build = HelperMethod.buildTextArea(allMembers, selectedRow);
					rm.descriptionTA.setText(build.toString());
					memberId = ((String) allMembers.get(selectedRow).get(1));
					setMemberCatagory(nrMember, memberId, rm);
					setMemberCatagory(sgMember, memberId, rm);
					setMemberCatagory(seMember, memberId, rm);
					setMemberCatagory(eMember, memberId, rm);
					setMemberCatagory(stpMember, memberId, rm);
				} else {
					build = HelperMethod.buildTextArea(filteredList, selectedRow);
					rm.descriptionTA.setText(build.toString());
					memberId = ((String) filteredList.get(selectedRow).get(1));
					setMemberCatagory(nrMember, memberId, rm);
					setMemberCatagory(sgMember, memberId, rm);
					setMemberCatagory(seMember, memberId, rm);
					setMemberCatagory(eMember, memberId, rm);
					setMemberCatagory(stpMember, memberId, rm);
				}
			}
		});
		rm.removeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentUserId = ald.userNameText.getText();
				int selectedRow = -1;
				boolean isAppend = false;

				if (hasPrivilege(currentUserId, memberId, sgMember, nrMember, seMember, eMember)) {
					isAppend = false;
					selectedRow = rm.table.getSelectedRow();
					rm.model.removeRow(selectedRow);
					allMembers.remove(selectedRow);
					for (int i = 0; i < allMembers.size(); i++) {
						if (i > 0) {
							isAppend = true;
						}
						HelperMethod.writeMemberInfo(allMembers.get(i), "Members.txt", isAppend);
					}
					allMembers.clear();
					loadMembers();
					JOptionPane.showMessageDialog(rm, "Member Removed!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					rm.descriptionTA.setText("");
					rm.removeBTN.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(rm, "Not engough privilege to remove this member!", "Information",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	public boolean hasPrivilege(String curId, String memId, ArrayList<SenirGenMember> sgList,
			ArrayList<newlyRecruitedMember> nrList, ArrayList<SubExecutive> seList, ArrayList<Executive> eList) {
		for (int i = 0; i < sgList.size(); i++) {
			if (curId.equals(sgList.get(i).getId())) {
				for (int j = 0; j < nrList.size(); j++) {
					if (memId.equals(nrList.get(j).getId())) {
						return true;
					}
				}
				return false;
			}
		}
		for (int i = 0; i < seList.size(); i++) {
			if (curId.equals(seList.get(i).getId())) {
				for (int j = 0; j < nrList.size(); j++) {
					if (memId.equals(nrList.get(j).getId())) {
						return true;
					}
				}
				for (int j = 0; j < sgList.size(); j++) {
					if (memId.equals(sgList.get(j).getId())) {
						return true;
					}
				}
				return false;
			}
		}
		for (int i = 0; i < eList.size(); i++) {
			if (curId.equals(eList.get(i).getId())) {
				for (int j = 0; j < eList.size(); j++) {
					if (memId.equals(eList.get(j).getId())) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/*******************************************************
	 * End of Remove a Member method
	 *****************************************************/

	/*******************************************************
	 * Start of Approve Pending Request method
	 *****************************************************/

	public void approvePendingReqs() {

		apr = new ApprovePendingRequest();
		for (int i = 0; i < pendingReqList.size(); i++) {
			apr.addRecordsToTable((String) pendingReqList.get(i).get(0), (String) pendingReqList.get(i).get(1));
		}

		if (pendingReqList.isEmpty()) {
			apr.textArea.setText("No new requests!");
		}

		apr.table.addMouseListener(new MouseAdapter() {
			int selectedRow = -1;

			public void mouseClicked(MouseEvent e) {
				StringBuilder build = new StringBuilder();
				selectedRow = apr.table.getSelectedRow();
				build.append("Name: " + pendingReqList.get(selectedRow).get(0) + "\n");
				build.append("Id: " + pendingReqList.get(selectedRow).get(1) + "\n");
				build.append("Department: " + pendingReqList.get(selectedRow).get(2) + "\n");
				build.append("Position: " + pendingReqList.get(selectedRow).get(3) + "\n");
				build.append("Phone: " + pendingReqList.get(selectedRow).get(4) + "\n");
				build.append("Blood Group: " + pendingReqList.get(selectedRow).get(5) + "\n");
				build.append("Email: " + pendingReqList.get(selectedRow).get(6) + "\n");
				build.append("No. of Semester: " + pendingReqList.get(selectedRow).get(7) + "\n");
				apr.textArea.setText(build.toString());
			}
		});
		apr.addBTN.addActionListener(new ActionListener() {
			int selectedRow = -1;
			int v = 0;
			int noM = 0;
			boolean admn = false;

			public void actionPerformed(ActionEvent e) {
				boolean isAppend = true;
				selectedRow = apr.table.getSelectedRow();
				if (selectedRow >= 0) {
					apr.model.removeRow(selectedRow);
					apr.textArea.setText("");

					pendingReqList.get(selectedRow).add(v);
					pendingReqList.get(selectedRow).add(noM);
					pendingReqList.get(selectedRow).add(admn);

					HelperMethod.writeMemberInfo(pendingReqList.get(selectedRow), "Members.txt", isAppend);
					pendingReqList.remove(selectedRow);
					isAppend = false;
					for (int i = 0; i < pendingReqList.size(); i++) {
						if (i > 0) {
							isAppend = true;
						}
						HelperMethod.writeMemberInfo(pendingReqList.get(i), "PendingRequest.txt", isAppend);
					}
					JOptionPane.showMessageDialog(ald.frame, "New Member Added", "Status",
							JOptionPane.INFORMATION_MESSAGE);
					loadMembers();
				} else {
					JOptionPane.showMessageDialog(ald.frame, "You need to select a row first!", "Important!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		apr.rejectBTN.addActionListener(new ActionListener() {
			int selectedRow = -1;

			public void actionPerformed(ActionEvent e) {
				boolean isAppend = false;
				selectedRow = apr.table.getSelectedRow();
				if (selectedRow >= 0) {
					apr.model.removeRow(selectedRow);
					apr.textArea.setText("");
					pendingReqList.remove(selectedRow);
					if (pendingReqList.isEmpty()) {
						FileWriter writer;
						try {
							writer = new FileWriter("PendingRequest.txt");
							writer.write("");
						} catch (IOException e1) {
						}
					}
					for (int i = 0; i < pendingReqList.size(); i++) {
						if (i > 0) {
							isAppend = true;
						}
						HelperMethod.writeMemberInfo(pendingReqList.get(i), "PendingRequest.txt", isAppend);
					}
					JOptionPane.showMessageDialog(ald.frame, "Member Request Rejected!", "Request Status!",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ald.frame, "You need to select a row first!", "Important!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	/*******************************************************
	 * End of Appreove Pending Request method
	 *****************************************************/

	/*******************************************************
	 * Start of search method
	 *****************************************************/

	public void searchForMember() {
		sfm = new SearchForMembers();
		counter = 0;
		for (int i = 0; i < allMembers.size(); i++) {
			sfm.addRecordsToTable((String) allMembers.get(i).get(0), (String) allMembers.get(i).get(1));
		}
		sfm.idTF.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				counter = 1;
				for (int i = sfm.model.getRowCount() - 1; i >= 0; i--) {
					sfm.model.removeRow(i);
				}
				String partialId = sfm.idTF.getText();
				filteredList = HelperMethod.filter(allMembers, partialId);
				if (!filteredList.isEmpty()) {
					for (int i = 0; i < filteredList.size(); i++) {
						sfm.addRecordsToTable((String) filteredList.get(i).get(0), (String) filteredList.get(i).get(1));
					}
				}
			}
		});
		sfm.table.addMouseListener(new MouseAdapter() {
			int selectedRow = -1;

			public void mouseClicked(MouseEvent e) {
				StringBuilder build = new StringBuilder();
				String memberId = "";
				selectedRow = sfm.table.getSelectedRow();
				if (counter == 0) {
					build = HelperMethod.buildTextArea(allMembers, selectedRow);
					sfm.descriptionTA.setText(build.toString());
					memberId = ((String) allMembers.get(selectedRow).get(1));
					setMemberCatagory(nrMember, memberId, sfm);
					setMemberCatagory(sgMember, memberId, sfm);
					setMemberCatagory(seMember, memberId, sfm);
					setMemberCatagory(eMember, memberId, sfm);
					setMemberCatagory(stpMember, memberId, sfm);
				} else {
					build = HelperMethod.buildTextArea(filteredList, selectedRow);
					sfm.descriptionTA.setText(build.toString());
					memberId = ((String) filteredList.get(selectedRow).get(1));
					setMemberCatagory(nrMember, memberId, sfm);
					setMemberCatagory(sgMember, memberId, sfm);
					setMemberCatagory(seMember, memberId, sfm);
					setMemberCatagory(eMember, memberId, sfm);
					setMemberCatagory(stpMember, memberId, sfm);
				}
			}
		});
	}

	// Sub method of search and remove method
	public void setMemberCatagory(ArrayList<?> list, String memberId, JFrame frame) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(0) instanceof newlyRecruitedMember) {
				if (memberId.equals(((newlyRecruitedMember) list.get(i)).getId())) {
					if (frame instanceof SearchForMembers) {
						((SearchForMembers) frame).memberCatagoryLBL.setText("Newly Recruited Member");
					} else if (frame instanceof RemoveAMember) {
						((RemoveAMember) frame).memberCatagoryLBL.setText("Newly Recruited Member");
					}
				}
			}
			if (list.get(0) instanceof SenirGenMember) {
				if (memberId.equals(((SenirGenMember) list.get(i)).getId())) {
					if (frame instanceof SearchForMembers) {
						((SearchForMembers) frame).memberCatagoryLBL.setText("Senior General Member");
					} else if (frame instanceof RemoveAMember) {
						((RemoveAMember) frame).memberCatagoryLBL.setText("Senior General Member");
					}
				}
			}
			if (list.get(0) instanceof SubExecutive) {
				if (memberId.equals(((SubExecutive) list.get(i)).getId())) {
					if (frame instanceof SearchForMembers) {
						((SearchForMembers) frame).memberCatagoryLBL.setText("Sub Executive Member");
					} else if (frame instanceof RemoveAMember) {
						((RemoveAMember) frame).memberCatagoryLBL.setText("Sub Executive Member");
					}
				}
			}
			if (list.get(0) instanceof Executive) {
				if (memberId.equals(((Executive) list.get(i)).getId())) {
					if (frame instanceof SearchForMembers) {
						((SearchForMembers) frame).memberCatagoryLBL.setText("Executive Member");
					} else if (frame instanceof RemoveAMember) {
						((RemoveAMember) frame).memberCatagoryLBL.setText("Executive Member");
					}
				}
			}
			if (list.get(0) instanceof SoonToBePromoted) {
				if (memberId.equals(((SoonToBePromoted) list.get(i)).getId())) {
					if (frame instanceof SearchForMembers) {
						((SearchForMembers) frame).memberCatagoryLBL.setText("Soon To Be Promoted");
					} else if (frame instanceof RemoveAMember) {
						((RemoveAMember) frame).memberCatagoryLBL.setText("Soon To Be Promoted");
					}
				}
			}
		}
	}

	/*******************************************************
	 * End of search method
	 *****************************************************/

	/*******************************************************
	 * Start of User Login method
	 *****************************************************/

	public void userLogin() throws Exception {
		uld = new UserLoginDesign();
		counter = 0;
		uld.userLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader fr = new FileReader("StudentID.txt");
					BufferedReader br = new BufferedReader(fr);
					String i = br.readLine();
					boolean idFound = false;
					String input = uld.IdTextField.getText();
					if (HelperMethod.isValidId(input)) {
						while (i != null) {
							if (input.equals(i)) {
								idFound = true;
								uld.statusLabel.setText("ID found!");
								uld.setVisible(false);
								up = new UserPanel();
								up.memberButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										up.setVisible(false);
										joinAsAMember();
									}
								});
								up.noticeButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										nd = new NoticeDesign();
										nd.userNotice();
										up.setVisible(false);
									}
								});
								up.alumniButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ad = new AlumniDesign();
										ad.userAlumni();
										up.setVisible(false);
									}
								});

							}
							i = br.readLine();
						}
						if (!idFound) {
							uld.IdTextField.setText(null);
							uld.statusLabel.setText("           Student ID not found!");
						}
					} else {
						counter++;
						if (counter == 3) {
							uld.statusLabel.setText("");
							JOptionPane.showMessageDialog(uld, "TOO MANY ATTEMPTS! SYSTEM TERMINATING...",
									"ATTEMPTS EXCEEDED!", JOptionPane.ERROR_MESSAGE);
							System.exit(1);
						}
						uld.IdTextField.setText(null);
						uld.statusLabel.setText("Invalid Format.\nPlease enter a Valid ID!");
					}
				} catch (Exception e1) {
				}
			}
		});
	}

	/*******************************************************
	 * End of User Login method
	 *****************************************************/

	/*******************************************************
	 * Start of joinAsMember method
	 *****************************************************/

	public void joinAsAMember() {
		try {
			jam = new JoinAsAMember();
			jam.submitButton.addActionListener(new ActionListener() {
				ArrayList<Object> listTF = new ArrayList<>(Arrays.asList(jam.nameTF, jam.studentidTF, jam.departmentTF,
						jam.positionTF, jam.phoneTF, jam.bloodGroupTF, jam.emailTF, jam.noOfSemesterTF));

				public void actionPerformed(ActionEvent e) {
					if (HelperMethod.isEmpty(listTF)) {
						JOptionPane.showMessageDialog(jam, "Please check for empty fields!", "Empty fields found!",
								JOptionPane.WARNING_MESSAGE);
					} else if (!HelperMethod.isValidId(((JTextField) listTF.get(1)).getText())) {
						JOptionPane.showMessageDialog(jam, "Invalid ID format!\nCorrect format: (1234-5-67-890)",
								"Invalid ID format", JOptionPane.WARNING_MESSAGE);
					} else {
						HelperMethod.writeMemberInfo(listTF, "PendingRequest.txt", true);
						JOptionPane.showMessageDialog(jam, "Application submitted successfully!", "Satus",
								JOptionPane.WARNING_MESSAGE);
						jam.setVisible(false);
						up.setVisible(true);
					}
				}
			});
		} catch (Exception e) {

		}

	}
}
