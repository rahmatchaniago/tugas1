package com.example.service;

import java.util.List;

import com.example.model.mahasiswaModel;

public interface mahasiswaService
{
    mahasiswaModel selectmahasiswa (String npm);


    List<mahasiswaModel> selectAllmahasiswas ();


    boolean addmahasiswa (mahasiswaModel mahasiswa);


    boolean deletemahasiswa (String npm);
    
    
    boolean updatemahasiswa (mahasiswaModel mahasiswa);
}
