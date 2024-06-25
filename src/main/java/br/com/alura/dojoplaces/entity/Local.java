package br.com.alura.dojoplaces.entity;

import br.com.alura.dojoplaces.dto.UpdateLocalForm;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String name;
    @Column(unique = true)
    private String code;
    @Column(length = 100)
    private String district;
    @Column(length = 100)
    private String city;
    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;

    public Local(String name, String code, String district, String city) {
        this.name = name;
        this.code = code;
        this.district = district;
        this.city = city;
        this.creationDate = LocalDateTime.now();
    }

    public Local edit(UpdateLocalForm form) {
        this.name = form.name();
        this.code = form.code();
        this.district = form.district();
        this.city = form.city();
        this.setUpdatedDate(LocalDateTime.now());

        return this;
    }

    public Local() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
