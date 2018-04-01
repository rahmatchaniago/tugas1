package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.mahasiswaMapper;
import com.example.model.mahasiswaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class mahasiswaServiceDatabase implements mahasiswaService
{
    @Autowired
    private mahasiswaMapper mahasiswaMapper;

    public mahasiswaServiceDatabase(mahasiswaMapper mahasiswaMapper) {
    	this.mahasiswaMapper = mahasiswaMapper;
    }
    
    public mahasiswaServiceDatabase() {
    	
    }

    @Override
    public mahasiswaModel selectmahasiswa (String npm)
    {
        log.info ("select mahasiswa with npm {}", npm);
        return mahasiswaMapper.selectmahasiswa (npm);
    }


    @Override
    public List<mahasiswaModel> selectAllmahasiswas ()
    {
        log.info ("select all mahasiswas");
        return mahasiswaMapper.selectAllmahasiswas ();
    }


    @Override
    public boolean addmahasiswa (mahasiswaModel mahasiswa)
    {
    	return mahasiswaMapper.addmahasiswa (mahasiswa);
    }


    @Override
    public boolean deletemahasiswa (String npm)
    {
    	log.info ("mahasiswa " + npm + " deleted");
    	return mahasiswaMapper.deletemahasiswa(npm);
    }
    
    @Override
    public boolean updatemahasiswa(mahasiswaModel mahasiswa)
    {
    	log.info ("mahasiswa " + mahasiswa.getNpm() + " updated");
    	return mahasiswaMapper.updatemahasiswa (mahasiswa);
    }

}
