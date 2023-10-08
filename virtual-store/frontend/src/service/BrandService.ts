import {Brand} from "../model/Brand";
import axios from "axios";

class BrandService {

    PATH_URL = `${process.env.DOMAIN}/brand`;

    save = (brand: Brand) => {
        return axios.post(this.PATH_URL, brand);
    }
}
export default BrandService;