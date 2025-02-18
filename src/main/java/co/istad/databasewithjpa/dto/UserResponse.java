package co.istad.databasewithjpa.dto;

import java.util.List;

public record UserResponse(
        Long id,
        String username,
        String email,
        List<String> roles
) {
}
