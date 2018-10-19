package com.wlcxbj.tcp.model;

import lombok.Data;
import java.util.Date;
@Data
public class EndUserModel {
    private Long id;
    private String loginName;
    private boolean accountnonexpired;
    private boolean accountnonlocked;
    private boolean credentialsnonexpired;
    private Date createdTime;
    private Date updatedTime;
    private String role;

}
