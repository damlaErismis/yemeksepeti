package com.damla.yemeksepeti.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class RegisterRequestDto {
    @NotEmpty(message = "İsim boş geçilemez")
    @Size(min = 3,max=64,message = "İsim 3 ile 64 karakter arasında olmalıdır")
    String name;
    @NotEmpty(message = "Soyisim boş geçilemez")
    @Size(min = 3,max=64,message = "Soyisim 3 ile 64 karakter arasında olmalıdır")
    @Size(min = 3, max = 60)
    String surname;
    @Email(message = "Lütfen Geçerli bir e-posta adresi giriniz ")
    String email;
    @NotEmpty(message = "Şifreyi boş geçemezsiniz")
    @Size(min = 8,max = 64, message = "Şifre 8 ile 64 karakter arasında olmalıdır.")
    @Pattern(
            message = "Şifre enaz 8 karakter olmalı, içinde en az bir büyük bir küçük harf sayı ve rakam olmalıdır.",
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$")
    String password;
    @NotEmpty(message = "Şifreyi boş geçemezsiniz")
    @Size(min = 8,max = 64, message = "Şifre 8 ile 64 karakter arasında olmalıdır.")
    @Pattern(
            message = "Şifre enaz 8 karakter olmalı, içinde en az bir büyük bir küçük harf sayı ve rakam olmalıdır.",
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$")
    String passwordconfirm;
}
