package com.abhi.it.binding;

import java.io.Serializable;

import lombok.Data;

@Data
public class Countries implements Serializable{

	private Integer sno;
	private String name;
	private String code;
}
