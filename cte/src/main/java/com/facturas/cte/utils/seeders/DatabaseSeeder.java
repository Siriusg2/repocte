package com.facturas.cte.utils.seeders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.facturas.cte.models.*;
import com.facturas.cte.repositories.ClienteRepository;
import com.facturas.cte.repositories.ProductoRepository;
import com.facturas.cte.repositories.RoleRepository;
import com.facturas.cte.repositories.UsuarioRepository;

@Component
public class DatabaseSeeder implements ApplicationRunner {

  @Autowired
  private RoleRepository rolesRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private ProductoRepository productoRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    
    createRoles();
  
    createUsers();
    createClients();
    createProducts();
    System.out.println("Seeders finished" );
  }

  private void createRoles() {
    RoleModel role1 = new RoleModel();
    role1.setNombre("Administrador");
    
    RoleModel role2 = new RoleModel();
    role2.setNombre("Supervisor");
    
    RoleModel role3 = new RoleModel();
    role3.setNombre("Vendedor");
    
    rolesRepository.save(role1);
    rolesRepository.save(role2);
    rolesRepository.save(role3);
    
  }

  
  private void createUsers() {
    RoleModel rolAdmin = rolesRepository.findById(1L).get();
    RoleModel rolSupervisor = rolesRepository.findById(2L).get();
    RoleModel rolVendedor = rolesRepository.findById(3L).get();

 

    UsuarioModel user1 = new UsuarioModel();
    user1.setEmail("user1@example.com");
    user1.setPassword("password1");
    user1.setRole(rolAdmin);

    UsuarioModel user2 = new UsuarioModel();
    user2.setEmail("user2@example.com");
    user2.setPassword("password2");
    user2.setRole(rolSupervisor);
    
    UsuarioModel user3 = new UsuarioModel();
    user3.setEmail("user3@example.com");
    user3.setPassword("password3");
    user3.setRole(rolVendedor);

    usuarioRepository.save(user1);
    usuarioRepository.save(user2);
    usuarioRepository.save(user3);
    
  }

  public void createClients(){


    ClienteModel client1 = new ClienteModel();

    client1.setIdentificacion("0963312441");
    client1.setNombre("Carlos Bravo");
    client1.setDireccion("Gomez rendon #2016");
    client1.setTelefono("0982023693");
    client1.setCorreo("cliente1@example.com");

    ClienteModel client2 = new ClienteModel();
    client2.setIdentificacion("0963312551");
    client2.setNombre("Luis Lopez");
    client2.setDireccion("Gomez rendon #2015");
    client2.setTelefono("0982028893");
    client2.setCorreo("cliente2@example.com");
    
    ClienteModel client3 = new ClienteModel();
    client3.setIdentificacion("0963314441");
    client3.setNombre("Carlos Bravo");
    client3.setDireccion("Gomez rendon #2017");
    client3.setTelefono("0982023693");
    client3.setCorreo("cliente3@example.com");

    ClienteModel client4 = new ClienteModel();
    client4.setIdentificacion("0863312441");
    client4.setNombre("Carlos Bravo");
    client4.setDireccion("Gomez rendon #2013");
    client4.setTelefono("0982023693");
    client4.setCorreo("cliente4@example.com");


    clienteRepository.save(client1);
    clienteRepository.save(client2);
    clienteRepository.save(client3);
    clienteRepository.save(client4);
    
}

public void createProducts() {



    ProductoModel product1 = new ProductoModel();
    ProductoModel product2 = new ProductoModel();
    ProductoModel product3 = new ProductoModel();
    ProductoModel product4 = new ProductoModel();
    ProductoModel product5 = new ProductoModel();
    ProductoModel product6 = new ProductoModel();
    ProductoModel product7 = new ProductoModel();
    ProductoModel product8 = new ProductoModel();
    ProductoModel product9 = new ProductoModel();
    ProductoModel product10 = new ProductoModel();


    product1.setCodigo("a001");
    product2.setCodigo("a002");
    product3.setCodigo("a003");
    product4.setCodigo("a004");
    product5.setCodigo("a005");
    product6.setCodigo("a006");
    product7.setCodigo("a007");
    product8.setCodigo("a008");
    product9.setCodigo("a009");
    product10.setCodigo("a010");

    product1.setDescripcion("a001");
    product2.setDescripcion("a001");
    product3.setDescripcion("a001");
    product4.setDescripcion("a001");
    product5.setDescripcion("a001");
    product6.setDescripcion("a001");
    product7.setDescripcion("a001");
    product8.setDescripcion("a001");
    product9.setDescripcion("a001");
    product10.setDescripcion("a001");

  

    product1.setCategoria("hogar");
    product2.setCategoria("ropa");
    product3.setCategoria("juguetes");
    product4.setCategoria("alimentos");
    product5.setCategoria("hogar");
    product6.setCategoria("ropa");
    product7.setCategoria("juguetes");
    product8.setCategoria("alimentos");
    product9.setCategoria("juguetes");
    product10.setCategoria("ropa");

    productoRepository.save(product1);
    productoRepository.save(product2);
    productoRepository.save(product3);
    productoRepository.save(product4);
    productoRepository.save(product5);
    productoRepository.save(product6);
    productoRepository.save(product7);
    productoRepository.save(product8);
    productoRepository.save(product9);
    productoRepository.save(product10);

}
}

