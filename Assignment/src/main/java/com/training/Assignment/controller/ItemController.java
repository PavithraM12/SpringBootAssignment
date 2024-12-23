package com.training.Assignment.controller;

import com.training.Assignment.entities.Item;
import com.training.Assignment.repo.ItemRepository;
import com.training.Assignment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

//    @Autowired
//    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @PostMapping
    public Item addItem(@RequestBody Item item){
        return itemService.addItem(item);
    }

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id){
        return itemService.getItemById(id);

    }

    @DeleteMapping("/{id}")
    public Item deleteItemById(@PathVariable int id){
        return itemService.deleteItemById(id);
    }

    @PutMapping("/{id}")
    public Item putItemById(@PathVariable int id, @RequestBody Item putItem){
        return itemService.putItemById(id, putItem);
    }
}
