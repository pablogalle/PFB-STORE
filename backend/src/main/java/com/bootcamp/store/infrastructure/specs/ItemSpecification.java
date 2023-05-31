package com.bootcamp.store.infrastructure.specs;


import com.bootcamp.store.domain.entity.Item;
import com.bootcamp.store.infrastructure.specs.shared.EntitySpecification;
import com.bootcamp.store.infrastructure.specs.shared.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public class ItemSpecification extends EntitySpecification<Item> implements Specification<Item> {


    public ItemSpecification(List<SearchCriteria> criteria) {
        this.criteria = criteria;
    }



}