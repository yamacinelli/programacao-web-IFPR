import styles from "./ProductView.module.css";
import {Box, Button, ButtonGroup, Grid, GridItem, HStack, IconButton, Text, VStack} from "@chakra-ui/react";
import {AddIcon} from "@chakra-ui/icons";

const ProductView = () => {

    return (
        <Box id={styles.product}>
            <Grid
                minH="85vh"
                templateRows='repeat(1, 1fr)'
                templateColumns='repeat(12, 1fr)'
                gap={2}
            >
                <GridItem colSpan={10} bg='papayawhip' />
                <GridItem colSpan={2} bg='tomato'>
                    <VStack h={'full'} justify={'space-evenly'}>
                        <ButtonGroup size='sm' isAttached variant='outline'>
                            <Button w={'32'}>Product</Button>
                            <IconButton w={'14'} aria-label='Add Product' icon={<AddIcon />} />
                        </ButtonGroup>

                        <ButtonGroup size='sm' isAttached variant='outline'>
                            <Button w={'32'}>Brand</Button>
                            <IconButton w={'14'} aria-label='Add Brand' icon={<AddIcon />} />
                        </ButtonGroup>
                    </VStack>
                </GridItem>
            </Grid>
        </Box>
    );
}
export default ProductView;