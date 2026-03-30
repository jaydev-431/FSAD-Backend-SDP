package com.klef.sdp.sdpbackend.service;

import java.util.List;

import com.klef.sdp.sdpbackend.entity.Discussion;
import com.klef.sdp.sdpbackend.entity.Report;

public interface CitizenService {
public void addReport(Report rep);
public List<Discussion> viewDiscussions();
public String addComment(Discussion d);

}
