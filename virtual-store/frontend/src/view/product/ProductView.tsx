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

const ProductView = () => {

    const brandDisclosure = useDisclosure();
    const categoryDisclosure = useDisclosure();
    const initialRef = useRef(null);

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
                        <ButtonGroup size='sm' isAttached variant='outline' colorScheme='teal'>
                            <Button w={'32'}>Product</Button>
                            <IconButton w={'14'} aria-label='Add Product' icon={<AddIcon />} />
                        </ButtonGroup>
                        <ButtonGroup size='sm' isAttached variant='outline' colorScheme='teal'>
                            <Button w={'32'}>Brand</Button>
                            <IconButton w={'14'} aria-label='Add Brand' icon={<AddIcon />} onClick={brandDisclosure.onOpen} />
                        </ButtonGroup>
                        <ButtonGroup size='sm' isAttached variant='outline' colorScheme='teal'>
                            <Button w={'32'}>Category</Button>
                            <IconButton w={'14'} aria-label='Add Category' icon={<AddIcon />} onClick={categoryDisclosure.onOpen} />
                        </ButtonGroup>
                    </VStack>
                </GridItem>
                <BrandModal isOpen={brandDisclosure.isOpen} onOpen={brandDisclosure.onOpen} onClose={brandDisclosure.onClose} initialRef={initialRef} />
                <CategoryModal isOpen={categoryDisclosure.isOpen} onOpen={categoryDisclosure.onOpen} onClose={categoryDisclosure.onClose} initialRef={initialRef} />
            </Grid>
        </Box>
    );
}
export default ProductView;