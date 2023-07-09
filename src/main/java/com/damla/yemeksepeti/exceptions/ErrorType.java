package com.damla.yemeksepeti.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_SERVER_ERROR(1000,"Sunucuda Bilinmeyen bir hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001,"İstek formatı hatalı",HttpStatus.BAD_REQUEST),
    REGISTER_KULLANICI_ZATEN_KAYITLI(1001,"Kullanıcı zaten kayıtlı",HttpStatus.BAD_REQUEST),
    NAME_IS_NULL(1001,"Name alanı boş geçilemez",HttpStatus.BAD_REQUEST),
    ID_NOT_FOUND(1001,"Aradığınız id ya ait kayıt bulunamamıştır.",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1001,"Böyle bir kullanıcı bulunamamıştır.",HttpStatus.BAD_REQUEST),
    ACCOUNT_NOT_ACTIVE(1001,"Hesap aktif değil",HttpStatus.BAD_REQUEST),
    ALREADY_ACTIVE(1001,"Böyle bir hesap zaten var",HttpStatus.BAD_REQUEST),
    INVALID_CODE(1002,"Geçersiz aktivasyon kodu",HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus httpStatus;
}
