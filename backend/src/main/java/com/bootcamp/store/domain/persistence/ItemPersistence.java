package com.bootcamp.store.domain.persistence;

import com.bootcamp.store.domain.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ItemPersistence {
    List<Item> getAllItemsByCategory(Long categoryId);
    List<Item> getAllItems();
    Optional<Item> getItemById(Long itemId);
    Item saveItem(Item item);
    void deleteItem(Long itemId);
    Page<Item> findAll(Pageable pageable, String filter);
}
