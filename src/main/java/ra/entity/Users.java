package ra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

import java.util.Date;

@Entity
@Table(name = "Users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int userId;
    @Column(name = "UserName", unique = true, nullable = false)
    private String userName;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Created")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @Column(name = "Email", nullable = false, unique = true)
    private String email;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "UserStatus")
    private boolean userStatus;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "UserId"), inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Roles> listRoles = new HashSet<>();
}
