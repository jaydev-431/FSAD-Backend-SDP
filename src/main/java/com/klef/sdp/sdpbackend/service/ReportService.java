package com.klef.sdp.sdpbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.entity.Observer;
import com.klef.sdp.sdpbackend.entity.Report;
import com.klef.sdp.sdpbackend.repository.ObserverRepository;
import com.klef.sdp.sdpbackend.repository.ReportRepository;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepo;

    @Autowired
    private ObserverRepository userRepo;

    public Report createReport(Report report, String username) {
        Observer user = userRepo.findByUsername(username).orElseThrow();

        report.setObserver(user);
        report.setStatus("PENDING");

        return reportRepo.save(report);
    }

    public List<Report> getReports(String username) {
        Observer user = userRepo.findByUsername(username).orElseThrow();
        return reportRepo.findByObserverId(user.getId());
    }
}