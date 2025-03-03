package com.satgat.project_manager_backend.model.vo;

import java.sql.Date;

public record UserVO(String userId, String name, String password, String email, String status,
        Date regDate, Date modDate) {
}
