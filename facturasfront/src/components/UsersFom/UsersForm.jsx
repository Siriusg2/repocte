import { useState } from "react";
import axios from "axios";

const UsuarioForm = () => {
  const [userData, setUserData] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("/users/create", userData);
      console.log(response.data);

      // Limpiar el formulario después de guardar el usuario
      setUserData({ email: "", password: "" });
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="email">Email</label>
      <input
        type="text"
        id="email"
        name="email"
        value={userData.email}
        onChange={handleChange}
      />

      <label htmlFor="password">Password</label>
      <input
        type="password"
        id="password"
        name="password"
        value={userData.password}
        onChange={handleChange}
      />

      <button type="submit">Save User</button>
    </form>
  );
};

export default UsuarioForm;
