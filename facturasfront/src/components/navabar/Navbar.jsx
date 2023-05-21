import SearchBar from "../SearchBar/SearchBar";
import { useLocation, useNavigate } from "react-router-dom";
import { AccountCircle } from "@mui/icons-material";
import styles from "./Navbar.module.css";
import { NavLink } from "react-router-dom";
import { useState } from "react";
import closeSession from "./closeSession";

function Navbar() {
  const navigate = useNavigate("");
  const dataUser = JSON.parse(localStorage.getItem("userData")) || {
    email: "",
    password: "",
    role: { id: "" },
  };
  const [isHovered, setIsHovered] = useState({
    facturas: false,
    productos: false,
    clientes: false,
    usuarios: false,
  });

  const handleMouseEnter = (key) => {
    setIsHovered((prev) => ({ ...prev, [key]: true }));
  };

  const handleMouseLeave = (key) => {
    setIsHovered((prev) => ({ ...prev, [key]: false }));
  };

  const location = useLocation();
  if (location.pathname !== "/") {
    if (dataUser.role.id === 1) {
      return (
        <nav className={styles.container}>
          <SearchBar />

          <NavLink
            onMouseEnter={() => handleMouseEnter("usuarios")}
            onMouseLeave={() => handleMouseLeave("usuarios")}
          >
            Usuarios
          </NavLink>
          {isHovered.usuarios && (
            <div className="dropdown">
              <NavLink to="/users/create">
                <button>Crear Usuario</button>
              </NavLink>
            </div>
          )}
          <NavLink
            onMouseEnter={() => handleMouseEnter("facturas")}
            onMouseLeave={() => handleMouseLeave("facturas")}
          >
            Facturas
          </NavLink>
          {isHovered.facturas && (
            <div className="dropdown">
              <NavLink to="/facturas/all">
                <button>Ver facturas</button>
              </NavLink>
              <NavLink to="/facturas/create">
                <button>Crear factura</button>
              </NavLink>
            </div>
          )}
          <NavLink
            onMouseEnter={() => handleMouseEnter("clientes")}
            onMouseLeave={() => handleMouseLeave("clientes")}
          >
            Clientes
          </NavLink>
          {isHovered.clientes && (
            <div className="dropdown">
              <NavLink to="/clientes/all">
                <button>Ver clientes</button>
              </NavLink>
              <NavLink to="/clientes/create">
                <button>Crear cliente</button>
              </NavLink>
            </div>
          )}
          <NavLink
            onMouseEnter={() => handleMouseEnter("productos")}
            onMouseLeave={() => handleMouseLeave("productos")}
          >
            Productos
          </NavLink>
          {isHovered.productos && (
            <div className="dropdown">
              <NavLink to="/productos/create">
                <button>Crear producto</button>
              </NavLink>
            </div>
          )}
          <AccountCircle />
          <span>{Object.keys(dataUser) && dataUser.email}</span>
          <button onClick={() => closeSession(navigate)}>Cerrar Sesion</button>
        </nav>
      );
    } else if (dataUser.role.id === 2) {
      return (
        <nav className={styles.container}>
          <SearchBar />

          <NavLink
            onMouseEnter={() => handleMouseEnter("facturas")}
            onMouseLeave={() => handleMouseLeave("facturas")}
          >
            Facturas
          </NavLink>
          {isHovered.facturas && (
            <div className="dropdown">
              <NavLink to="/facturas/all">
                <button>Ver facturas</button>
              </NavLink>
              <NavLink to="/facturas/create">
                <button>Crear factura</button>
              </NavLink>
            </div>
          )}
          <NavLink
            onMouseEnter={() => handleMouseEnter("clientes")}
            onMouseLeave={() => handleMouseLeave("clientes")}
          >
            Clientes
          </NavLink>
          {isHovered.clientes && (
            <div className="dropdown">
              <NavLink to="/clientes/all">
                <button>Ver clientes</button>
              </NavLink>
              <NavLink to="/clientes/create">
                <button>Crear cliente</button>
              </NavLink>
            </div>
          )}
          <NavLink
            onMouseEnter={() => handleMouseEnter("productos")}
            onMouseLeave={() => handleMouseLeave("productos")}
          >
            Productos
          </NavLink>
          {isHovered.productos && (
            <div className="dropdown">
              <NavLink to="/productos/create">
                <button>Crear producto</button>
              </NavLink>
            </div>
          )}
          <AccountCircle />
          <span>{Object.keys(dataUser).length && dataUser.email}</span>
          <button onClick={() => closeSession(navigate)}>Cerrar Sesion</button>
        </nav>
      );
    } else if (dataUser.role.id === 3) {
      return (
        <nav className={styles.container}>
          <SearchBar />

          <NavLink
            onMouseEnter={() => handleMouseEnter("facturas")}
            onMouseLeave={() => handleMouseLeave("facturas")}
          >
            Facturas
          </NavLink>
          {isHovered.facturas && (
            <div className="dropdown">
              <NavLink to="/facturas/all">
                <button>Ver facturas</button>
              </NavLink>
              <NavLink to="/facturas/create">
                <button>Crear factura</button>
              </NavLink>
            </div>
          )}
          <NavLink
            onMouseEnter={() => handleMouseEnter("clientes")}
            onMouseLeave={() => handleMouseLeave("clientes")}
          >
            Clientes
          </NavLink>
          {isHovered.clientes && (
            <div className="dropdown">
              <NavLink to="/clientes/all">
                <button>Ver clientes</button>
              </NavLink>
              <NavLink to="/clientes/create">
                <button>Crear cliente</button>
              </NavLink>
            </div>
          )}
          <NavLink
            onMouseEnter={() => handleMouseEnter("productos")}
            onMouseLeave={() => handleMouseLeave("productos")}
          >
            Productos
          </NavLink>
          {isHovered.productos && (
            <div className="dropdown">
              <NavLink to="/productos/create">
                <button>Crear producto</button>
              </NavLink>
            </div>
          )}
          <AccountCircle />
          <span>{Object.keys(dataUser) && dataUser.email}</span>
          <button onClick={() => closeSession(navigate)}>Cerrar Sesion</button>
        </nav>
      );
    }
  } else {
    return null;
  }
}

export default Navbar;
