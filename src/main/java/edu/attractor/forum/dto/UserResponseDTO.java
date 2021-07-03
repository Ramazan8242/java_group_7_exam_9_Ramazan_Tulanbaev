package edu.attractor.forum.dto;

import edu.attractor.forum.model.User;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class UserResponseDTO {
    private int id;
    private String username;
    private String email;

    public static UserResponseDTO from(User user) {
        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
