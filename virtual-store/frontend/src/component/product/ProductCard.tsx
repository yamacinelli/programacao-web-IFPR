import {Card, CardBody, CardFooter, CardHeader, Heading, HStack, Text, VStack} from "@chakra-ui/react";
import {Product} from "../../model/Product";

const ProductCard = ({ product, onClick }: { product: Product, onClick: any }) => {

    return (
        <Card
            variant={'outline'}
            onClick={onClick}
        >
            <CardBody>
                <VStack
                    spacing={'1rem'}
                    align={'start'}
                    textAlign={'start'}
                >
                    <Heading size={'md'}>{product.name}</Heading>
                    <Text fontSize={'sm'}>{product.shortDescription}</Text>
                </VStack>
            </CardBody>
            <CardFooter>
                <VStack align={'start'}>
                    <Heading size={'xs'}>{product.brand?.name}</Heading>
                    <Text color={'teal'} fontWeight={'bold'}>$ {product.saleValue}</Text>
                </VStack>
            </CardFooter>
        </Card>
    );
}
export default ProductCard;