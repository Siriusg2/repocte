import { useState } from "react";
import axios from "axios";

const ProductoForm = () => {
  const [productData, setProductData] = useState({
    name: "",
    price: "",
    quantity: "",
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
      setProductData({ name: "", price: "", quantity: "" });
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="name">Name</label>
      <input
        type="text"
        id="name"
        name="name"
        value={productData.name}
        onChange={handleChange}
      />

      <label htmlFor="price">Price</label>
      <input
        type="number"
        id="price"
        name="price"
        value={productData.price}
        onChange={handleChange}
      />

      <label htmlFor="quantity">Quantity</label>
      <input
        type="number"
        id="quantity"
        name="quantity"
        value={productData.quantity}
        onChange={handleChange}
      />

      <button type="submit">Save Product</button>
    </form>
  );
};

export default ProductoForm;
