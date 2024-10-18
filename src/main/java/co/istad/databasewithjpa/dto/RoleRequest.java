package co.istad.databasewithjpa.dto;

public record RoleRequest(
        String roleName,
        String roleDescription
) {
}
