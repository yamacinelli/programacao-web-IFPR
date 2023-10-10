import {Brand} from "../model/Brand";
import axios from "axios";

class BrandService {

    PATH_URL = `http://localhost:8080/brand`;

    save = (brand: Brand) => {
        return axios.post(this.PATH_URL, brand);
    }

    findAll = () => {
        return axios.get(this.PATH_URL);
    }
}
export default BrandService;