package com.ch.team.service;

import com.ch.team.domain.Architect;
import com.ch.team.domain.Designer;
import com.ch.team.domain.Employee;
import com.ch.team.domain.Programmer;

/**
 * 
 * ���ڿ����Ŷӳ�Ա�Ĺ�����ӡ�ɾ���ȡ�
 * 
 * @Descrition
 * @author chenpi
 *
 */
public class TeamService {
	private static int counter = 1;// ��memerID��ֵʹ��
	private final int MAX_MEMBER = 5;// ���ƿ����Ŷ�����
	private Programmer[] team = new Programmer[MAX_MEMBER];// ���濪���Ŷӳ�Ա����
	private int total;// ��¼�����Ŷ���ʵ�ʵ�����

	private int numOfArchitect;// �����Ŷ��мܹ�ʦ����
	private int numOfDesigner;// �����Ŷ������ʦ����
	private int numOfProgrammer;// �����Ŷ��г���Ա����

	public TeamService() {
		super();
	}

	/**
	 * 
	 * @Descrition ��ȡ�����Ŷӳ�Ա
	 * @return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	/**
	 * 
	 * @Descrition ��ָ����Ա����ӵ������Ŷ���
	 * @param e
	 * @throws TeamException
	 */
	public void addMember(Employee e) throws TeamException {
		// ��Ա�������޷����
		if (total >= MAX_MEMBER) {
			throw new TeamException("��Ա�������޷����");
		}

		// �ó�Ա���ǿ�����Ա���޷����
		if (!(e instanceof Programmer)) {
			throw new TeamException("�ó�Ա���ǿ�����Ա���޷����");
		}
		// ��Ա�����ڱ������Ŷ���
		if (isExist(e)) {
			throw new TeamException("��Ա�����ڱ������Ŷ���");
		}
		// ��Ա������ĳ�Ŷӳ�Ա
		Programmer p = (Programmer) e;
		if (Status.BUSY.equals(p.getStatus().getNAME())) {
			throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
		}

		// ��Ա�������ݼ٣��޷����
		if (Status.VOCATION.equals(p.getStatus().getNAME())) {
			throw new TeamException("��Ա�������ݼ٣��޷����");
		}

		// �Ŷ�������ֻ����һ���ܹ�ʦ
		// �Ŷ�������ֻ�����������ʦ
		// �Ŷ�������ֻ������������Ա
		if (p instanceof Architect) {
			if (numOfArchitect >= 1) {
				throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
			}
		} else if (p instanceof Designer) {
			if (numOfDesigner >= 2) {
				throw new TeamException("�Ŷ�������ֻ�����������ʦ");
			}
		} else if (p instanceof Programmer) {
			if (numOfProgrammer >= 3) {
				throw new TeamException("�Ŷ�������ֻ������������Ա");
			}
		}

		// ��p(e)��ӵ����е�team��
		team[total++] = p;
		if (p instanceof Architect) {
			numOfArchitect++;
		} else if (p instanceof Designer) {
			numOfDesigner++;
		} else if (p instanceof Programmer) {
			numOfProgrammer++;
		}

		// p�����Ը�ֵ
		p.setStatus(Status.BUSY);
		p.setMemberid(counter++);

	}

	/**
	 * 
	 * @Descrition �ж�ָ����Ա���Ƿ��Ѵ��ڸ��Ŷ���
	 * @param e
	 * @return
	 */
	private boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeMember(int memberId) {

	}
}
