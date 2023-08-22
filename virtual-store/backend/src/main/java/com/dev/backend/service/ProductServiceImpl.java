package com.dev.backend.service;

import com.dev.backend.dto.ProductDto;
import com.dev.backend.model.Product;
import com.dev.backend.repository.ProductRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final EntityManager entityManager;

    private final ProductRepository productRepository;

    public ProductServiceImpl(EntityManager entityManager, ProductRepository productRepository) {
        this.entityManager = entityManager;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto save(ProductDto dto) {
        return ParseUtils.parse(
                productRepository.saveAndFlush(ParseUtils.parse(dto, Product.class)),
                ProductDto.class);
    }

    @Override
    public List<ProductDto> saveAll(List<ProductDto> dtos) {
        return ParseUtils.parse(
                productRepository.saveAllAndFlush(ParseUtils.parse(dtos, Product.class)),
                ProductDto.class);
    }

    @Override
    public ProductDto findById(Integer id) {
        return ParseUtils.parse(productRepository.findById(id).orElse(null), ProductDto.class);
    }

    @Override
    public List<ProductDto> findAll() {
        return ParseUtils.parse(productRepository.findAll(), ProductDto.class);
    }

    @Override
    public List<ProductDto> findAllBy(Integer brandId, Integer categoryId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();
        if (brandId != null) {
            Predicate brandEqual = criteriaBuilder.equal(root.get("brand"), brandId);
            predicates.add(brandEqual);
        }
        if (categoryId != null) {
            Predicate categoryEqual = criteriaBuilder.equal(root.get("category"), categoryId);
            predicates.add(categoryEqual);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]))
                .distinct(true);

        TypedQuery<Product> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Product> queryResult = typedQuery.getResultList();

        return ParseUtils.parse(queryResult, ProductDto.class);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto update(ProductDto dto) {
        return ParseUtils.parse(
                productRepository.saveAndFlush(ParseUtils.parse(dto, Product.class)),
                ProductDto.class);
    }
}
