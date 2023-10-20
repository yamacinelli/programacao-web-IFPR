import axios from "axios";
import {Product} from "../model/Product";

class ProductService {

    PATH_URL = `http://localhost:8080/product`;

    save = (product: Product) => {
        return axios.post(this.PATH_URL, product);
    }

    findAll = () => {
        return axios.get(this.PATH_URL);
    }
}
export default ProductService;