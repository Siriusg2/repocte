package com.facturas.cte.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.facturas.cte.models.RoleModel;

@Service
public interface RoleService {
    List<RoleModel> getAllRoles() throws Exception;
   

    RoleModel saveRole(RoleModel roleData) throws Exception;
    Boolean deteleRole(Long idRole) throws Exception;
    RoleModel updateRole(Long irRole, RoleModel newRoleData ) throws Exception;
}
