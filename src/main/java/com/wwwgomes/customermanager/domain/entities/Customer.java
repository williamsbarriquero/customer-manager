package com.wwwgomes.customermanager.domain.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.wwwgomes.customermanager.domain.enums.Gender;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "customer")
@ApiModel("Customer")
public class Customer {
	
	@ApiModelProperty(value = "Identification code", example = "1")
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Full name", example = "Williams Gomes")
	@Column(name = "full_name")
	private String fullName;
	
	@ApiModelProperty(value = "Gender", example = "MALE or FEMALE")
	@Enumerated(EnumType.STRING)
	@Column
	private Gender gender;
	
	@ApiModelProperty(value = "Date of Birth", example = "1994-05-11")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@ApiModelProperty(value = "Age", example = "26")
	@Column
	private Integer age;
	
	@ApiModelProperty(value = "City where you live")
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

}
