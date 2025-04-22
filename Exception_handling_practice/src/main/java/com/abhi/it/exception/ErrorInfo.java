package com.abhi.it.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorInfo {
	private String code;
	private String message;
	private LocalDateTime date;
}
