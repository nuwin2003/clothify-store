package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    int userId;
    String userName;
    String password;
    String email;
    String contactNumber;
    String type;
}
