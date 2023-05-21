import { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { saveFactura } from "../../redux/actions";

const FacturaForm = () => {
  const dispatch = useDispatch();
  const allProducts = useSelector((state) => state.allProducts);
  const allClients = useSelector((state) => state.allClients);
  const [facturaData, setFacturaData] = useState({
    establecimiento: "001",
    puntoEmision: "001",
    fecha: "",
    subtotal: 0,
    totalIVA: 0,
    total: 0,
    detalles: [],
    cliente: {},
  });
  const [filteredClients, setFilteredClients] = useState([]);
  const [searchQuery, setSearchQuery] = useState("");
  const currentDate = new Date();
  currentDate.setDate(currentDate.getDate() - 1);
  const maxDate = currentDate.toISOString().split("T")[0];

  useEffect(() => {
    const subtotal = facturaData.detalles.reduce(
      (total, detalle) =>
        total +
        parseFloat(detalle.cantidad) * parseFloat(detalle.precioUnitario),
      0
    );
    const totalIVA = parseFloat((subtotal * 0.12).toFixed(2));
    const total = parseFloat((subtotal + totalIVA).toFixed(2));

    setFacturaData((prevState) => ({
      ...prevState,
      subtotal,
      totalIVA,
      total,
    }));
  }, [facturaData.detalles]);

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
    detalles[index][name] = parseFloat(value);
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
        { producto: "", cantidad: 0, precioUnitario: 0, unidadMedida: "unds" },
      ],
    }));
  };

  const handleSearchChange = (event) => {
    const { value } = event.target;
    setSearchQuery(value);
    const filteredClients = allClients.filter(
      (client) =>
        client.nombre.toLowerCase().includes(value.toLowerCase()) ||
        client.identificacion.toLowerCase().includes(value.toLowerCase())
    );
    setFilteredClients(filteredClients);
  };

  const handleClientSelection = (client) => {
    setFacturaData((prevState) => ({
      ...prevState,
      cliente: client,
    }));
    setSearchQuery("");
    setFilteredClients([]);
  };

  const handleSubmit = async (event, facturaData) => {
    event.preventDefault();
    await dispatch(saveFactura(facturaData));
  };

  return (
    <form onSubmit={(e) => handleSubmit(e, facturaData)}>
      <label htmlFor="fecha">Fecha de Factura</label>
      <input
        type="date"
        name="fecha"
        value={facturaData.fecha}
        onChange={handleChange}
        max={maxDate}
      />

      <label htmlFor="subtotal">Subtotal</label>
      <br />
      <span>{facturaData.subtotal.toFixed(2)}</span>
      <br />

      <label htmlFor="totalIVA">Total IVA</label>
      <br />
      <span>{facturaData.totalIVA.toFixed(2)}</span>
      <br />

      <label htmlFor="total">Total</label>
      <br />
      <span>{facturaData.total.toFixed(2)}</span>
      <br />

      <label htmlFor="cliente">Cliente</label>
      <br />
      <input
        type="text"
        name="cliente"
        value={searchQuery}
        onChange={handleSearchChange}
      />
      {facturaData.cliente && (
        <>
          <h4>Datos del cliente</h4>
          <p>Nombre: {facturaData.cliente.nombre}</p>
          <p>Cedula/ruc: {facturaData.cliente.identificacion}</p>
          <p>Telefono: {facturaData.cliente.telefono}</p>
          <p>Correo eletronico: {facturaData.cliente.correo}</p>
        </>
      )}
      <ul>
        {filteredClients.map((client) => (
          <li
            key={client.idCliente}
            onClick={() => handleClientSelection(client)}
          >
            {client.nombre} - {client.identificacion}
          </li>
        ))}
      </ul>

      <h3>Detalles de la Factura</h3>
      {facturaData.detalles.map((detalle, index) => (
        <div key={index}>
          <label htmlFor={`producto-${index}`}>Producto</label>
          <select
            name="producto"
            value={detalle.producto}
            onChange={(event) => handleDetalleChange(event, index)}
          >
            <option value="">Seleccionar Producto</option>
            {allProducts?.map((producto) => (
              <option key={producto.idProducto} value={producto.idProducto}>
                {producto.nombre}
              </option>
            ))}
          </select>

          <label htmlFor={`cantidad-${index}`}>Cantidad</label>
          <input
            type="number"
            name="cantidad"
            step="0.01"
            value={detalle.cantidad}
            onChange={(event) => handleDetalleChange(event, index)}
          />

          <label htmlFor={`precioUnitario-${index}`}>Precio Unitario</label>
          <input
            type="number"
            name="precioUnitario"
            step="0.01"
            value={detalle.precioUnitario}
            onChange={(event) => handleDetalleChange(event, index)}
          />
        </div>
      ))}

      <button type="button" onClick={handleAddDetalle}>
        Agregar Detalle
      </button>
      <button type="submit">Facturar</button>
    </form>
  );
};

export default FacturaForm;
