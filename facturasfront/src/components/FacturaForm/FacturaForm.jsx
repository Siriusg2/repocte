import { useState } from "react";
import axios from "axios";

const FacturaForm = () => {
  const [facturaData, setFacturaData] = useState({
    establecimiento: "",
    puntoEmision: "",
    numeroFactura: "",
    fecha: "",
    subtotal: 0,
    totalIVA: 0,
    total: 0,
    detalles: [],
    cliente: "",
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFacturaData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleDetalleChange = (event, index) => {
    const { name, value } = event.target;
    const detalles = [...facturaData.detalles];
    detalles[index][name] = value;
    setFacturaData((prevState) => ({
      ...prevState,
      detalles,
    }));
  };

  const handleAddDetalle = () => {
    setFacturaData((prevState) => ({
      ...prevState,
      detalles: [
        ...prevState.detalles,
        { producto: "", cantidad: 0, precioUnitario: 0 },
      ],
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await axios.post("/facturas/create", facturaData);
      // Procesar respuesta o redirigir a otra página
    } catch (error) {
      // Manejar error
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="establecimiento">Establecimiento</label>
      <input
        type="text"
        name="establecimiento"
        value={facturaData.establecimiento}
        onChange={handleChange}
      />

      <label htmlFor="puntoEmision">Punto de Emisión</label>
      <input
        type="text"
        name="puntoEmision"
        value={facturaData.puntoEmision}
        onChange={handleChange}
      />

      <label htmlFor="numeroFactura">Número de Factura</label>
      <input
        type="text"
        name="numeroFactura"
        value={facturaData.numeroFactura}
        onChange={handleChange}
      />

      <label htmlFor="fecha">Fecha de Factura</label>
      <input
        type="date"
        name="fecha"
        value={facturaData.fecha}
        onChange={handleChange}
      />

      <label htmlFor="subtotal">Subtotal</label>
      <input
        type="number"
        name="subtotal"
        value={facturaData.subtotal}
        onChange={handleChange}
      />

      <label htmlFor="totalIVA">Total IVA</label>
      <input
        type="number"
        name="totalIVA"
        value={facturaData.totalIVA}
        onChange={handleChange}
      />

      <label htmlFor="total">Total</label>
      <input
        type="number"
        name="total"
        value={facturaData.total}
        onChange={handleChange}
      />

      <label htmlFor="cliente">Cliente</label>
      <input
        type="text"
        name="cliente"
        value={facturaData.cliente}
        onChange={handleChange}
      />

      <h3>Detalles de la Factura</h3>
      {facturaData.detalles.map((detalle, index) => (
        <div key={index}>
          <label htmlFor={`producto-${index}`}>Producto</label>
          <input
            type="text"
            name="producto"
            value={detalle.producto}
            onChange={(event) => handleDetalleChange(event, index)}
          />

          <label htmlFor={`cantidad-${index}`}>Cantidad</label>
          <input
            type="number"
            name="cantidad"
            value={detalle.cantidad}
            onChange={(event) => handleDetalleChange(event, index)}
          />

          <label htmlFor={`precioUnitario-${index}`}>Precio Unitario</label>
          <input
            type="number"
            name="precioUnitario"
            value={detalle.precioUnitario}
            onChange={(event) => handleDetalleChange(event, index)}
          />
        </div>
      ))}
      <button type="button" onClick={handleAddDetalle}>
        Agregar Detalle
      </button>

      <button type="submit">Guardar</button>
    </form>
  );
};

export default FacturaForm;
