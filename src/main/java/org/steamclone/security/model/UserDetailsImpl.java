package org.steamclone.security.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.steamclone.models.entities.Rol;
import org.steamclone.models.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private String username, password;
    private Collection<? extends GrantedAuthority> authorities;
    public static UserDetailsImpl build(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRol() == Rol.USER) {
            authorities.add(new SimpleGrantedAuthority("USER"));
        } else if (user.getRol() == Rol.ADMIN) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }
        return new UserDetailsImpl(user.getEmail(), user.getPassword(), authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
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
