package com.wwwgomes.customermanager.domain.exception.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ErrorItem implements Serializable {

	private static final long serialVersionUID = 2742619349592940845L;

	@EqualsAndHashCode.Include
	private String fieldName;
	@EqualsAndHashCode.Include
	private String message;

}