package com.example.springmicro.orderservice.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mrvladimort.springmicro.api.v1.OrderApi;
import org.example.mrvladimort.springmicro.dto.CreateOrderRequestDTO;
import org.example.mrvladimort.springmicro.dto.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    @Override
    public Mono<ResponseEntity<OrderDTO>> createOrder(Mono<CreateOrderRequestDTO> createOrderRequestDTO, ServerWebExchange exchange) {
        return createOrderRequestDTO
                .map(res -> ResponseEntity.status(HttpStatus.OK).body(new OrderDTO()));
    }
}
