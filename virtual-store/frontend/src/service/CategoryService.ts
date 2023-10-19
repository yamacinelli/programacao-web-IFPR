import axios from "axios";
import {Category} from "../model/Category";

class CategoryService {

    PATH_URL = `http://localhost:8080/category`;

    save = (category: Category) => {
        return axios.post(this.PATH_URL, category);
    }

    findAll = () => {
        return axios.get(this.PATH_URL);
    }
}
export default CategoryService;