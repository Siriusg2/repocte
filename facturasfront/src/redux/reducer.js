
import * as actions from './actions';

const initialState = {
  allFacturas: [],
  allProducts: [],
  allClients: [],

};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case actions.GET_FACTURAS
    :
      return {
        ...state,
        allFacturas: action.payload,
    
      };
    case actions.GET_CLIENTS:
      return {
        ...state,
        allClients: action.payload,
      };

    case actions.GET_PRODUCTS:
      return {
        ...state,
        allProducts: action.payload,
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
