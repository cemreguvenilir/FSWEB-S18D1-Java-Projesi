package com.workintech.jpa.dao;

import com.workintech.jpa.entity.BreadType;
import com.workintech.jpa.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    List<Burger> findAll();
    Burger findById(int id);
    List<Burger> findByPrice(double price);
    List<Burger> findByBreadType(BreadType breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    void delete(Burger burger);
}
