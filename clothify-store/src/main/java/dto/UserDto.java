package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String userId;
    String userName;
    String password;
    String type;
}
