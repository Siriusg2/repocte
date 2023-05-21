import { useState } from "react";
import axios from "axios";

const ProductoForm = () => {
  const [productData, setProductData] = useState({
    codigo: "",
    descripcion: "",
    nombre: "",
    categoria: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProductData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("/products/create", productData);
      console.log(response.data);

      // Limpiar el formulario después de guardar el producto
      setProductData({
        codigo: "",
        descripcion: "",
        nombre: "",
        categoria: "",
      });
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="codigo">Código</label>
      <input
        type="text"
        id="codigo"
        name="codigo"
        value={productData.codigo}
        onChange={handleChange}
      />

      <label htmlFor="descripcion">Descripción</label>
      <textarea
        id="descripcion"
        name="descripcion"
        value={productData.descripcion}
        onChange={handleChange}
      />

      <label htmlFor="nombre">Nombre</label>
      <input
        type="text"
        id="nombre"
        name="nombre"
        value={productData.nombre}
        onChange={handleChange}
      />

      <label htmlFor="categoria">Categoría</label>
      <input
        type="text"
        id="categoria"
        name="categoria"
        value={productData.categoria}
        onChange={handleChange}
      />

      <button type="submit">Save Product</button>
    </form>
  );
};

export default ProductoForm;
