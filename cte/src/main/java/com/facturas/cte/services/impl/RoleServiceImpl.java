package com.facturas.cte.services.impl;

import com.facturas.cte.models.RoleModel;
import com.facturas.cte.repositories.RoleRepository;
import com.facturas.cte.services.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleRepository roleRepository;

  @Override
  public List<RoleModel> getAllRoles() throws Exception {
    List<RoleModel> allRoles = roleRepository.findAll();
    return allRoles;
  }

  @Override
  public RoleModel saveRole(RoleModel roleData) throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveRole'");
  }

  @Override
  public Boolean deteleRole(Long idRole) throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'deteleRole'"
    );
  }

  @Override
  public RoleModel updateRole(Long irRole, RoleModel newRoleData)
    throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'updateRole'"
    );
  }
}
