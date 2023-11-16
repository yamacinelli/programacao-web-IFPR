import {
    Button,
    FormControl, FormLabel, Input,
    Modal,
    ModalBody,
    ModalCloseButton,
    ModalContent, ModalFooter,
    ModalHeader,
    ModalOverlay, useToast
} from "@chakra-ui/react";
import {ChangeEventHandler, useState} from "react";
import {Category} from "../../model/Category";
import CategoryService from "../../service/CategoryService";

const CategoryModal = ({ isOpen, onOpen, onClose, initialRef }: any) => {

    const [ category, setCategory ] = useState(new Category());
    const service = new CategoryService();
    const toast = useToast();

    const handleChange: ChangeEventHandler<HTMLInputElement> = (e) => {
        const { name, value } = e.target;
        setCategory(prevState => ({
            ...prevState,
            [name]: value
        }));
    }

    const handleSave = (category: Category) => {
        service.save(category)
            .then(response => {
                toast({ description: 'Success on create category', status: "success" });
                onClose();
            })
            .catch(error => {
                toast({ description: 'Error on create category', status: "error" });
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
                <ModalHeader>Add Category</ModalHeader>
                <ModalCloseButton />
                <ModalBody pb={6}>
                    <FormControl variant={'floating'}>
                        <Input name={'name'} ref={initialRef} placeholder={''} onChange={handleChange} />
                        <FormLabel>Name</FormLabel>
                    </FormControl>
                </ModalBody>
                <ModalFooter>
                    <Button mr={3} onClick={() => handleSave(category)}>Save</Button>
                    <Button colorScheme={'red'} onClick={onClose}>Cancel</Button>
                </ModalFooter>
            </ModalContent>
        </Modal>
    );
}
export default CategoryModal;