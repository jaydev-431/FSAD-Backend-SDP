package com.klef.sdp.sdpbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.sdp.sdpbackend.entity.Observer;

public interface ObserverRepository extends JpaRepository<Observer, Long>{
	Optional<Observer> findByUsername(String username);
}
