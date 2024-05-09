package com.khabalita.springboot.mapper;

import com.khabalita.springboot.dto.OrderDTO;
import com.khabalita.springboot.entities.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Order orderDTOToOrder(OrderDTO orderDTO){
        Order order = modelMapper.map(orderDTO, Order.class);
        return order;
    }

    public OrderDTO orderToOrderDTO(Order order){
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        return orderDTO;
    }
}
