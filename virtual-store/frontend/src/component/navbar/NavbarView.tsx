import styles from "./NavbarView.module.css";
import {ColorModeSwitcher} from "../../ColorModeSwitcher";
import * as React from "react";

const NavbarView = () => {
    return (
        <div id={styles.navbar}>
            <ul>
                <li id={styles.left}><h2><strong>SNKR</strong></h2></li>
                <li id={styles.center}>Navigation</li>
                <li id={styles.right}><ColorModeSwitcher justifySelf="flex-end" /></li>
            </ul>
        </div>
    );
}
export default NavbarView;