package br.edu.ifpb.kramerclothing.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.kramerclothing.backend.model.Order;
import br.edu.ifpb.kramerclothing.backend.repository.OrderRepositoryIF;
import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepositoryIF orderRepository;

    public List<Order> readAll() {
        return this.orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    @Transactional
    public Order createOrUpdate(Order order) {
        Order orderSearched = this.orderRepository.save(order);

        // Modificação fictícia para exemplificar
        order.setDate(order.getDate() + " - alterado");
        return orderSearched;
    }

    public void delete(Long id) {
        this.orderRepository.deleteById(id);
    }
}
