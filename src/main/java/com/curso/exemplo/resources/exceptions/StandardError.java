package com.curso.exemplo.resources.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString(doNotUseGetters = true)
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1314231405612882460L;
	
	private Integer statusHTTP;
	private String message;
	private Long timeStamp;
	
}
