import styles from "./FooterComponent.module.css";

const FooterComponent = () => {
    return (
        <div id={styles.footer}>
            <ul>
                <li id={styles.left}>&copy; 2023 S4.</li>
                <li id={styles.right}>v1.0</li>
            </ul>
        </div>
    );
}
export default FooterComponent;