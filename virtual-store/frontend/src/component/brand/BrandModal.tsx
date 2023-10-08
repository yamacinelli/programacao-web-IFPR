import {
    Button,
    FormControl,
    FormLabel,
    Input,
    Modal, ModalBody, ModalCloseButton,
    ModalContent, ModalFooter,
    ModalHeader,
    ModalOverlay, useToast
} from "@chakra-ui/react";
import {Brand} from "../../model/Brand";
import BrandService from "../../service/BrandService";
import {ChangeEventHandler, useState} from "react";

const BrandModal = ({ isOpen, onOpen, onClose, initialRef }: any) => {

    const [ brand, setBrand ] = useState(new Brand());
    const service = new BrandService;
    const toast = useToast();

    const handleChange: ChangeEventHandler<HTMLInputElement> = (e) => {
        const { name, value } = e.target;
        setBrand(prevState => ({
            ...prevState,
            [name]: value
        }));
    }

    const handleSave = (brand: Brand) => {
        service.save(brand)
            .then(response => {
                toast({ description: 'Success on create brand', status: "success" });
                onClose();
            })
            .catch(error => {
                toast({ description: 'Error on create brand', status: "error" });
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
                <ModalHeader>Add Brand</ModalHeader>
                <ModalCloseButton />
                <ModalBody pb={6}>
                    <FormControl variant={'floating'}>
                        <FormLabel>Name</FormLabel>
                        <Input name={'name'} ref={initialRef} placeholder={''} onChange={handleChange} />
                    </FormControl>
                </ModalBody>
                <ModalFooter>
                    <Button colorScheme="blue" mr={3} onClick={() => handleSave(brand)}>Save</Button>
                    <Button onClick={onClose}>Cancel</Button>
                </ModalFooter>
            </ModalContent>
        </Modal>
    );
}
export default BrandModal;