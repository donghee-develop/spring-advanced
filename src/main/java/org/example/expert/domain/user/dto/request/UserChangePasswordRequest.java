package org.example.expert.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordRequest {

    @NotBlank
    @Size(max = 8)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{8,}$")
    private String oldPassword;
    @NotBlank
    private String newPassword;
}
