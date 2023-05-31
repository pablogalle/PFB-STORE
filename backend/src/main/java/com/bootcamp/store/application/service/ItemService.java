package com.bootcamp.store.application.service;

import com.bootcamp.store.application.dto.ItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDTO> getAllItemsByCategory(Long categoryId);
    List<ItemDTO> getAllItems();
    Page<ItemDTO> getItemsByCriteriaStringPaged(Pageable pageable, String filter);
    Optional<ItemDTO> getItemById(Long itemId);
    ItemDTO saveItem(ItemDTO itemDTO);
    void deleteItem(Long itemId);

}
