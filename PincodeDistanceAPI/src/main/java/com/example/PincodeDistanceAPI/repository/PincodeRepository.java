package com.example.PincodeDistanceAPI.repository;

import com.example.PincodeDistanceAPI.model.Pincode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodeRepository extends JpaRepository<Pincode, String> {}
