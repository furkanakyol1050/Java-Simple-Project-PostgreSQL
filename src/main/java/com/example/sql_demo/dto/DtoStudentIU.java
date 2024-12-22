package com.example.sql_demo.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// String name;         BLANK
// String name = "";    EMPTY
// String name = null;  NULL

// Ctrl + Q ile ortasına tıkladığımız fonksiyon veya sınıfın bilgilerini açabiliriz.

// Validation kullanımı
// 1. Değişkenlerin üzerine anatasyon tanımla
// 2. Bu kontrolleri yapmasını istediğin yere (yani parametre olarak geçildiği controller)
//      @Valil yaz. (örn: (@RequestBody @Valid DtoStudentIU dtoStudentIU))
// 3. Düzgün gözükmesi için GlobalExceptionHandler oluştur

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "İsim alanı boş bırakılamaz!") // null veya empty olamaz
    private  String name;

    private  String surname;

    @Temporal(TemporalType.DATE)
    private Date birthOfDay;
}
