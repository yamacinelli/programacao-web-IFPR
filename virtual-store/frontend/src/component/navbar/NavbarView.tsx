import styles from "./NavbarView.module.css";
import {ColorModeSwitcher} from "../../ColorModeSwitcher";
import * as React from "react";

const NavbarView = () => {
    return (
        <div id={styles.navbar}>
            <ul>
                <li>Navigation</li>
                <li><ColorModeSwitcher justifySelf="flex-end" /></li>
            </ul>
        </div>
    );
}
export default NavbarView;