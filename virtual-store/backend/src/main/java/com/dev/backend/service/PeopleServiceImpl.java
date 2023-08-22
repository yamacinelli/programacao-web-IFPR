package com.dev.backend.service;

import com.dev.backend.dto.PeopleDto;
import com.dev.backend.model.*;
import com.dev.backend.repository.PeopleRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final EntityManager entityManager;

    private final PeopleRepository peopleRepository;

    private final AddressServiceImpl addressServiceImpl;

    public PeopleServiceImpl(EntityManager entityManager, PeopleRepository peopleRepository, AddressServiceImpl addressServiceImpl) {
        this.entityManager = entityManager;
        this.peopleRepository = peopleRepository;
        this.addressServiceImpl = addressServiceImpl;
    }

    @Override
    public PeopleDto save(PeopleDto dto) {
        // Save Address
        dto.setAddress(addressServiceImpl.save(dto.getAddress()));
        // Save People
        return ParseUtils.parse(
                peopleRepository.saveAndFlush(ParseUtils.parse(dto, People.class)),
                PeopleDto.class);
    }

    @Override
    public List<PeopleDto> saveAll(List<PeopleDto> dtos) {
        return ParseUtils.parse(
                peopleRepository.saveAllAndFlush(ParseUtils.parse(dtos, People.class)),
                PeopleDto.class);
    }

    @Override
    public PeopleDto findById(Integer id) {
        return ParseUtils.parse(peopleRepository.findById(id).orElse(null), PeopleDto.class);
    }

    @Override
    public List<PeopleDto> findAll() {
        return ParseUtils.parse(peopleRepository.findAll(), PeopleDto.class);
    }

    @Override
    public List<PeopleDto> findAllBy(Integer cityId, Integer permissionId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<People> criteriaQuery = criteriaBuilder.createQuery(People.class);
        Root<People> root = criteriaQuery.from(People.class);

        List<Predicate> predicates = new ArrayList<>();
        if (cityId != null) {
            Join<People, Address> addressJoin = root.join("address");
            Predicate cityEqual = criteriaBuilder.equal(addressJoin.get("city"), cityId);
            predicates.add(cityEqual);
        }
        if (permissionId != null) {
            Join<People, Permission> permissionJoin = root.join("permission");
            Predicate permissionEqual = criteriaBuilder.equal(permissionJoin.get("id"), permissionId);
            predicates.add(permissionEqual);
        }
        criteriaQuery.multiselect(root.get("id"), root.get("name"), root.get("cpf"), root.get("email"))
                .where(predicates.toArray(new Predicate[0]))
                .distinct(true);

        TypedQuery<People> typedQuery = entityManager.createQuery(criteriaQuery);
        List<People> queryResult = typedQuery.getResultList();

        return ParseUtils.parse(queryResult, PeopleDto.class);
    }

    @Override
    public void delete(Integer id) {
        peopleRepository.deleteById(id);
    }

    @Override
    public PeopleDto update(PeopleDto dto) {
        return ParseUtils.parse(
                peopleRepository.saveAndFlush(ParseUtils.parse(dto, People.class)),
                PeopleDto.class);
    }
}
