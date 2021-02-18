package com.cgi.dentistapp.repository;//Autor: Robert Leht//autor: Robert Leht

import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DentistVisitRepository extends JpaRepository<DentistVisitEntity, Long> {

    @Query(value = "SELECT e FROM DentistVisitEntity e WHERE CONCAT(e.dentistName, ' ', e.visitTime) LIKE %?1%")
    List<DentistVisitEntity> search(@Param("keyword") String keyword);

}
