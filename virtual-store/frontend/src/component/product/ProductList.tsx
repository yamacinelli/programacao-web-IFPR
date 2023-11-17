import {SimpleGrid, Table, TableContainer, Tbody, Td, Tfoot, Th, Thead, Toast, Tr, useToast} from "@chakra-ui/react";
import {Category} from "../../model/Category";
import {useEffect, useState} from "react";
import ProductService from "../../service/ProductService";
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;
import {Product} from "../../model/Product";
import ProductCard from "./ProductCard";

const ProductList = () => {

    const [products, setProducts] = useState([]);
    const service = new ProductService();
    const toast = useToast();

    useEffect(() => {
        service.findAll()
            .then(response => {
                setProducts(response.data);
            })
            .catch(error => {
                toast({ description: 'Error on get product list', status: 'error' });
                console.error(error);
            });
    }, []);

    return (
        <SimpleGrid
            spacing={4}
            templateColumns='repeat(auto-fill, minmax(300px, 1fr))'
        >
            {products.map((product: Product) => {
                return (
                    <ProductCard product={product} />
                );
            })}
        </SimpleGrid>
    );
}
export default ProductList;