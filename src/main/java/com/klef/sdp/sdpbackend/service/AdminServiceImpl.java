package com.klef.sdp.sdpbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.klef.sdp.sdpbackend.entity.Admin;
import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.repository.AdminRepository;
import com.klef.sdp.sdpbackend.repository.AnalystRepository;
import com.klef.sdp.sdpbackend.repository.ObserverRepository;

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminRepository adminrepo;
	
	@Autowired
	public ObserverRepository observerRepo;
	
	@Autowired
	public AnalystRepository analystRepo;

	@Override
	public Admin verifyAdminLogin(String username, String password) {
		Admin a = adminrepo.findByUsernameAndPassword(username, password);
		if(a!=null) {
			return a;
		}else {
		return null;
		}
	}

	@Override
	public List<Observer> viewAllObservers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Analyst> viewAllAnalysts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteObserver(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAnalyst(Long id) {
		analystRepo.deleteById(id);
		return "Analyst deleted successfully";
	}

	@Override
	public String addObserver(Observer ob) {
		observerRepo.save(ob);
		return "Analyst added successfully";
	}

	@Override
	public String addAnalyst(Analyst an) {
		analystRepo.save(an);
		return "Analyst added successfully";
	}

}
