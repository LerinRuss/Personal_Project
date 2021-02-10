package personal.security.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@RequiredArgsConstructor
public class User {
    @Id
    private long id;

    private final String email;
    private final String password;
}
