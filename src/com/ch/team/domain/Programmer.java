package com.ch.team.domain;

import com.ch.team.service.Status;

/**
 * 
 * @author chenpi
 * @Description ����Ա��
 *
 */
public class Programmer extends Employee {
	private int memberid;// �ڿ����Ŷ��е�ID
	private Status status = Status.FREE;
	private Equipment equipment;

	public Programmer() {
		super();
	}

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return super.getDetails() + "\t����Ա\t" + status + "\t\t\t" + equipment.getDescription();
	}

}
