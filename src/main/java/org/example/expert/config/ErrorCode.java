package org.example.expert.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.expert.domain.manager.entity.Manager;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    COMMENT_NOT_FOUND("존재하지 않는 댓글입니다", HttpStatus.NOT_FOUND),
    TODO_NOT_FOUND("존재하지 않는 글입니다.", HttpStatus.NOT_FOUND),
    USER_NOT_FOUND("존재하지 않는 유저입니다.", HttpStatus.NOT_FOUND),
    MANAGER_NOT_FOUND("존재하지 않는 매니저입니다.",HttpStatus.NOT_FOUND),

    CANNOT_REGISTER_SELF_AS_MANAGER("일정 작성자는 본인을 담당자로 등록할 수 없습니다.", HttpStatus.BAD_REQUEST),
    SAME_AS_OLD_PASSWORD("새 비밀번호는 기존 비밀번호와 같을 수 없습니다.", HttpStatus.BAD_REQUEST),
    INVALID_CURRENT_PASSWORD("잘못된 비밀번호입니다.", HttpStatus.UNAUTHORIZED);

    private final String message;
    private final HttpStatus status;
}
