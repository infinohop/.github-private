package com.project.backend.services;


import com.project.backend.dtos.OrderDetailsReqDTO;
import com.project.backend.dtos.OrderRespDTO;
import com.project.backend.entities.Order;

import java.util.List;

public interface OrderService {

    List<OrderRespDTO> findAllOrders();

    OrderRespDTO findOrderById(int orderId);

    OrderRespDTO placeOrder(int userId, List<OrderDetailsReqDTO> orderDetailsReqDTOS);

}
