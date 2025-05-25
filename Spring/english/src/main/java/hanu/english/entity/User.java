package hanu.english.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "User")
@DynamicInsert // insert bo qua cot null
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tranh de khong tao them bang quan li khoa chinh
    private Long id;

    @Column(name = "name", nullable = false,length = 255)
    private String name;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    private String password;

    private Set<String> roles;
}
