import styles from "./NavbarComponent.module.css";
import {ColorModeSwitcher} from "../../ColorModeSwitcher";
import * as React from "react";
import {useNavigate} from "react-router";
import {Button, HStack} from "@chakra-ui/react";

const NavbarComponent = () => {
    const navigate = useNavigate();

    const handleNavigate = (path: string) => {
        navigate(path);
    }

    return (
        <div id={styles.navbar}>
            <HStack justifyContent={'space-between'}>
                <Button colorScheme='teal' variant='ghost' onClick={() => handleNavigate("/")}>
                    S4.
                </Button>
                <Button colorScheme='teal' variant='ghost' onClick={() => handleNavigate("/product")}>
                    Product
                </Button>
                <Button colorScheme='teal' variant='ghost' onClick={() => handleNavigate('/user')}>
                    User
                </Button>
                <ColorModeSwitcher justifySelf="flex-end" />
            </HStack>
        </div>
    );
}
export default NavbarComponent;