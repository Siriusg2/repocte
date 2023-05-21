import { useState } from "react";
import { useDispatch } from "react-redux";

import { saveClient } from "../../redux/actions";

const ClienteForm = () => {
  const dispatch = useDispatch();
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

  const handleSubmit = async (e, clientData) => {
    e.preventDefault();

    await dispatch(saveClient(clientData));

    // Limpiar el formulario después de guardar el cliente
    setClienteData({
      identificacion: "",
      nombre: "",
      direccion: "",
      telefono: "",
      correo: "",
    });
  };

  return (
    <form onSubmit={(e) => handleSubmit(e, clienteData)}>
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
