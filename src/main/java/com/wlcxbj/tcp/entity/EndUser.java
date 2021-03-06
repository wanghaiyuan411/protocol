package com.wlcxbj.tcp.entity;
// Generated 2017-1-24 21:12:37 by Hibernate Tools 5.2.0.CR1

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * EndUser generated by hbm2java
 */
@Entity
@Table(name = "enduser")
public class EndUser implements java.io.Serializable {

    private static final long serialVersionUID = 3906363577439260215L;
    private Long id;
    private String loginName;
    private String loginPwd;
    private boolean accountnonexpired;
    private boolean accountnonlocked;
    private boolean credentialsnonexpired;
    private Date createdTime;
    private Date updatedTime;
    private String role;
    public EndUser() {
    }

    public EndUser(String loginName, String loginPwd, boolean accountnonexpired,
                   boolean accountnonlocked, boolean credentialsnonexpired) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.accountnonexpired = accountnonexpired;
        this.accountnonlocked = accountnonlocked;
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public EndUser(String loginName, String loginPwd, boolean accountnonexpired, boolean accountnonlocked, boolean credentialsnonexpired, Date createdTime, Date updatedTime) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.accountnonexpired = accountnonexpired;
        this.accountnonlocked = accountnonlocked;
        this.credentialsnonexpired = credentialsnonexpired;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public EndUser(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "LOGIN_NAME", nullable = false, length = 16)
    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Column(name = "LOGIN_PWD", nullable = false, length = 128)
    public String getLoginPwd() {
        return this.loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Column(name = "ACCOUNTNONEXPIRED", nullable = false)
    public boolean isAccountnonexpired() {
        return this.accountnonexpired;
    }

    public void setAccountnonexpired(boolean accountnonexpired) {
        this.accountnonexpired = accountnonexpired;
    }

    @Column(name = "ACCOUNTNONLOCKED", nullable = false)
    public boolean isAccountnonlocked() {
        return this.accountnonlocked;
    }

    public void setAccountnonlocked(boolean accountnonlocked) {
        this.accountnonlocked = accountnonlocked;
    }

    @Column(name = "CREDENTIALSNONEXPIRED", nullable = false)
    public boolean isCredentialsnonexpired() {
        return this.credentialsnonexpired;
    }

    public void setCredentialsnonexpired(boolean credentialsnonexpired) {
        this.credentialsnonexpired = credentialsnonexpired;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME", length = 19)
    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_TIME", length = 19)
    public Date getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
