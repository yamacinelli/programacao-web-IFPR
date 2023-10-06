import {Box, Grid, GridItem, HStack, IconButton, VStack} from "@chakra-ui/react";
import styles from "./BrandView.module.css";
import {AddIcon} from "@chakra-ui/icons";

const BrandView = () => {
    return (
        <Box id={styles.brand}>
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
export default BrandView;