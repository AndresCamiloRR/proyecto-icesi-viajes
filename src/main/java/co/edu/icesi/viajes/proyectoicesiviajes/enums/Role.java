package co.edu.icesi.viajes.proyectoicesiviajes.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    VIEWER,
    AGENT;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
