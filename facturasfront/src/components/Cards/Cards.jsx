import styles from "./Cards.module.css";
import { useSelector } from "react-redux";
// import { useEffect, useState } from "react";
// import Pagination from "../Pagination/Pagination";

import Card from "../Card/Card";

export default function Cards() {
  const allProducts = useSelector((state) => state.allProducts);

  // const [currentPage, setCurrentPage] = useState(1);
  // const [cardPerPage] = useState(15);
  // const indexOfLastCard = currentPage * cardPerPage;
  // const indexOfFirstCard = indexOfLastCard - cardPerPage;
  // let currentCards;

  // if (Array.isArray(allProducts)) {
  //   currentCards = gamesFiltered.slice(indexOfFirstCard, indexOfLastCard);
  // } else {
  //   currentCards = [];
  // }

  // const paginate = (pageNumber) => {
  //   setCurrentPage(pageNumber);
  // };
  // useEffect(() => {
  //   setCurrentPage(1);
  // }, [gamesFiltered]);

  return (
    <div className={styles.container}>
      <div className={styles.divCards}>
        {allProducts?.map((card) => (
          <Card
            key={card.idProducto}
            id={card.idProducto}
            name={card.nombre}
            description={card.description}
            codigo={card.codigo}
          />
        ))}
      </div>
      <div className={styles.divPaginationbottom}> </div>
    </div>
  );
}
