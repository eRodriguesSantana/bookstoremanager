package com.erodriguessantana.bookstoremanager.entity;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	@NotBlank
	@Size(max = 200)
	private String name;
	
	@Column(nullable = false)
	@NotNull
	private Integer age;
	
	@Column(name = "day_birth", nullable = false)
	@NotNull
	private Integer dayBirth;
	
	@Column(name = "month_birth", nullable = false)
	@NotNull
	private Integer monthBirth;
	
	@Column(name = "year_birth", nullable = false)
	@NotNull
	private Integer yearBirth;

	public Author() {}

	public Author(Long id, String name, Integer dayBirth, Integer monthBirth, Integer yearBirth) {
		this.id = id;
		this.name = name;
		this.dayBirth = dayBirth;
		this.monthBirth = monthBirth;
		this.yearBirth = yearBirth;
	}
	
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
	
	public Integer getAge() {
		return Author.ageAuthor(getDayBirth(), getMonthBirth(), getYearBirth());
	}
	
	public static int dateBirth(final LocalDate birthday) {
	    final LocalDate currentDate = LocalDate.now();
	    final Period period = Period.between(birthday, currentDate);
	    return period.getYears();
	}
	
	public static int ageAuthor(final int dayBirth, final int monthBirth, final int yearBirth) {		
	    return dateBirth(LocalDate.of(yearBirth, monthBirth, dayBirth));
	}
}
