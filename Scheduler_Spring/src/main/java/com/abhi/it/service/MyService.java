package com.abhi.it.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class MyService {
	
	@Scheduled(fixedRate = 2000)
	public void getScheduled() {
		System.out.println("report generated......");
	}
	
	@Scheduled(fixedDelay = 2000)
	public void getScheduledDelay() {
		System.out.println("report generated......");
	}
	
	@Scheduled(cron = "* * * * * *")
	public void getScheduledCron() {
		System.out.println("report generated......");
	}

}
