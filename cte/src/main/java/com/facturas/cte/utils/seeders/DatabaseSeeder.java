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
    client1.setNombre("Daniel Puertas");
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
    client3.setNombre("Teresa Moron");
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

    product1.setDescripcion("Renueva tu hogar con este juego de sábanas de algodón de alta calidad. Suavidad y comodidad garantizadas para un descanso reparador. Incluye sábana ajustable, sábana plana y fundas de almohada. Dale un toque de estilo a tu dormitorio con este conjunto imprescindible.");
    product2.setDescripcion("Eleva tu estilo con esta blusa de seda estampada. Diseño exclusivo y detalles delicados para un look único. Tejido de seda suave y ligero que te brinda lujo y comodidad. Ideal para ocasiones especiales o un toque de elegancia en tu día a día.");
    product3.setDescripcion("Despierta la imaginación de tus hijos con este set de construcción. Piezas coloridas y versátiles para crear infinitas estructuras. Fomenta la creatividad y la destreza manual. Material seguro y resistente para horas de diversión sin preocupaciones.");
    product4.setDescripcion("Disfruta de este delicioso chocolate con leche. Su sabor exquisito y textura cremosa te deleitarán en cada bocado. Ideal para satisfacer tus antojos y compartir momentos dulces con tus seres queridos.");
    product5.setDescripcion("Ilumina tu sala de estar con estas modernas lámparas de mesa. Combina estilo y funcionalidad para crear un ambiente acogedor. Diseño elegante con base de metal resistente y pantalla de tela suave. Un complemento ideal para cualquier decoración.");
    product6.setDescripcion("Actualiza tu armario con este abrigo de lana para mujer. Diseño clásico y atemporal para enfrentar el frío con estilo. Corte elegante que resalta tu figura y tejido de lana para abrigarte en los días más fríos. Una prenda versátil para lucir sofisticada en cualquier ocasión.");
    product7.setDescripcion("Sorprende a tus hijos con este adorable peluche interactivo. Suave y mimoso compañero que habla, canta y baila. Sensor táctil para reaccionar a las caricias. Proporciona horas de entretenimiento y se convertirá en su mejor amigo.");
    product8.setDescripcion("Prueba este nutritivo cereal de avena con frutas. Desayuno saludable y delicioso que te brinda energía para comenzar el día. Mezcla de sabores y texturas para una experiencia única. Cuida tu alimentación sin sacrificar el sabor.");
    product9.setDescripcion("Despierta la creatividad y la diversión con este emocionante juego de construcción. Crea tus propios robots, naves espaciales y criaturas fantásticas con las piezas modulares. Desafía tu ingenio y desarrolla habilidades STEM mientras exploras un mundo de posibilidades. ¡Deja volar tu imaginación y diviértete construyendo aventuras sin límites!");
    product10.setDescripcion("Expresa tu estilo con esta elegante chaqueta de cuero. Diseñada con atención a los detalles y fabricada con materiales de alta calidad, esta chaqueta te brinda un look sofisticado y a la moda. Combínala con jeans o una falda para lucir impresionante en cualquier ocasión. ¡Destaca entre la multitud con esta prenda única!");

  

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

