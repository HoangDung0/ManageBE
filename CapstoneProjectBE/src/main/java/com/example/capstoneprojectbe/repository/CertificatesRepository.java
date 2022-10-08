package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.Certificates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificatesRepository extends JpaRepository<Certificates, String> {
    @Query("select certificate from Certificates certificate where certificate.user.userID = :userID")
    List<Certificates> getCertificatesByUserID(String userID);
}
