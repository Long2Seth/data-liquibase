package co.istad.databasewithjpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    private String id;

    private String roleName;
    private String roleDescription;

}