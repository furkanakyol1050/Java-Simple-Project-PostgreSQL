package com.example.sql_demo.repository;

import com.example.sql_demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Özel metodlar oluşturulabilir

    // HQL : sınıfın ismi ve değişkenlerin isimleri kullanılarak sorgular yazılır.
    // SQL : tablonun ismi ve kolon isimleri kullanılarak sorgular yazılır.

    // nativeQuery değişkeninin default değeri false geliyor. False haliyle kullanırsak
    // value değişkenine HQL yazmamız gerek. Ayrıca PostgreSQL de veritabanı içerisinde
    // scheme olduğu için PostgreSQL de SQL sorgusu yazarken scheme_name.table_name olacak
    // şekilde tablo adı belirtmeliyiz.

    @Query(value = "selecet * from student.student", nativeQuery = true)
    List<Student> findAllStudents();
}
