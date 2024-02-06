package com.devsuperior.demo.projections;

public interface UserDetailsProjection {
    String getUsername();
    String getPassword();
    String getAuthority();
    Long getRoleId();
}
