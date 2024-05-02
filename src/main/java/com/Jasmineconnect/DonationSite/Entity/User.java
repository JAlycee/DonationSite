package com.Jasmineconnect.DonationSite.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Campaign> campaigns;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Donation> donations;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}