package com.amigosinvisibles.gdp.model;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 *
 * @author Julito
 */
@Entity
@Table(name="users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(name = "user_name",nullable = false,unique = true)
    private String userName;

    @Column(name="first_name",nullable = false)
    private String firstName;
    
    @Column(name="last_name",nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(name="birth_date",nullable = false)
    private Date birthDate;

    @NotNull
    private String nationality;

    @ManyToMany(mappedBy = "usuarios")
    private List<Gusto> gustos;
    
    public User(){
        super();
    }

    public User(@NotNull String email,@NotNull String userName, @NotNull String firstName,@NotNull String lastName, @NotNull String password, Date birthDate, String natioality) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthDate = birthDate;
        this.nationality = natioality;
        this.userName=userName;
    }

    public User(@NotNull String email,@NotNull String userName, @NotNull String firstName,@NotNull String lastName, @NotNull String password, Date birthDate, String nationality, List<Gusto> gustos) {
        this.email = email;
        this.userName=userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.gustos = gustos;
    }

    public User(Long id, @NotNull String email,@NotNull String userName, @NotNull String firstName,@NotNull String lastName, @NotNull String password, Date birthDate, String nationality, List<Gusto> gustos) {
        this.id = id;
        this.email = email;
        this.userName=userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.gustos = gustos;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void addGusto(Gusto gusto){
        if(this.gustos == null){
            this.gustos = new ArrayList<>();
        }
        this.gustos.add(gusto);
    }

    public List<Gusto> getGustos() {
        return gustos;
    }

    public void setGustos(List<Gusto> gustos) {
        this.gustos = gustos;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality= nationality;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.email;
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
