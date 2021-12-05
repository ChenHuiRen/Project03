package com.ch.team.service;

import static com.ch.team.service.Data.ARCHITECT;
import static com.ch.team.service.Data.DESIGNER;
import static com.ch.team.service.Data.EMPLOYEE;
import static com.ch.team.service.Data.EMPLOYEES;
import static com.ch.team.service.Data.EQUIPMENTS;
import static com.ch.team.service.Data.NOTEBOOK;
import static com.ch.team.service.Data.PC;
import static com.ch.team.service.Data.PRINTER;
import static com.ch.team.service.Data.PROGRAMMER;

import com.ch.team.domain.Architect;
import com.ch.team.domain.Designer;
import com.ch.team.domain.Employee;
import com.ch.team.domain.Equipment;
import com.ch.team.domain.NoteBook;
import com.ch.team.domain.PC;
import com.ch.team.domain.Printer;
import com.ch.team.domain.Programmer;

/**
 * @Descrition ����Data�е����ݷ�װ��Employee[]�����У�ͬʱ�ṩ��ز���Employee[]�ķ���
 * @author chenpi
 * 
 */
public class NameListService {
	private Employee[] employees;// ���湫˾����Ա���Ķ���

	/**
	 * ��empoyees������Ԫ�ؽ��г�ʼ��
	 */
	public NameListService() {
		// ������Ŀ�ṩ��Data�๹����Ӧ��С��employee����
		// �ٸ���Data���е����ݹ�����ͬ�Ķ��󣬰���Employee��Programmer��Designer��Architect�����Լ������Equipmentʵ����Ķ���
		// ���������������
		employees = new Employee[EMPLOYEES.length];

		for (int i = 0; i < employees.length; i++) {

			int type = Integer.parseInt(EMPLOYEES[i][0]);
			// ��ȡEmployee��4��������Ϣ
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);

			Equipment equipment;
			double bonus;
			int stock;

			switch (type) {
			case EMPLOYEE: {
				employees[i] = new Employee(id, name, age, salary);
				break;
			}
			case PROGRAMMER: {
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			}
			case DESIGNER: {
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			}
			case ARCHITECT: {
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
			}
		}
	}

	/**
	 * @Descrition ��ȡָ��index�ϵ�Ա�����豸
	 * @param index
	 * @return
	 */
	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);
		switch (type) {
		case PC: {// 21
			return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		}
		case NOTEBOOK: {// 22
			return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));

		}
		case PRINTER: {// 23
			return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		}
		}
		return null;
	}

	/**
	 * 
	 * @Descrition ��ȡ��ǰ����Ա��
	 * @return ��������Ա�����������
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}

	/**
	 * 
	 * @Descrition ��ȡָ��ID��Ա������
	 * @param id ָ��Ա��ID
	 * @return ָ��Ա������
	 * @throws TeamException �Ҳ���ָ����Ա��
	 */
	public Employee getEmploy(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}

		throw new TeamException("�Ҳ���ָ����Ա��");
	}
}
