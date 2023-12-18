package br.edu.ifpb.kramerclothing.backend.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.kramerclothing.backend.DTO.DataOrderCreateDTO;
import br.edu.ifpb.kramerclothing.backend.model.Order;
import br.edu.ifpb.kramerclothing.backend.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> read(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            Order orderSearched = this.orderService.getOrderById(id);
            if (orderSearched != null) {
                return Collections.singletonList(orderSearched);
            }

            return null;
        }

        return this.orderService.readAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return this.orderService.getOrderById(id);
    }

    @PostMapping
    public Order create(@RequestBody @Valid DataOrderCreateDTO order) {
        Order orderToCreate = new Order(
                order.date(),
                order.devolutionDate(),
                order.status(),
                order.price(),
                order.kitId(),
                order.planId(),
                order.clothesIds(),
                order.userId()
        );

        return this.orderService.createOrUpdate(orderToCreate);
    }

    @PutMapping
    public Order update(@RequestBody Order order) {
        return this.orderService.createOrUpdate(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.orderService.delete(id);
    }
}
