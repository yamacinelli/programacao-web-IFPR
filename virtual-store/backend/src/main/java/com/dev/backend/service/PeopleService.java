package com.dev.backend.service;

import com.dev.backend.dto.PeopleDto;
import com.dev.backend.model.Address;
import com.dev.backend.model.GenericModel;
import com.dev.backend.model.People;
import com.dev.backend.repository.PeopleRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PeopleService implements GenericModel<PeopleDto> {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public PeopleDto save(PeopleDto dto) {
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

    public List<PeopleDto> findAllBy(Map<String, Integer> params) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<People> criteriaQuery = criteriaBuilder.createQuery(People.class);
        Root<People> root = criteriaQuery.from(People.class);

        List<Predicate> predicates = new ArrayList<>();
        if (params.containsKey("city")) {
            Predicate city = criteriaBuilder.equal(root.get("city"), params.get("city"));
            predicates.add(city);
        }
        if (params.containsKey("permission")) {
            Join<People, Address> join = root.join("address");
            Predicate permission = criteriaBuilder.equal(join.get("id"), params.get("permission"));
            predicates.add(permission);
        }
        criteriaQuery.multiselect(root.get("id"), root.get("name"), root.get("cpf"), root.get("email"));

        List<People> queryPeople = entityManager.createQuery(criteriaQuery).getResultList();

        return ParseUtils.parse(queryPeople, PeopleDto.class);
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
