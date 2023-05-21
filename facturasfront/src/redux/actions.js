import axios from "axios";

export const GET_FACTURAS = "GET_FACTURAS";

export const GET_CLIENTS = "GET_CLIENTS";
export const GET_USERS = "GET_USERS";
export const GET_ROLES = "GET_ROLES";

export const GET_PRODUCTS = "GET_PRODUCTS";

export const CREATE_PRODUCT = "CREATE_PRODUCT";
export const CREATE_CLIENT = "CREATE_CLIENT";
export const CREATE_FACTURA = "CREATE_FACTURA";
export const CREATE_USER = "CREATE_USER";

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
export const getAllRoles = () => async (dispatch) => {
  try {
    const response = await axios.get("/role/get_all");
    dispatch({ type: GET_ROLES, payload: response.data });
  } catch (error) {
    alert(error.message);
  }
};
export const getAllUsers = () => async (dispatch) => {
  try {
    const response = await axios.get("/users/get_all");
    dispatch({ type: GET_USERS, payload: response.data });
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
export const saveClient = (clientData) => async (dispatch) => {
  try {
    const headers = {
      id: "1",
    };
    const response = await axios.post(`/customers/create`, clientData, {
      headers,
    });
    dispatch({ type: CREATE_CLIENT, payload: response.data });
  } catch (error) {
    alert(error.message);
  }
};
export const saveProduct = (productData) => async (dispatch) => {
  try {
    const response = await axios.post(`/products/create`, productData);
    dispatch({ type: CREATE_PRODUCT, payload: response.data });
  } catch (error) {
    alert(error.message);
  }
};
export const saveUser = (userData, roleIdUserSession) => async (dispatch) => {
  try {
    const headers = {
      id: roleIdUserSession.toString(),
    };
    const response = await axios.post(`/users/create`, userData, {
      headers,
    });
    dispatch({ type: CREATE_USER, payload: response.data });
  } catch (error) {
    alert(error.message);
  }
};
export const saveFactura = (factData) => async (dispatch) => {
  try {
    const response = await axios.post(`/facturas/create`, factData);
    dispatch({ type: CREATE_FACTURA, payload: response.data });
  } catch (error) {
    alert(error.message);
  }
};
