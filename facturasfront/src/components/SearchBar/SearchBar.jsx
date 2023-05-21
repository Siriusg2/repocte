import { useState } from "react";
import { useDispatch } from "react-redux";

import styles from "./SearchBar.module.css";

export default function SearchBar() {
  const [product, setproduct] = useState("");
  // const allCharacters = useSelector((state) => state.allCharacters);
  const dispatch = useDispatch();

  /*  handleEvent para el input, setea el estado de este componente al 
  valor ingresado por el usuario mediante el listener onChange*/
  const onInput = (event) => {
    const value = event.target.value;

    setproduct(value);
  };

  const onClick = (word) => {
    if (!word) return dispatch();
    else {
      dispatch();
      setproduct("");
    }
  };

  return (
    <div className={styles.container}>
      <input
        type="string"
        placeholder="Ingresa el nombre del producto... "
        onChange={onInput}
        className={styles.inputSearchBar}
        id="input"
        value={product}
      />

      <button
        className={styles.buttonSearch}
        onClick={() => {
          product
            ? onClick(product)
            : alert("Please write a product name or a related word");
        }}
      >
        Search
      </button>
    </div>
  );
}
