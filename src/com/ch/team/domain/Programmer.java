package com.ch.team.domain;

import com.ch.team.service.Status;

/**
 * 
 * @author chenpi
 * @Description 程序员类
 *
 */
public class Programmer extends Employee {
	private int memberid;// 在开发团队中的ID
	private Status status;
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

}
