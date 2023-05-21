import { useState } from "react";

import { saveUser } from "../../redux/actions";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";

const UsuarioForm = () => {
  const allRoles = useSelector((state) => state.allRoles);
  const dispatch = useDispatch();
  const [userData, setUserData] = useState({
    email: "",
    password: "",
    role: {
      id: "",
      name: "",
    },
  });
  const dataUser = JSON.parse(localStorage.getItem("userData"));

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = async (e, userData) => {
    e.preventDefault();

    await dispatch(saveUser(userData, dataUser.role.id));

    // Limpiar el formulario después de guardar el usuario
    setUserData({
      email: "",
      password: "",
      role: {
        id: "",
        name: "",
      },
    });
  };

  return (
    <form onSubmit={(e) => handleSubmit(e, userData)}>
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

      <label htmlFor="role">Rol</label>
      <select
        id="role"
        name="role"
        value={userData.role}
        onChange={handleChange}
      >
        {allRoles?.map((role) => (
          <option key={role.id} value={role}>
            {role.nombre}
          </option>
        ))}
      </select>

      <button type="submit">Save User</button>
    </form>
  );
};

export default UsuarioForm;
