package com.emr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.emr.model.Slot;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "credential_type")
    private String credentialType;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval= true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Slot> slots = new ArrayList<>();


    //constructors
    public Provider() {}

    public Provider(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.credentialType = "MD";
    }

    //getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
