package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "role")
@Entity
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nameRoles;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserRole> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nameRoles='" + nameRoles + '\'' +
                '}';
    }
}
