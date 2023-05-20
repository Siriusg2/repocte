const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

const validateLoginForm = (state)=>{
const errors = {};
if(state.email === ""){
    errors.email = "el campo email no debe estar vacio"
}
if(!emailRegex.test(state.email)){
    errors.email = "el campo email debe cumplir con el siguiento formato ej: example@example.com"
}
if(state.password === ""){
    errors.password = "el campo password no debe estar vacio"
}

return errors
}

export default  validateLoginForm