package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.CertificatesDto;
import com.example.capstoneprojectbe.model.Certificates;
import com.example.capstoneprojectbe.service.CertificatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/certificates")
public class CertificatesController {

    private final CertificatesService certificatesService;

    public CertificatesController(CertificatesService certificatesService) {
        this.certificatesService = certificatesService;
    }


    @PostMapping("/create")
    public ResponseEntity createPlan(@RequestBody CertificatesDto dto) {// lấy dữ liệu tryền vào dto
        if(certificatesService.isExisted(dto.getCertificateID())){
            return ResponseEntity.badRequest().body("Id is duplicated");
        }
//        if(planService.isExistedUserIDAndDateAndShift(dto.getUserID(), dto.getDate(), dto.getShift())){
//            return ResponseEntity.badRequest().body("UserID & Date & Shift is duplicated");
//        }
        // tạo annoation//?
        certificatesService.createCertificates(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<Certificates> certificatesList = certificatesService.getAll();
        return ResponseEntity.ok().body(certificatesList);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody CertificatesDto dto) {
        certificatesService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        certificatesService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-user-id")
    private ResponseEntity getByUserId(@RequestParam String id) {
        List<Certificates> certificatesList = certificatesService.getByUserId(id);
        return ResponseEntity.ok().body(certificatesList);
    }
}
