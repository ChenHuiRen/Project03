package com.ch.team.view;

import com.ch.team.domain.Employee;
import com.ch.team.domain.Programmer;
import com.ch.team.service.NameListService;
import com.ch.team.service.TeamException;
import com.ch.team.service.TeamService;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	public void enterMainMenu() {

		boolean loopFlag = true;
		char meau = 0;
		while (loopFlag) {

			if (meau != '1') {
				listAllEmployees();
			}

			System.out.println("1-�Ŷ��б� 2-����Ŷӳ�Ա 3-ɾ���Ŷӳ�Ա 4-�˳� ��ѡ��(1-4):");

			meau = TSUtility.readMenuSelection();
			switch (meau) {
			case '1':
				getTeam();
				break;
			case '2':

				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println("ȷ���Ƿ��˳�(Y/N):");
				char isExit = TSUtility.readConfirmSelection();
				if (isExit == 'Y') {
					loopFlag = false;
					System.out.println("�˳�����~bye");
				}
				break;
			}
		}
	}

	/**
	 * 
	 * @Descrition ��ʾ����Ա����Ϣ
	 */
	private void listAllEmployees() {
		System.out.println("------------------------------------�����Ŷӵ������------------------------------------\n");

		Employee[] employees = listSvc.getAllEmployees();
		System.out.println("ID\t����\t����\t����\tְλ\t״̬\t����\t��Ʊ\t�����豸");
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}

		System.out.println("---------------------------------------------------------------------------------------");
	}

	private void getTeam() {
		System.out.println("---------------------�Ŷӳ�Ա�б�---------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("�����Ŷ�Ŀǰû�г�Ա");
		} else {
			System.out.println("TID/ID\t����\t����\t����\tְλ\t״̬\t����\t��Ʊ");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}
		System.out.println("-----------------------------------------------------");
	}

	private void addMember() {
		System.out.println("---------------------��ӳ�Ա---------------------");
		System.out.println("������Ҫ���Ա����ID��");
		int id = TSUtility.readInt();
		try {
			Employee employ = listSvc.getEmploy(id);
			teamSvc.addMember(employ);
			System.out.println("��ӳɹ�");
		} catch (TeamException e) {

			System.out.println("���ʧ�ܣ�ԭ��" + e.getMessage());
		}
		// ���س�������....
		TSUtility.readReturn();

	}

	private void deleteMember() {
		System.out.println("---------------------ɾ����Ա---------------------");
		System.out.println("������Ҫɾ��Ա����TID��");
		int memberid = TSUtility.readInt();

		System.out.println("ȷ���Ƿ�ɾ��(Y/N):");
		char isDelete = TSUtility.readConfirmSelection();
		if (isDelete == 'Y') {
			try {
				teamSvc.removeMember(memberid);
				System.out.println("ɾ���ɹ�");
			} catch (TeamException e) {
				System.out.println("ɾ��ʧ�ܣ�ԭ���ǣ�" + e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
