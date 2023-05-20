import Navbar from "./components/navabar/Navbar";
import "bootstrap/dist/css/bootstrap.css";

import { getAllClients, getAllFacturas, getAllProducts } from "./redux/actions";

import LoginForm from "./components/loginform/Loginform";
import FacturaForm from "./components/FacturaForm/FacturaForm";
import ProductoForm from "./components/ProductForm/ProductoForm";
import { useDispatch } from "react-redux";
import { useEffect } from "react";
import { Routes, Route, useNavigate } from "react-router-dom";
import Cards from "./components/Cards/Cards";

function App() {
  const dataUser = JSON.parse(localStorage.getItem("userData")) || {};
  const navigate = useNavigate("");
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getAllClients());
    dispatch(getAllProducts());
    dispatch(getAllFacturas());
    return () => {
      if (dataUser.email && dataUser.password && dataUser.role.id) {
        navigate("/home");
      } else {
        navigate("/");
      }
    };
  }, []);
  return (
    <div className="App">
      <Navbar />
      <Routes>
        <Route exact path="/" element={<LoginForm />} />
        <Route path="/home" element={<Cards />} />

        <Route exact path="/factura/create" element={<FacturaForm />} />
        <Route exact path="/producto/create" element={<ProductoForm />} />
      </Routes>
    </div>
  );
}

export default App;
