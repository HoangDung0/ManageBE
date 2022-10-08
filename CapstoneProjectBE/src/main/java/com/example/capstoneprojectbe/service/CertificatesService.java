package com.example.capstoneprojectbe.service;
import com.example.capstoneprojectbe.dto.CertificatesDto;
import com.example.capstoneprojectbe.dto.PlanDto;
import com.example.capstoneprojectbe.model.Certificates;
import com.example.capstoneprojectbe.model.Plan;
import com.example.capstoneprojectbe.repository.CertificatesRepository;
import com.example.capstoneprojectbe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificatesService {

    private final CertificatesRepository certificatesRepository;

    private final UserRepository userRepository;

    public CertificatesService(CertificatesRepository certificatesRepository, UserRepository userRepository) {
        this.certificatesRepository = certificatesRepository;
        this.userRepository = userRepository;
    }


    public boolean isExisted(String id) {
        return certificatesRepository.existsById(id);
    }

//    public boolean isExistedUserIDAndDateAndShift(String userID, String date, String shift) {
//        boolean check = false;
//        List<Plan> listPlan = planRepository.findAll();
//        for (int i = 1; i < listPlan.size(); i++) {
//            Plan dtoCheck = listPlan.get(i);
//            if(userID.equals(dtoCheck.getUser().getUserID()) && date.equals(dtoCheck.getDate()) && shift.equals(dtoCheck.getShift())) {
//                check = true;
//                break;
//            }
//        }
//        return check;
//    }

    public void createCertificates(CertificatesDto dto) {
        Certificates certificates = new Certificates();
        certificates.setCertificateID(dto.getCertificateID());
        certificates.setUser(userRepository.getById(dto.getUserID()));
        certificates.setCertificateName(dto.getCertificateName());
        certificates.setDate(dto.getDate());
        certificates.setImage(dto.getImage());
        certificates.setStatus(dto.isStatus());
        certificatesRepository.save(certificates);
    }


    public List<Certificates> getAll() {
        return certificatesRepository.findAll();
    }

    public void update(CertificatesDto dto) {
        Certificates certificates = new Certificates();
        certificates.setCertificateID(dto.getCertificateID());
        certificates.setUser(userRepository.getById(dto.getUserID()));
        certificates.setCertificateName(dto.getCertificateName());
        certificates.setDate(dto.getDate());
        certificates.setImage(dto.getImage());
        certificates.setStatus(dto.isStatus());
        certificatesRepository.save(certificates);

    }

    public void delete(String id) {
        certificatesRepository.deleteById(id);
    }

    public List<Certificates> getByUserId(String id) {
        return certificatesRepository.getCertificatesByUserID(id);
    }
}
