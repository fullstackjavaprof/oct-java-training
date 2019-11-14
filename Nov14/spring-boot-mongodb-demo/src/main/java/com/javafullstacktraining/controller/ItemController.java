package com.javafullstacktraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstacktraining.docs.Item;
import com.javafullstacktraining.service.ItemService;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;
    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<Item> getItems(){
        return itemService.getAllItems();
    }

    @RequestMapping("/getItem")
    @ResponseBody
    public List<Item> getItem(@RequestParam("category") String category){
        return itemService.getItemByCategory(category);
    }

    @RequestMapping("/getItemById")
    @ResponseBody
    public Item getItemById(@RequestParam("item") long item){
        return itemService.getItemByItemId(item);
    }

    @RequestMapping("/addItem")
    @ResponseBody
    public String addItem(@RequestParam("itemId") long itemId,@RequestParam("serialNumber") String serialNumber,
                          @RequestParam("name") String name,
                          @RequestParam("category") String category){
        if(itemService.addItem(itemId,serialNumber,name,category) != null){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !!!!";
        }
    }
    @RequestMapping("/deteteItem")
    @ResponseBody
    public String deteteItem(@RequestParam("itemId") int itemId){
        if(itemService.deleteItem(itemId) == 1){
            return "Item Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}
