package com.ch.team.domain;

public class PC implements Equipment {
	private String model;// �����ͺ�
	private String display;// ��ʾ������

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}

	public PC() {
		super();
	}

	@Override
	public String getDescription() {
		return model + "(" + display + ")";
	}

}
