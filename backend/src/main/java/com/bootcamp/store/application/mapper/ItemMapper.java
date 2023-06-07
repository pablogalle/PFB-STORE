package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.ItemDTO;
import com.bootcamp.store.domain.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {

    @Override
    @Mapping(source = "categoryId", target = "category")
    Item toEntity(ItemDTO dto);

    @Override
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target ="categoryName")
    ItemDTO toDto(Item entity);

    default Item fromId(Long id){
        if (id == null) return null;

        var item = new Item();
        item.setId(id);
        return item;
    }

    default Long toId ( Item item){
        if (item == null) return null;

        return item.getId();
    }
}
