package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.mahasiswaModel;

@Mapper
public interface mahasiswaMapper
{
    @Select("select npm, nama, agama from mahasiswa where npm = #{npm}")
    mahasiswaModel selectmahasiswa (@Param("npm") String npm);

    @Select("select npm, nama, agama from mahasiswa")
    List<mahasiswaModel> selectAllmahasiswas ();

    @Insert("INSERT INTO mahasiswa (npm, nama, agama) VALUES (#{npm}, #{nama}, #{agama})")
    boolean addmahasiswa (mahasiswaModel mahasiswa);
    
    @Delete("DELETE from mahasiswa where npm = #{npm}")
    boolean deletemahasiswa (@Param("npm") String npm);
    
    @Update("UPDATE mahasiswa set nama = #{nama}, agama = #{agama} where npm = #{npm}")
    boolean updatemahasiswa (mahasiswaModel mahasiswa);
}
