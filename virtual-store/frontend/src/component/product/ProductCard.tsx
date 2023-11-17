import {Card, CardBody, CardFooter, Heading, Text, VStack} from "@chakra-ui/react";
import {Product} from "../../model/Product";

const ProductCard = ({product}: {product: Product}) => {

    return (
        <Card variant={'filled'}>
            <CardBody>
                <VStack spacing={'1rem'}>
                    <Heading>{product.name}</Heading>
                    <Text>{product.shortDescription}</Text>
                </VStack>
            </CardBody>
            <CardFooter>
                <Text>$ {product.saleValue}</Text>
            </CardFooter>
        </Card>
    );
}
export default ProductCard;