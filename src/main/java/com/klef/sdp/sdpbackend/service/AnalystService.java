package com.klef.sdp.sdpbackend.service;

import com.klef.sdp.sdpbackend.entity.Analyst;
import com.klef.sdp.sdpbackend.entity.Issue;
import java.util.List;

public interface AnalystService {
    Analyst verifyAnalystLogin(String email, String pwd);

    List<Issue> viewAllIssues();
    List<Issue> viewAllProblems();
    Issue solveIssue(Long id);
    String detectFraud();
    String analyzeTrends();
    Issue updateIssueStatus(Long id, String status);
    List<Issue> getIssuesByRegion(String region);
    Object getDashboardStats();
    String generateReport();
}
