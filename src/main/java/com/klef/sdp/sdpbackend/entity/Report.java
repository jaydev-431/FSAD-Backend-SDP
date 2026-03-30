package com.klef.sdp.sdpbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Report {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPollingStation() {
		return pollingStation;
	}

	public void setPollingStation(String pollingStation) {
		this.pollingStation = pollingStation;
	}

	public Observer getObserver() {
		return observer;
	}

	public void setObserver(Observer observer) {
		this.observer = observer;
	}

	private String description;
    private String issueType;
    private String status;

    private String pollingStation;

    @ManyToOne
    private Observer observer;

    // getters & setters
}