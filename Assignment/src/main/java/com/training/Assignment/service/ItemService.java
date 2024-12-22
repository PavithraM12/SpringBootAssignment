package com.training.Assignment.service;

import com.training.Assignment.entities.Item;
import com.training.Assignment.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item addItem(Item item){
        Item saveItem = itemRepository.save(item);
        return saveItem;
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item getItemById(int id){
        return itemRepository.findById(id).orElse(null);
    }

    public Item deleteItemById(int id){
        Item item = itemRepository.findById(id).orElse(null);
        itemRepository.deleteById(id);
        return item;
    }

    public Item putItemById(int id, Item putItem){
        Item item = itemRepository.findById(id).orElseThrow(null);
        item.setName(putItem.getName());
        item.setPrice(putItem.getPrice());
        return itemRepository.save(item);
    }

}
