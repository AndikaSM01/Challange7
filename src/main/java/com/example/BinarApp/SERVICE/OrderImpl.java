package com.example.BinarApp.SERVICE;

import com.example.BinarApp.ENTITY.Order;
import com.example.BinarApp.ENTITY.OrderDetail;
import com.example.BinarApp.ENTITY.Product;
import com.example.BinarApp.ENTITY.User;
import com.example.BinarApp.MODEL.REQUEST.OrderRequest;
import com.example.BinarApp.MODEL.RESPONSE.OrderResponse;
import com.example.BinarApp.MODEL.ENUM.OrderStatus;
import com.example.BinarApp.REPOSITORY.OrderDetailRepository;
import com.example.BinarApp.REPOSITORY.OrderRepository;
import com.example.BinarApp.REPOSITORY.ProdukRepository;
import com.example.BinarApp.REPOSITORY.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ProdukRepository produkRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Optional<User>user = userRepository.findById(orderRequest.getUserId());
        if(!user.isPresent()){
            return null;

        }
        Order order = new Order();
        order.setOrderTime(new Date());
        order.setDestinationAddress(orderRequest.getDestinationAddress());
        order.setCompleted(OrderStatus.COMPLETE);
        order.setUser(user.get());
        List<OrderDetail>orderDetails = orderRequest.getOrderItem().stream()
                .map((T)->{
                    Optional<Product> product = produkRepository.findById(T.getProductId());
                    Double Total = product.get().getPrice()*T.getQuantity();
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setQuantity(T.getQuantity());
                    orderDetail.setTotalPrice(Total);
                    orderDetail.setProduct(product.get());
                    return orderDetail;


                } ).collect(Collectors.toList());
        order.setOrderDetailList(orderDetails);
        orderRepository.save(order);
     return null;
    }
}
