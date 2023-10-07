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

const BrandModal = ({ isOpen, onOpen, onClose, initialRef }: any) => {
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
                        <Input ref={initialRef} placeholder={''} />
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