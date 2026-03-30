package com.klef.sdp.sdpbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klef.sdp.sdpbackend.service.AdminService;

@RestController
@RequestMapping("/admin_api")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	public AdminService adminservice;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Home() {
		return "SDP Backend project ";
	}
//	
//	@RequestMapping(value="/viewallobservers",method=RequestMethod.GET)
//	public List<Obersvers> viewAllObservers(){
//		
//	}
	
}
