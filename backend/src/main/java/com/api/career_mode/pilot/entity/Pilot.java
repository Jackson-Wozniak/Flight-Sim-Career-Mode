package com.api.career_mode.pilot.entity;

import com.api.career_mode.career_paths.local_license.LocalLicense;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity(name = "pilot")
@Table(name = "pilot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pilot implements UserDetails {

    @Id
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy="pilot",cascade=CascadeType.ALL)
    private LocalLicense localLicense;

    @Enumerated(EnumType.STRING)
    private final PilotRole pilotRole = PilotRole.USER;
    private final Boolean locked = false;
    private final Boolean enabled = true;

    public Pilot(String username, String password){
        this.username = username;
        this.password = password;
        this.localLicense = new LocalLicense(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(pilotRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
