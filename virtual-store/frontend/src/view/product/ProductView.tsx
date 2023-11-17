import styles from "./ProductView.module.css";
import {
    Box,
    Button,
    ButtonGroup,
    Grid,
    GridItem,
    HStack,
    IconButton,
    Text,
    useDisclosure,
    VStack
} from "@chakra-ui/react";
import {AddIcon} from "@chakra-ui/icons";
import BrandModal from "../../component/brand/BrandModal";
import {useRef} from "react";
import CategoryModal from "../../component/category/CategoryModal";
import BrandList from "../../component/brand/BrandList";
import CategoryList from "../../component/category/CategoryList";
import ProductModal from "../../component/product/ProductModal";
import ProductList from "../../component/product/ProductList";

const ProductView = () => {
    // product states
    const productModalDisclosure = useDisclosure();
    // brand states
    const brandListDisclosure = useDisclosure();
    const brandModalDisclosure = useDisclosure();
    // category states
    const categoryListDisclosure = useDisclosure();
    const categoryModalDisclosure = useDisclosure();

    const initialRef = useRef(null);

    return (
        <Box id={styles.product}>
            <Grid
                minH="85vh"
                templateRows='repeat(1, 1fr)'
                templateColumns='repeat(12, 1fr)'
                gap={2}
            >
                <GridItem colSpan={10}>
                    <ProductList />
                </GridItem>
                <GridItem colSpan={2}>
                    <VStack h={'full'} justify={'space-evenly'}>
                        <ButtonGroup isAttached>
                            <Button w={'32'} pointerEvents='none'>Product</Button>
                            <IconButton w={'14'} aria-label='Add Product' icon={<AddIcon />} onClick={productModalDisclosure.onOpen} />
                        </ButtonGroup>
                        <ButtonGroup isAttached>
                            <Button w={'32'} onClick={brandListDisclosure.onOpen}>Brand</Button>
                            <IconButton w={'14'} aria-label='Add Brand' icon={<AddIcon />} onClick={brandModalDisclosure.onOpen} />
                        </ButtonGroup>
                        <ButtonGroup isAttached>
                            <Button w={'32'} onClick={categoryListDisclosure.onOpen}>Category</Button>
                            <IconButton w={'14'} aria-label='Add Category' icon={<AddIcon />} onClick={categoryModalDisclosure.onOpen} />
                        </ButtonGroup>
                    </VStack>
                </GridItem>
                {productModalDisclosure.isOpen ? <ProductModal isOpen={productModalDisclosure.isOpen} onOpen={productModalDisclosure.onOpen} onClose={productModalDisclosure.onClose} initialRef={initialRef} /> : null}
                {brandListDisclosure.isOpen ? <BrandList isOpen={brandListDisclosure.isOpen} onOpen={brandListDisclosure.onOpen} onClose={brandListDisclosure.onClose} /> : null}
                {brandModalDisclosure.isOpen ? <BrandModal isOpen={brandModalDisclosure.isOpen} onOpen={brandModalDisclosure.onOpen} onClose={brandModalDisclosure.onClose} initialRef={initialRef} /> : null}
                {categoryListDisclosure.isOpen ? <CategoryList isOpen={categoryListDisclosure.isOpen} onOpen={categoryListDisclosure.onOpen} onClose={categoryListDisclosure.onClose} /> : null}
                {categoryModalDisclosure.isOpen ? <CategoryModal isOpen={categoryModalDisclosure.isOpen} onOpen={categoryModalDisclosure.onOpen} onClose={categoryModalDisclosure.onClose} initialRef={initialRef} /> : null}
            </Grid>
        </Box>
    );
}
export default ProductView;