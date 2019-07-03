package com.mypack.service;

import com.lly835.bestpay.model.PayResponse;
import com.mypack.dto.OrderDTO;

public interface PayService {
    PayResponse create(OrderDTO orderDTO);
}
