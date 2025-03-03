package com.satgat.project_manager_backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.satgat.project_manager_backend.model.dto.LoginDTO;
import com.satgat.project_manager_backend.model.vo.UserVO;

@Mapper
public interface LoginMapper {
    UserVO findByUserId(LoginDTO dto);
}
