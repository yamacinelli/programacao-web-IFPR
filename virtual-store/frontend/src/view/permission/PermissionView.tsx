import {Box, HStack, IconButton} from "@chakra-ui/react";
import styles from "./PermissionView.module.css";
import {AddIcon} from "@chakra-ui/icons";

const PermissionView = () => {
    return (
        <Box id={styles.permission}>
            <HStack>
                <IconButton
                    variant='outline'
                    colorScheme='teal'
                    aria-label='Send email'
                    icon={<AddIcon />}
                />
            </HStack>
        </Box>
    );
}
export default PermissionView;