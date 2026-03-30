package com.klef.sdp.sdpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}
