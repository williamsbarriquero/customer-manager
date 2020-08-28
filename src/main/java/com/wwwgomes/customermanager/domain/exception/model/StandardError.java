package com.wwwgomes.customermanager.domain.exception.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {

	private static final long serialVersionUID = -2166865923471144622L;

	private Long timestamp;
	private Integer status;
	private String error;
	private List<ErrorItem> validations = new ArrayList<>();
	private String message;
	private String path;

}
