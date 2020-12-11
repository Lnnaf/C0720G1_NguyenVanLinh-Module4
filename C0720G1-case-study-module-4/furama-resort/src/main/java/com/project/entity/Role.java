package com.project.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer roleId;
    private String roleName;
    @ManyToMany()
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "username"))
    private Set<WebUser> webUsers;

    public Role() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<WebUser> getWebUsers() {
        return webUsers;
    }

    public void setWebUsers(Set<WebUser> webUsers) {
        this.webUsers = webUsers;
    }
}
