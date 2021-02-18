package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.DentistVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DentistVisitService {

    @Autowired
    private DentistVisitRepository dentistVisitRepository;

    public DentistVisitService(DentistVisitRepository dentistVisitRepository) {
        this.dentistVisitRepository = dentistVisitRepository;
    }

    public DentistVisitService() {

    }

    public void addVisit(String dentistName, LocalDateTime visitTime) {
        //TODO implementation
        Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        DentistVisitEntity dentistVisitEntity = new DentistVisitEntity(id, dentistName, visitTime);
        dentistVisitRepository.save(dentistVisitEntity);

    }

    public void updateVisit(Long id, String dentistName, LocalDateTime visitTime) {
         DentistVisitEntity dentistVisitEntity = dentistVisitRepository.getOne(id);
         dentistVisitEntity.setDentistName(dentistName);
         dentistVisitEntity.setVisitTime(visitTime);
         dentistVisitRepository.save(dentistVisitEntity);
    }

    public List<DentistVisitEntity> getDentistVisits() {
        return dentistVisitRepository.findAll();
    }

    public DentistVisitEntity getDentistVisitById(Long id) {
        return dentistVisitRepository.findOne(id);
    }


    public void deleteDentistVisitById(Long id) {
        boolean olemas = dentistVisitRepository.exists(id);
        if (!olemas) {
            throw new IllegalStateException("Sellist visiiti ei eksisteeri.");
        }
        dentistVisitRepository.delete(getDentistVisitById(id));
    }

    public List<DentistVisitEntity> listAll(String keyword) {
        if (keyword != null) {
            return dentistVisitRepository.search(keyword);
        }
        return dentistVisitRepository.findAll();
    }

}
