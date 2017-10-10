package com.arief.springboot.springngresource.services;


import com.arief.springboot.springngresource.model.Mahasiswa;
import com.arief.springboot.springngresource.model.enums.Gender;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MahasiswaRepo extends CrudRepository<Mahasiswa,String>{

    @Transactional
    @Modifying
    @Query(
            "update Mahasiswa  m set m.nama = :nama , m.gender = :gender where m.nim = :nim"
    )
    void updateData(@Param("nama")String nama , @Param("gender")Gender gender , @Param("nim")String nim );

    @Transactional
    void deleteMahasiswaByNim(String nim);
}
