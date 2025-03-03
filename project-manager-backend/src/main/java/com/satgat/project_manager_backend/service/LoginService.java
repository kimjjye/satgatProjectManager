package com.satgat.project_manager_backend.service;

import org.springframework.stereotype.Service;

import com.satgat.project_manager_backend.mapper.LoginMapper;
import com.satgat.project_manager_backend.model.dto.LoginDTO;
import com.satgat.project_manager_backend.model.vo.UserVO;

@Service
public class LoginService {
    private final LoginMapper loginMapper;

    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    /**
     * 로그인 요청을 처리하여 로그인 성공 여부를 반환
     *
     * @param loginDTO 로그인 요청 정보 (아이디, 비밀번호 등)
     * @return 로그인 성공 시 true, 실패 시 false
     */
    public boolean login(LoginDTO loginDTO) {
        UserVO user = loginMapper.findByUserId(loginDTO);
        if (user != null && isPasswordCorrect(loginDTO.password(), user.password())) {
            return true;
        }
        return false;
    }

    /**
     * 입력된 비밀번호와 암호화된 비밀번호가 일치하는지 확인
     *
     * @param inputPassword 사용자 입력 비밀번호
     * @param encryptedPassword DB에 저장된 암호화된 비밀번호
     * @return 비밀번호가 일치하면 true, 그렇지 않으면 false
     */
    private boolean isPasswordCorrect(String rawPassword, String encryptedPassword) {
        // #TODO 암호화 해제 로직 구현 필요
        return encryptedPassword.equals(rawPassword);
    }
}
