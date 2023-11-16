import {
    Modal,
    ModalBody,
    ModalCloseButton,
    ModalContent,
    ModalHeader,
    ModalOverlay, Table, TableContainer, Tbody, Td, Tfoot, Th, Thead, Tr, useToast
} from "@chakra-ui/react";
import {useEffect, useState} from "react";
import CategoryService from "../../service/CategoryService";
import {Category} from "../../model/Category";

const CategoryList = ({ isOpen, onOpen, onClose }: any) => {

    const [ categorys, setCategorys ] = useState([]);
    const service = new CategoryService();
    const toast = useToast();

    useEffect(() => {
        service.findAll()
            .then(response => {
                setCategorys(response.data);
            })
            .catch(error => {
                toast({ description: 'Error on get category list', status: 'error' });
                console.error(error);
            });
    }, []);

    return (
        <Modal
            isOpen={isOpen}
            onClose={onClose}
            isCentered
            scrollBehavior='inside'
        >
            <ModalOverlay />
            <ModalContent>
                <ModalHeader>Category List</ModalHeader>
                <ModalCloseButton />
                <ModalBody pb={6}>
                    <TableContainer>
                        <Table variant='striped' colorScheme='teal'>
                            <Thead>
                                <Tr>
                                    <Th>Name</Th>
                                </Tr>
                            </Thead>
                            <Tbody>
                                {categorys.map((category: Category) => {
                                    return (
                                        <Tr key={category.id}>
                                            <Td>{category.name}</Td>
                                        </Tr>
                                    );
                                })}
                            </Tbody>
                            <Tfoot>
                                <Tr>
                                    <Th>Name</Th>
                                </Tr>
                            </Tfoot>
                        </Table>
                    </TableContainer>
                </ModalBody>
            </ModalContent>
        </Modal>
    );
}
export default CategoryList;