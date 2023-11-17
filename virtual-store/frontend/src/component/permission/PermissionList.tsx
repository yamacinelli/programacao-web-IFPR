import {
    Modal,
    ModalBody,
    ModalCloseButton,
    ModalContent,
    ModalHeader,
    ModalOverlay, Table, TableContainer, Tbody, Td, Tfoot, Th, Thead, Tr, useToast
} from "@chakra-ui/react";
import {useEffect, useState} from "react";
import {Permission} from "../../model/Permission";
import PermissionService from "../../service/PermissionService";

const PermissionList = ({ isOpen, onOpen, onClose }: any) => {

    const [ permissions, setPermissions ] = useState([]);
    const service = new PermissionService;
    const toast = useToast();

    useEffect(() => {
        service.findAll()
            .then(response => {
                setPermissions(response.data);
            })
            .catch(error => {
                toast({ description: 'Error on get permission list', status: 'error' });
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
                <ModalHeader>Permission List</ModalHeader>
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
                                {permissions.map((permission: Permission) => {
                                    return (
                                        <Tr key={permission.id}>
                                            <Td>{permission.name}</Td>
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
export default PermissionList;