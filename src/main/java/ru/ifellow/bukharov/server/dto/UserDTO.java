package ru.ifellow.bukharov.server.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String password;
}
