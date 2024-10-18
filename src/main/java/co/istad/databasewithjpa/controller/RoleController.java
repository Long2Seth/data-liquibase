package co.istad.databasewithjpa.controller;


import co.istad.databasewithjpa.dto.RoleRequest;
import co.istad.databasewithjpa.dto.RoleResponse;
import co.istad.databasewithjpa.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public void createRole(RoleRequest roleRequest) {
        roleService.createRole(roleRequest);
    }

    @GetMapping
    public List<RoleResponse> getAllRoles() {
        return  roleService.getAllRoles();
    }


}
