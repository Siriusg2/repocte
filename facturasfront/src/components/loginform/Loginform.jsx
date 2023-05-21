import { useState, useEffect } from "react";
import validateLoginForm from "./validteLoginForm";
import { login } from "../../redux/actions";
import { useNavigate } from "react-router-dom";

function LoginForm() {
  const [credentials, setCredentials] = useState({ email: "", password: "" });
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();
  const handleChange = (event) => {
    const { name, value } = event.target;
    setCredentials((prevState) => ({
      ...prevState,
      [name]: value.trim(),
    }));

    setErrors(validateLoginForm(credentials));
  };

  useEffect(() => {
    return () => setErrors(validateLoginForm(credentials));
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    await login(credentials);
    navigate("/home");
  };

  return (
    <form onSubmit={(e) => handleSubmit(e)}>
      <label htmlFor="email">
        Email
        <input
          type="text"
          name="email"
          value={credentials.email}
          onChange={handleChange}
        />
      </label>
      <span>{errors.email}</span>
      <label htmlFor="password">
        Password
        <input
          type="password"
          name="password"
          value={credentials.password}
          onChange={handleChange}
        />
      </label>
      <span>{errors.password}</span>
      <button type="submit">Ingresar</button>
    </form>
  );
}

export default LoginForm;
