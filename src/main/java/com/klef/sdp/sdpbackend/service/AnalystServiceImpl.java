package com.klef.sdp.sdpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Issue;
import com.klef.sdp.sdpbackend.repository.AnalystRepository;
import com.klef.sdp.sdpbackend.repository.IssueRepository;

import java.util.List;

@Service
public class AnalystServiceImpl implements AnalystService {

    @Autowired
    private AnalystRepository analystRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public Analyst verifyAnalystLogin(String email, String pwd) {
        Analyst a = analystRepository.findByEmail(email);
        if (a != null && a.getPassword().equals(pwd)) {
            return a;
        }
        return null;
    }

    @Override
    public List<Issue> viewAllIssues() {
        return issueRepository.findAll();
    }

    @Override
    public List<Issue> viewAllProblems() {
        return issueRepository.findAll(); // You can filter pending if needed
    }

    @Override
    public Issue solveIssue(Long id) {
        Issue issue = issueRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Issue not found"));
        issue.setStatus("SOLVED");
        return issueRepository.save(issue);
    }
}
