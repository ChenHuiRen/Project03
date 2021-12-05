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

import com.ch.team.domain.Employee;
import com.ch.team.domain.Equipment;
import com.ch.team.domain.NoteBook;
import com.ch.team.domain.PC;
import com.ch.team.domain.Printer;
import com.ch.team.domain.Programmer;

/**
 * @Descrition 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * @author chenpi
 * 
 */
public class NameListService {
	private Employee[] employees;// 保存公司所有员工的对象

	/**
	 * 给empoyees及数组元素进行初始化
	 */
	public NameListService() {
		// 根据项目提供的Data类构建相应大小的employee数组
		// 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer、Architect对象，以及相关联Equipment实现类的对象
		// 将对象存在数组中
		employees = new Employee[EMPLOYEES.length];

		for (int i = 0; i < employees.length; i++) {

			int type = Integer.parseInt(EMPLOYEES[i][0]);
			// 获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);

			switch (type) {
			case EMPLOYEE: {
				employees[i] = new Employee(id, name, age, salary);
				break;
			}
			case PROGRAMMER: {
				Equipment equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			}
			case DESIGNER: {

				break;
			}
			case ARCHITECT: {

				break;
			}
			}
		}
	}

	/**
	 * @Descrition 获取指定index上的员工的设备
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

	public Employee[] getAllEmployees() {
		return null;
	}

	public Employee getEmploy(int id) {
		return null;
	}
}
