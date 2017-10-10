package com.arief.springboot.springngresource.model;

import com.arief.springboot.springngresource.model.enums.Gender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Mahasiswa {

    @Id
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column
    private String id;

    @Column(unique = true,nullable = false)
    private String nim;

    @Column
    private String nama;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama, Gender gender) {
        this.nim = nim;
        this.nama = nama;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "id='" + id + '\'' +
                ", nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", gender=" + gender +
                '}';
    }
}
