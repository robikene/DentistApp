package com.cgi.dentistapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dentist_visit")
public class DentistVisitEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue /*(strategy = GenerationType.AUTO) */
    private Long id;

    //TODO implementation

    @Column(name = "dentistName")
    private String dentistName;

    @Column(name = "visitTime")
    private LocalDateTime visitTime;

    public DentistVisitEntity() {
    }

    public DentistVisitEntity(String dentistName, LocalDateTime visitTime) {
        this.dentistName = dentistName;
        this.visitTime = visitTime;
    }

    public DentistVisitEntity(Long id, String dentistName, LocalDateTime visitTime) {
        this.id = id;
        this.dentistName = dentistName;
        this.visitTime = visitTime;
    }

    public Long getId() {
        return id;
    }

    public String getDentistName() {
        return dentistName;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }


}
