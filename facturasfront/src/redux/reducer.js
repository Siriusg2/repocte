import * as actions from "./actions";

const initialState = {
  allFacturas: [],
  allProducts: [],
  allClients: [],
  allUsers: [],
  allRoles: [],
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case actions.GET_FACTURAS:
      return {
        ...state,
        allFacturas: action.payload,
      };
    case actions.GET_ROLES:
      return {
        ...state,
        allRoles: action.payload,
      };
    case actions.CREATE_FACTURA:
      return {
        ...state,
        allFacturas: [...state.allFacturas, action.payload],
      };
    case actions.GET_CLIENTS:
      return {
        ...state,
        allClients: action.payload,
      };
    case actions.CREATE_CLIENT:
      return {
        ...state,
        allClients: [...state.allClients, action.payload],
      };

    case actions.GET_PRODUCTS:
      return {
        ...state,
        allProducts: action.payload,
      };
    case actions.CREATE_PRODUCT:
      return {
        ...state,
        allProducts: [...state.allProducts, action.payload],
      };
    case actions.GET_USERS:
      return {
        ...state,
        allUsers: action.payload,
      };
    case actions.CREATE_USER:
      return {
        ...state,
        allUsers: [...state.allUsers, action.payload],
      };

    default:
      return {
        ...state,
      };
  }
};

export default reducer;

// eslint-disable-next-line linebreak-style
/* eslint-enable */
