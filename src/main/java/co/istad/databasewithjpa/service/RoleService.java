package co.istad.databasewithjpa.service;


import co.istad.databasewithjpa.dto.RoleRequest;
import co.istad.databasewithjpa.dto.RoleResponse;
import co.istad.databasewithjpa.entities.Role;
import co.istad.databasewithjpa.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public void createRole(RoleRequest roleRequest) {

        Role role = new Role();

        role.setId(UUID.randomUUID().toString());
        role.setRoleName(roleRequest.roleName());
        role.setRoleDescription(roleRequest.roleDescription());

        roleRepository.save(role);

    }


    public List<RoleResponse> getAllRoles() {

        List<Role> roles = roleRepository.findAll();

        return roles.stream()
                .map(role -> new RoleResponse(role.getId(),
                        role.getRoleName(),
                        role.getRoleDescription()))
                .toList();

    }
}
