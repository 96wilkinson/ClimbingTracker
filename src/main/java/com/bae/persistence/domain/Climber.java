package com.bae.persistence.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Climber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @OneToMany(targetEntity = ClimbingAttempts.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "climber_id")
    private Set<ClimbingAttempts> climbingAttempts = new HashSet<>();

    public Climber(String username, String firstname, String surname, Set<ClimbingAttempts> getClimbingAttempts) {
        super();
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.climbingAttempts = climbingAttempts;
    }

    public Climber() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<ClimbingAttempts> getClimbingAttempts() {
        return climbingAttempts;
    }

    public void setClimbingAttempts(Set<ClimbingAttempts> climbingAttempts) {
        this.climbingAttempts = climbingAttempts;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ",climbingAttempts=" + climbingAttempts + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Climber climber = (Climber) o;
        return Objects.equals(id, climber.id) &&
                Objects.equals(username, climber.username) &&
                Objects.equals(firstname, climber.firstname) &&
                Objects.equals(surname, climber.surname) &&
                Objects.equals(climbingAttempts, climber.climbingAttempts);
    }

}
