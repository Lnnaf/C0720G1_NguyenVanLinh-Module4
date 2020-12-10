package com.project.entity;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    WebUser webUser;
    @ManyToOne
    @JoinColumn(name = "id_role")
    WebRole webRole;

    public UserRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public WebRole getWebRole() {
        return webRole;
    }

    public void setWebRole(WebRole webRole) {
        this.webRole = webRole;
    }
}
