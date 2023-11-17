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
import {Permission} from "../../model/Permission";
import PermissionService from "../../service/PermissionService";
import {ChangeEventHandler, useState} from "react";

const PermissionModal = ({ isOpen, onOpen, onClose, initialRef }: any) => {

    const [ permission, setPermission ] = useState(new Permission());
    const service = new PermissionService();
    const toast = useToast();

    const handleChange: ChangeEventHandler<HTMLInputElement> = (e) => {
        const { name, value } = e.target;
        setPermission(prevState => ({
            ...prevState,
            [name]: value
        }));
    }

    const handleSave = (permission: Permission) => {
        service.save(permission)
            .then(response => {
                toast({ description: 'Success on create permission', status: "success" });
                onClose();
            })
            .catch(error => {
                toast({ description: 'Error on create permission', status: "error" });
                console.error(error);
            });
    }

    return (
        <Modal
            isOpen={isOpen}
            onClose={onClose}
            initialFocusRef={initialRef}
            isCentered
        >
            <ModalOverlay />
            <ModalContent>
                <ModalHeader>Add Permission</ModalHeader>
                <ModalCloseButton />
                <ModalBody pb={6}>
                    <FormControl variant={'floating'}>
                        <Input name={'name'} ref={initialRef} placeholder={''} onChange={handleChange} />
                        <FormLabel>Name</FormLabel>
                    </FormControl>
                </ModalBody>
                <ModalFooter>
                    <Button mr={3} onClick={() => handleSave(permission)}>Save</Button>
                    <Button colorScheme={'red'} onClick={onClose}>Cancel</Button>
                </ModalFooter>
            </ModalContent>
        </Modal>
    );
}
export default PermissionModal;