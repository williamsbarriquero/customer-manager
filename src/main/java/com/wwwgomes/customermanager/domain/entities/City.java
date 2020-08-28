package com.wwwgomes.customermanager.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.wwwgomes.customermanager.domain.enums.State;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "city")
@ApiModel("City")
public class City {
	
	@ApiModelProperty(value = "Identification code", example = "1")
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "City name", example = "Recife")
	@Column
	private String name;
	
	@ApiModelProperty(value = "State", example = "PE, SP, RJ")
	@Enumerated(EnumType.STRING)
	@Column
	private State state;

}
