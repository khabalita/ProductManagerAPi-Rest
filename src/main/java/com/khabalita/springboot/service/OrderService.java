package com.khabalita.springboot.service;

import com.khabalita.springboot.dto.OrderDTO;
import com.khabalita.springboot.entities.Order;
import com.khabalita.springboot.mapper.OrderMapper;
import com.khabalita.springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    public Order newOrder(OrderDTO orderDTO) throws Exception{
        try{
            Order order = orderMapper.orderDTOToOrder(orderDTO);
            Order orderSaved = orderRepository.save(order);
            return orderSaved;
        }catch(Exception e){
            throw new Exception ("La orden no fue creada" + e.getMessage());
        }
    }

    public List<OrderDTO> listAllOrders() throws Exception{
        try{
            List<Order> orders = orderRepository.findAll();
            List<OrderDTO> orderDTOList = new ArrayList<>();
            for(Order order: orders){
                orderDTOList.add(orderMapper.orderToOrderDTO(order));
            }
            return orderDTOList;
        }catch(Exception e){
            throw new Exception("No se pudo devolver la orden" + e.getMessage());
        }
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) throws Exception{
        try{
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de orden no encontrado" + id));
            orderMapper.orderDTOToOrder(orderDTO);
            Order updatedOrder = orderRepository.save(order);
            return orderMapper.orderToOrderDTO(updatedOrder);
        }catch(Exception e){
            throw new Exception("No se pudo actualizar la orden" + e.getMessage());
        }
    }

    public void deletedOrder(Long id) throws Exception{
        try{
            orderRepository.deleteById(id);
        }catch(Exception e){
            throw new Exception("No se pudo eliminar la orden" + e.getMessage());
        }
    }

    public OrderDTO findOrderById(Long id) throws Exception{
        try{
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de orden no encontrado" + id));
            return orderMapper.orderToOrderDTO(order);
        }catch (Exception e){
            throw new Exception("No se pudo traer la orden" + e.getMessage());
        }
    }
}
