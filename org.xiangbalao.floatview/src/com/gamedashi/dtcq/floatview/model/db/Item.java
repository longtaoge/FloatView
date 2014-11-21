package com.gamedashi.dtcq.floatview.model.db;

public class Item {

	public Item() {
		super();
	}

	private int id;
	private String name;
	private String icon;
	private String description;
	private String effect;
	private int price;
	private Integer type;
	private Integer color;
	private String minGrade;
	private String enchant;
	
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", icon=" + icon
				+ ", description=" + description + ", effect=" + effect
				+ ", price=" + price + ", type=" + type + ", color=" + color
				+ ", minGrade=" + minGrade + ", enchant=" + enchant + "]";
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	


	public String getMinGrade() {
		return minGrade;
	}


	public void setMinGrade(String minGrade) {
		this.minGrade = minGrade;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
	}

	public String getEnchant() {
		return enchant;
	}
	public void setEnchant(String enchant) {
		this.enchant = enchant;
	}
	
	
	
	
	
	
}
