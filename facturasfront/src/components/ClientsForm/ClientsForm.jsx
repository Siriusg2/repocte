import { useState } from "react";
import axios from "axios";

const ClienteForm = () => {
  const [clienteData, setClienteData] = useState({
    identificacion: "",
    nombre: "",
    direccion: "",
    telefono: "",
    correo: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setClienteData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("/customers/create", clienteData);
      console.log(response.data);

      // Limpiar el formulario después de guardar el cliente
      setClienteData({
        identificacion: "",
        nombre: "",
        direccion: "",
        telefono: "",
        correo: "",
      });
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="identificacion">Identificación</label>
      <input
        type="text"
        id="identificacion"
        name="identificacion"
        value={clienteData.identificacion}
        onChange={handleChange}
      />

      <label htmlFor="nombre">Nombre</label>
      <input
        type="text"
        id="nombre"
        name="nombre"
        value={clienteData.nombre}
        onChange={handleChange}
      />

      <label htmlFor="direccion">Dirección</label>
      <input
        type="text"
        id="direccion"
        name="direccion"
        value={clienteData.direccion}
        onChange={handleChange}
      />

      <label htmlFor="telefono">Teléfono</label>
      <input
        type="text"
        id="telefono"
        name="telefono"
        value={clienteData.telefono}
        onChange={handleChange}
      />

      <label htmlFor="correo">Correo</label>
      <input
        type="email"
        id="correo"
        name="correo"
        value={clienteData.correo}
        onChange={handleChange}
      />

      <button type="submit">Guardar Cliente</button>
    </form>
  );
};

export default ClienteForm;
