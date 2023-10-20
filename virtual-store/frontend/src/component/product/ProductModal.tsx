import {
    Button,
    FormControl,
    FormLabel, HStack,
    Input,
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
                    <VStack>
                        <FormControl variant={'floating'}>
                            <Input name={'name'} ref={initialRef} placeholder={''} onChange={handleChange} />
                            <FormLabel>Name</FormLabel>
                        </FormControl>

                        <FormControl variant={'floating'}>
                            <Input name={'shortDescription'} placeholder={''} onChange={handleChange} />
                            <FormLabel>Short Description</FormLabel>
                        </FormControl>

                        <FormControl variant={'floating'}>
                            <Input name={'detailedDescription'} placeholder={''} onChange={handleChange} />
                            <FormLabel>Detailed Description</FormLabel>
                        </FormControl>

                        <FormControl variant={'floating'}>
                            <Input name={'brand'} placeholder={''} onChange={handleChange} />
                            <FormLabel>Brand</FormLabel>
                        </FormControl>

                        <FormControl variant={'floating'}>
                            <Input name={'category'} placeholder={''} onChange={handleChange} />
                            <FormLabel>Category</FormLabel>
                        </FormControl>

                        <HStack>
                            <FormControl variant={'floating'}>
                                <Input name={'costValue'} placeholder={''} onChange={handleChange} />
                                <FormLabel>Cost Value</FormLabel>
                            </FormControl>

                            <FormControl variant={'floating'}>
                                <Input name={'saleValue'} placeholder={''} onChange={handleChange} />
                                <FormLabel>Sale Value</FormLabel>
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