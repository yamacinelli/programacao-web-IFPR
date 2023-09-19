import {useContext} from "react";
import {ThemeContext} from "../../App";
import styles from "./ToolbarComponent.module.css";

const Toolbar = () => {
    const {theme, setTheme} = useContext(ThemeContext);

    const handleChangeTheme = () => {
        if (theme == "light") return setTheme("dark");
        return setTheme("light");
    };

    return (
        <div className={styles.toolbar}>
            <p>{theme}</p>
            <button onClick={handleChangeTheme}></button>
        </div>
    );
}
export default Toolbar;