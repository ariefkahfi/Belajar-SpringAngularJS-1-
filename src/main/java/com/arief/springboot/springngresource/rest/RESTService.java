package com.arief.springboot.springngresource.rest;

import com.arief.springboot.springngresource.model.Mahasiswa;
import com.arief.springboot.springngresource.services.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTService {

    @Autowired
    private MahasiswaRepo mhsRepo;


    @GetMapping(value = "/mhs")
    public List<Mahasiswa> findAllApi(){
        return (List<Mahasiswa>) mhsRepo.findAll();
    }

    @PostMapping(value = "/mhs",produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity saveApi(@RequestBody Mahasiswa mahasiswa){
        try {
            mhsRepo.save(mahasiswa);
            return new ResponseEntity<String>("Data berhasil dimasukkan ke dalam database",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<String>("Error : " + ex.getMessage() ,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/mhs/{nim}",produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity updateApi(@RequestBody Mahasiswa mahasiswa ,@PathVariable String nim){
        try{
            mhsRepo.updateData(mahasiswa.getNama(),mahasiswa.getGender(),nim);
            return new ResponseEntity<String>("Data berhasil di update",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<String>("Error-update : " + ex.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/mhs/{nim}",produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity deleteApi(@PathVariable String nim){
        try {
            mhsRepo.deleteMahasiswaByNim(nim);
            return new ResponseEntity<String>("Data berhasil dihapus",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<String>("Error-delete : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
