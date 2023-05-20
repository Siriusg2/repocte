import styles from "./Card.module.css";

function Card({ id, name, description, codigo }) {
  return (
    <div className={styles.divCard}>
      <span className={styles.label}>{name}</span>
      <span className={styles.label}>{id}</span>
      <span className={styles.label}>{codigo}</span>
      <span className={styles.label}>{description}</span>
    </div>
  );
}

export default Card;
