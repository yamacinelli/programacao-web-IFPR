package com.dev.backend.service;

import com.dev.backend.dto.ShoppingCartDto;
import com.dev.backend.model.ShoppingCart;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.ShoppingCartRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartService implements GenericModel<ShoppingCartDto> {

    private final EntityManager entityManager;

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(EntityManager entityManager, ShoppingCartRepository shoppingCartRepository) {
        this.entityManager = entityManager;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCartDto save(ShoppingCartDto dto) {
        return ParseUtils.parse(
                shoppingCartRepository.saveAndFlush(ParseUtils.parse(dto, ShoppingCart.class)),
                ShoppingCartDto.class);
    }

    @Override
    public List<ShoppingCartDto> saveAll(List<ShoppingCartDto> dtos) {
        return ParseUtils.parse(
                shoppingCartRepository.saveAllAndFlush(ParseUtils.parse(dtos, ShoppingCart.class)),
                ShoppingCartDto.class);
    }

    @Override
    public ShoppingCartDto findById(Integer id) {
        return ParseUtils.parse(shoppingCartRepository.findById(id).orElse(null), ShoppingCartDto.class);
    }

    @Override
    public List<ShoppingCartDto> findAll() {
        return ParseUtils.parse(shoppingCartRepository.findAll(), ShoppingCartDto.class);
    }

    public List<ShoppingCartDto> findAllBy(Integer peopleId, Date start, Date end, String situation) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ShoppingCart> criteriaQuery = criteriaBuilder.createQuery(ShoppingCart.class);
        Root<ShoppingCart> root = criteriaQuery.from(ShoppingCart.class);

        List<Predicate> predicates = new ArrayList<>();
        if (peopleId != null) {
            Predicate peopleEqual = criteriaBuilder.equal(root.get("people"), peopleId);
            predicates.add(peopleEqual);
        }
        if (start != null && end != null) {
            Predicate between = criteriaBuilder.between(root.get("createdDate"), start, end);
            predicates.add(between);
        } else if (start != null) {
            Predicate between = criteriaBuilder.between(root.get("createdDate"), start, new Date());
            predicates.add(between);
        } else if (end != null) {
            Predicate between = criteriaBuilder.between(root.get("createdDate"), new Date(0), end);
            predicates.add(between);
        }
        if (situation != null) {
            Predicate situationEqual = criteriaBuilder.equal(root.get("situation"), situation);
            predicates.add(situationEqual);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]))
                .distinct(true);

        TypedQuery<ShoppingCart> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ShoppingCart> queryResult = typedQuery.getResultList();

        return ParseUtils.parse(queryResult, ShoppingCartDto.class);
    }

    @Override
    public void delete(Integer id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public ShoppingCartDto update(ShoppingCartDto dto) {
        return ParseUtils.parse(
                shoppingCartRepository.saveAndFlush(ParseUtils.parse(dto, ShoppingCart.class)),
                ShoppingCartDto.class);
    }
}
