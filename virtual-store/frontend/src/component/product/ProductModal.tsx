import {
    Button,
    FormControl, FormErrorMessage,
    FormLabel, HStack,
    Input, InputGroup, InputLeftElement,
    Modal, ModalBody, ModalCloseButton,
    ModalContent, ModalFooter,
    ModalHeader,
    ModalOverlay, NumberInput, NumberInputField, useToast, VStack
} from "@chakra-ui/react";
import {ChangeEventHandler, useState} from "react";
import {Product} from "../../model/Product";
import ProductService from "../../service/ProductService";

const ProductModal = ({ isOpen, onOpen, onClose, initialRef }: any) => {

    const [ product, setProduct ] = useState(new Product());
    const service = new ProductService();
    const toast = useToast();

    const handleRequired = (value: string | number | undefined) => value == null || value.toString().trim() == '';

    const handleChange: ChangeEventHandler<HTMLInputElement> = (e) => {
        const { name, value } = e.target;
        setProduct(prevState => ({
            ...prevState,
            [name]: value
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
                            <Input name={'brand'} placeholder={''} onChange={handleChange} />
                            <FormLabel>Brand</FormLabel>
                            <FormErrorMessage>Brand is required</FormErrorMessage>
                        </FormControl>

                        <FormControl variant={'floating'} isRequired isInvalid={handleRequired(product.category?.name)}>
                            <Input name={'category'} placeholder={''} onChange={handleChange} />
                            <FormLabel>Category</FormLabel>
                            <FormErrorMessage>Category is required</FormErrorMessage>
                        </FormControl>

                        <HStack>
                            <FormControl variant={'floating'} isRequired isInvalid={handleRequired(product.costValue)}>
                                <InputGroup>
                                    <InputLeftElement pointerEvents='none' children='$' />
                                    <Input name={'costValue'} type={'number'} placeholder={''} onChange={handleChange} />
                                    <FormLabel>Cost Value</FormLabel>
                                </InputGroup>
                                <FormErrorMessage>Cost Value is required</FormErrorMessage>
                            </FormControl>

                            <FormControl variant={'floating'}>
                                <InputGroup>
                                    <InputLeftElement pointerEvents='none' children='$' />
                                    <Input name={'saleValue'} type={'number'} placeholder={''} onChange={handleChange} />
                                    <FormLabel>Sale Value</FormLabel>
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