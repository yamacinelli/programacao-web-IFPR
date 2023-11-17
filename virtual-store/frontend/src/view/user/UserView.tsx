import {Box, Button, ButtonGroup, Grid, GridItem, HStack, IconButton, VStack} from "@chakra-ui/react";
import styles from "./UserView.module.css";
import {AddIcon} from "@chakra-ui/icons";
import ProductList from "../../component/product/ProductList";
import ProductModal from "../../component/product/ProductModal";
import BrandList from "../../component/brand/BrandList";
import BrandModal from "../../component/brand/BrandModal";
import CategoryList from "../../component/category/CategoryList";
import CategoryModal from "../../component/category/CategoryModal";

const UserView = () => {
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
                            <Button w={'32'} onClick={() => console.log('click')}>Brand</Button>
                            <IconButton w={'14'} aria-label='Add Brand' icon={<AddIcon />} onClick={() => console.log('click')} />
                        </ButtonGroup>
                        <ButtonGroup isAttached>
                            <Button w={'32'} onClick={() => console.log('click')}>Category</Button>
                            <IconButton w={'14'} aria-label='Add Category' icon={<AddIcon />} onClick={() => console.log('click')} />
                        </ButtonGroup>
                    </VStack>
                </GridItem>
            </Grid>
        </Box>
    );
}
export default UserView;