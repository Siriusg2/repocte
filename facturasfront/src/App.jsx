import "bootstrap/dist/css/bootstrap.css";

import {
  getAllClients,
  getAllFacturas,
  getAllProducts,
  getAllUsers,
  getAllRoles,
} from "./redux/actions";

import Navbar from "./components/navabar/Navbar";
import LoginForm from "./components/loginform/Loginform";
import FacturaForm from "./components/FacturaForm/FacturaForm";
import ProductoForm from "./components/ProductForm/ProductoForm";
import ClienteForm from "./components/ClientsForm/ClientsForm";
import UsuarioForm from "./components/UsersFom/UsersForm";

import { useDispatch } from "react-redux";
import { useEffect } from "react";
import { Routes, Route, useNavigate } from "react-router-dom";
import Cards from "./components/Cards/Cards";

function App() {
  const navigate = useNavigate("");
  const dataUser = JSON.parse(localStorage.getItem("userData")) || {};
  const contition = Object.keys(dataUser).length || 0;
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getAllClients());
    dispatch(getAllProducts());
    dispatch(getAllFacturas());
    dispatch(getAllUsers());
    dispatch(getAllRoles());
    if (!contition) navigate("/");
  }, []);
  return (
    <div className="App">
      <Navbar />
      <Routes>
        <Route exact path="/" element={<LoginForm />} />
        <Route path="/home" element={<Cards />} />

        <Route exact path="/facturas/create" element={<FacturaForm />} />
        <Route exact path="/productos/create" element={<ProductoForm />} />
        <Route exact path="/clientes/create" element={<ClienteForm />} />
        <Route exact path="/users/create" element={<UsuarioForm />} />
      </Routes>
    </div>
  );
}

export default App;
