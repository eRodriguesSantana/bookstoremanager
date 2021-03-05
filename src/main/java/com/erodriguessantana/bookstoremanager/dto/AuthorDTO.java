package com.erodriguessantana.bookstoremanager.dto;

import com.erodriguessantana.bookstoremanager.entity.Author;

public class AuthorDTO {

	private Long id;
	private String name;
	private Integer age;
	private Integer dayBirth;
	private Integer monthBirth;
	private Integer yearBirth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return Author.ageAuthor(getDayBirth(), getMonthBirth(), getYearBirth());
	}
	
	public Integer getDayBirth() {
		return dayBirth;
	}

	public void setDayBirth(Integer dayBirth) {
		this.dayBirth = dayBirth;
	}

	public Integer getMonthBirth() {
		return monthBirth;
	}

	public void setMonthBirth(Integer monthBirth) {
		this.monthBirth = monthBirth;
	}

	public Integer getYearBirth() {
		return yearBirth;
	}

	public void setYearBirth(Integer yearBirth) {
		this.yearBirth = yearBirth;
	}
}
