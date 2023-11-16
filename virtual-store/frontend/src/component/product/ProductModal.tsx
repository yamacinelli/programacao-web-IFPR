import {
    Button,
    FormControl, FormErrorMessage,
    FormLabel, HStack,
    Input, InputGroup, InputLeftAddon, InputLeftElement,
    Modal, ModalBody, ModalCloseButton,
    ModalContent, ModalFooter,
    ModalHeader,
    ModalOverlay, NumberInput, NumberInputField, Select, Td, Tr, useToast, VStack
} from "@chakra-ui/react";
import {ChangeEventHandler, useEffect, useState} from "react";
import {Product} from "../../model/Product";
import ProductService from "../../service/ProductService";
import {Brand} from "../../model/Brand";
import BrandService from "../../service/BrandService";
import CategoryService from "../../service/CategoryService";
import {Category} from "../../model/Category";

const ProductModal = ({ isOpen, onOpen, onClose, initialRef }: any) => {

    // states
    const [ product, setProduct ] = useState(new Product());
    const [ brands, setBrands ] = useState([]);
    const [ categorys, setCategorys ] = useState([]);
    // services
    const service = new ProductService();
    const brandService = new BrandService();
    const categoryService = new CategoryService();
    const toast = useToast();

    useEffect(() => {
        findAllBrand();
        findAllCategory();
    }, []);

    const findAllBrand = () => {
        brandService.findAll()
            .then(response => {
                setBrands(response.data);
            })
            .catch(error => {
                toast({ description: 'Error on get brand list', status: 'error' });
                console.error(error);
            });
    }

    const findAllCategory = () => {
        categoryService.findAll()
            .then(response => {
                setCategorys(response.data);
            })
            .catch(error => {
                toast({ description: 'Error on get category list', status: 'error' });
                console.error(error);
            });
    }

    const handleObjectSelect = (name: string, index: number): any => {
        switch (name) {
            case 'brand':
                return brands.at(index);
            case 'category':
                return categorys.at(index);
        }
    }

    const handleRequired = (value: string | number | undefined) => value == null || value.toString().trim() == '';

    const handleChange: ChangeEventHandler<HTMLInputElement> = (e) => {
        const { name, value } = e.target;
        setProduct(prevState => ({
            ...prevState,
            [name]: value
        }));
    }

    const handleSelectChange: ChangeEventHandler<HTMLSelectElement> = (e) => {
        const { name, value } = e.target;
        setProduct(prevState => ({
            ...prevState,
            [name]: handleObjectSelect(name, Number(value))
        }));
    }

    const handleSave = (product: Product) => {
        service.save(product)
            .then(response => {
                toast({ description: 'Success on create product', status: "success" });
                onClose();
            })
            .catch(error => {
                toast({ description: 'Error on create product', status: "error" });
                console.error(error);
            });
    }

    return (
        <Modal
            isOpen={isOpen}
            onClose={onClose}
            initialFocusRef={initialRef}
        >
            <ModalOverlay />
            <ModalContent>
                <ModalHeader>Add Product</ModalHeader>
                <ModalCloseButton />
                <ModalBody pb={6}>
                    <VStack spacing={'1rem'}>
                        <FormControl variant={'floating'} isRequired isInvalid={handleRequired(product.name)}>
                            <Input name={'name'} ref={initialRef} placeholder={''} onChange={handleChange} />
                            <FormLabel>Name</FormLabel>
                            <FormErrorMessage>Name is required</FormErrorMessage>
                        </FormControl>

                        <FormControl variant={'floating'} isRequired isInvalid={handleRequired(product.shortDescription)}>
                            <Input name={'shortDescription'} placeholder={''} onChange={handleChange} />
                            <FormLabel>Short Description</FormLabel>
                            <FormErrorMessage>Short Description is required</FormErrorMessage>
                        </FormControl>

                        <FormControl variant={'floating'}>
                            <Input name={'detailedDescription'} placeholder={''} onChange={handleChange} />
                            <FormLabel>Detailed Description</FormLabel>
                        </FormControl>

                        <FormControl variant={'floating'} isRequired isInvalid={handleRequired(product.brand?.name)}>
                            <Select name={'brand'} placeholder={'Select a Brand'} onChange={handleSelectChange} >
                                {brands.map((brand: Brand, index: number) => (
                                    <option key={brand.id} value={index}>{brand.name}</option>
                                ))}
                            </Select>
                            <FormLabel>Brand</FormLabel>
                            <FormErrorMessage>Brand is required</FormErrorMessage>
                        </FormControl>

                        <FormControl variant={'floating'} isRequired isInvalid={handleRequired(product.category?.name)}>
                            <Select name={'category'} placeholder={'Select a Category'} onChange={handleSelectChange} >
                                {categorys.map((category: Category, index: number) => (
                                    <option key={category.id} value={index}>{category.name}</option>
                                ))}
                            </Select>
                            <FormLabel>Category</FormLabel>
                            <FormErrorMessage>Category is required</FormErrorMessage>
                        </FormControl>

                        <HStack>
                            <FormControl variant={'floating'} isRequired isInvalid={handleRequired(product.costValue)}>
                                <InputGroup>
                                    <NumberInput precision={2} step={0.2}>
                                        <InputLeftElement pointerEvents='none' children='$' />
                                        <NumberInputField pl='2em' name={'costValue'} onChange={handleChange} />
                                        <FormLabel>Cost Value</FormLabel>
                                    </NumberInput>
                                </InputGroup>
                                <FormErrorMessage>Cost Value is required</FormErrorMessage>
                            </FormControl>

                            <FormControl variant={'floating'}>
                                <InputGroup>
                                    <NumberInput precision={2} step={0.2}>
                                        <InputLeftElement pointerEvents='none' children='$' />
                                        <NumberInputField pl='2em' name={'saleValue'} onChange={handleChange} />
                                        <FormLabel>Sale Value</FormLabel>
                                    </NumberInput>
                                </InputGroup>
                            </FormControl>
                        </HStack>
                    </VStack>
                </ModalBody>
                <ModalFooter>
                    <Button mr={3} onClick={() => handleSave(product)}>Save</Button>
                    <Button colorScheme={'red'} onClick={onClose}>Cancel</Button>
                </ModalFooter>
            </ModalContent>
        </Modal>
    );
}
export default ProductModal;