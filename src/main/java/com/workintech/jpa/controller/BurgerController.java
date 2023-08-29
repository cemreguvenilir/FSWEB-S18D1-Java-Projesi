package com.workintech.jpa.controller;

import com.workintech.jpa.dao.BurgerDao;
import com.workintech.jpa.entity.BreadType;
import com.workintech.jpa.entity.Burger;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burgers")
@Validated
public class BurgerController {
    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }
    @GetMapping("/")
    public List<Burger> get(){
        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger getById(@Positive @PathVariable int id){
        return burgerDao.findById(id);
    }
    @PostMapping("/")
    public Burger save(@Validated @RequestBody Burger burger){
        return burgerDao.save(burger);
    }
    @PutMapping("/")
    public Burger update(@RequestBody Burger burger){
        return burgerDao.update(burger);
    }
    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable int id){
        Burger burger = getById(id);
        burgerDao.delete(burger);
        return burger;

    }
    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable double price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType){
        return burgerDao.findByBreadType(BreadType.BURGER);
    }
    @GetMapping("/findByContent/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }


}
