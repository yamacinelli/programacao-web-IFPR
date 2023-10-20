import {Brand} from "./Brand";
import {Category} from "./Category";
import {Image} from "./Image";

export class Product {
    id?: number;
    name?: string;
    shortDescription?: string;
    detailedDescription?: string;
    brand?: Brand;
    category?: Category;
    costValue?: number;
    saleValue?: number;
    image?: Image;
}