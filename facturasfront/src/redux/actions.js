import axios from "axios";

export const GET_FACTURAS = "GET_FACTURAS";
export const GET_CLIENTS = "GET_CLIENTS";
export const GET_PRODUCTS = "GET_PRODUCTS";
export const CREATE_PRODUCT = "CREATE_PRODUCT";
export const CREATE_CLIENT = "CREATE_CLIENT";
export const CREATE_FACTURA = "CREATE_FACTURA";

export const createFactura = (factura) => async (dispatch) => {
  try {
    const response = await axios.post("/facturas/create", factura);

    if (typeof response.data === "object")
      dispatch({ type: CREATE_FACTURA, payload: response.data });
    return response.data;
  } catch (error) {
    alert(error.message);
  }
};

export const getAllFacturas = () => async (dispatch) => {
  try {
    const response = await axios.get(`/facturas/get_all`);

    return typeof response.data !== "string"
      ? dispatch({ type: GET_FACTURAS, payload: response.data })
      : alert(response.data);
  } catch (error) {
    alert(error.message);
  }
};

export const getAllClients = () => async (dispatch) => {
  try {
    const response = await axios.get("/customers/get_all");
    dispatch({ type: GET_CLIENTS, payload: response.data });
  } catch (error) {
    alert(error.message);
  }
};
export const getAllProducts = () => async (dispatch) => {
  try {
    const response = await axios.get(`/products/get_all`);
    dispatch({ type: GET_PRODUCTS, payload: response.data });
  } catch (error) {
    alert(error.message);
  }
};
export const login = async (credentials) => {
  try {
    const response = await axios.post(`/users/login`, credentials);
    localStorage.setItem("userData", JSON.stringify(response.data));
  } catch (error) {
    alert(error.message);
  }
};
