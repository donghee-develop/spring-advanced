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

    @Size(min = 8, message = "최소 8자리 입력해주세요")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).*$", message = "비밀번호 양식이 맞지 않습니다.")
    @NotBlank
    private String oldPassword;
    @Size(min = 8, message = "최소 8자리 입력해주세요")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).*$", message = "비밀번호 양식이 맞지 않습니다.")
    @NotBlank
    private String newPassword;
}
