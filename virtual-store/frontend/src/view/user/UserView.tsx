import {Box, Button, ButtonGroup, Grid, GridItem, HStack, IconButton, useDisclosure, VStack} from "@chakra-ui/react";
import styles from "./UserView.module.css";
import {AddIcon} from "@chakra-ui/icons";
import PermissionModal from "../../component/permission/PermissionModal";
import PermissionList from "../../component/permission/PermissionList";

const UserView = () => {
    // user states
    const userModalDisclosure = useDisclosure();
    // permission states
    const permissionListDisclosure = useDisclosure();
    const permissionModalDisclosure = useDisclosure();

    return (
        <Box id={styles.product}>
            <Grid
                minH="85vh"
                templateRows='repeat(1, 1fr)'
                templateColumns='repeat(12, 1fr)'
                gap={2}
            >
                <GridItem colSpan={10} />
                <GridItem colSpan={2}>
                    <VStack h={'full'} justify={'space-evenly'}>
                        <ButtonGroup isAttached>
                            <Button w={'32'} pointerEvents='none'>User</Button>
                            <IconButton w={'14'} aria-label='Add User' icon={<AddIcon />} onClick={() => console.log('click')} />
                        </ButtonGroup>
                        <ButtonGroup isAttached>
                            <Button w={'32'} onClick={permissionListDisclosure.onOpen}>Permission</Button>
                            <IconButton w={'14'} aria-label='Add Permission' icon={<AddIcon />} onClick={permissionModalDisclosure.onOpen} />
                        </ButtonGroup>
                    </VStack>
                </GridItem>
                {permissionListDisclosure.isOpen ? <PermissionList isOpen={permissionListDisclosure.isOpen} onOpen={permissionListDisclosure.onOpen} onClose={permissionListDisclosure.onClose} /> : null}
                {permissionModalDisclosure.isOpen ? <PermissionModal isOpen={permissionModalDisclosure.isOpen} onOpen={permissionModalDisclosure.onOpen} onClose={permissionModalDisclosure.onClose} /> : null}
            </Grid>
        </Box>
    );
}
export default UserView;