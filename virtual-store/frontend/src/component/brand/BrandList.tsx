import {
    Modal,
    ModalBody,
    ModalCloseButton,
    ModalContent,
    ModalHeader,
    ModalOverlay, Table, TableContainer, Tbody, Td, Tfoot, Th, Thead, Tr, useToast
} from "@chakra-ui/react";
import {useEffect, useState} from "react";
import {Brand} from "../../model/Brand";
import BrandService from "../../service/BrandService";

const BrandList = ({ isOpen, onOpen, onClose }: any) => {

    const [ brands, setBrands ] = useState([]);
    const service = new BrandService;
    const toast = useToast();

    useEffect(() => {
        service.findAll()
            .then(response => {
                setBrands(response.data);
            })
            .catch(error => {
                toast({ description: 'Error on get brand list', status: 'error' });
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
                <ModalHeader>Brand List</ModalHeader>
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
                                {brands.map((brand: Brand) => {
                                    return (
                                        <Tr key={brand.id}>
                                            <Td>{brand.name}</Td>
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
export default BrandList;