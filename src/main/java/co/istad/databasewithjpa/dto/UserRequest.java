package co.istad.databasewithjpa.dto;

public record UserRequest(
        String username,
        String password,
        String email,
        String roleName
) {
}
