package com.bigmoim.module.member.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {
    private Integer roleIdx;
    private String memberId;
    private String role;
    private LocalDateTime createDate;

    public void setRoleIdx(Integer roleIdx){this.roleIdx = roleIdx;}
    public void setMemberId(String memberId){this.memberId = memberId;}
    public void setRole(String Role){this.role = Role;}
    public void setCreate_date(LocalDateTime createDate){this.createDate = createDate;}

    @Override
    public String toString() {
        return "RoleEntity [roleIdx=" + roleIdx + ", memberId=" + memberId + ", " +
                "role=" + role + ", createDate=" + createDate + "]";
    }
}
