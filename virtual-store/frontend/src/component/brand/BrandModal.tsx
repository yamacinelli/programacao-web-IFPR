import {
    Button,
    FormControl,
    FormLabel,
    Input,
    Modal, ModalBody, ModalCloseButton,
    ModalContent, ModalFooter,
    ModalHeader,
    ModalOverlay
} from "@chakra-ui/react";
import {Brand} from "../../model/Brand";
import BrandService from "../../service/BrandService";
import {ChangeEventHandler} from "react";

const BrandModal = ({ isOpen, onOpen, onClose, initialRef }: any) => {

    const service = new BrandService;

    const handleChange: ChangeEventHandler<HTMLInputElement> = (e) => {
        console.log(e);
    }

    const handleSave = (brand: Brand) => {
        service.save(brand).then(response => {

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
                        <Input ref={initialRef} placeholder={''} onChange={handleChange} />
                    </FormControl>
                </ModalBody>
                <ModalFooter>
                    <Button colorScheme="blue" mr={3}>Save</Button>
                    <Button onClick={onClose}>Cancel</Button>
                </ModalFooter>
            </ModalContent>
        </Modal>
    );
}
export default BrandModal;