package com.example.ordre.Order;

import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class OrderService {
    private OrderRepo orderRepo ;


    public OrderService(OrderRepo orderRepo) {
       this.orderRepo=orderRepo;

    }

    public void   createOrder(OrderRequest orderRequest) {

      Erp order=new Erp(orderRequest.getOf(),orderRequest.getClient()
      ,orderRequest.getLot(),orderRequest.getQteLot(),orderRequest.getQteFabriquer());
        orderRepo.save(order);
    }


    public List<Erp> getAllOrders() {
       return orderRepo.findAll() ;
    }

    public Erp findOrderById(Long id){
        return orderRepo.findOrderById(id);
    }

    public List<Erp> findOrderByOf(String of){
        return orderRepo.findOrderByOf(of);
    }

    public List<Erp> findOderByClient(String client){
        return orderRepo.findOderByClient(client);
    }


    public void deleteOrderById(Long id){
         orderRepo.deleteOrderById(id);
    }

    public int updateOrderById(Long id , Response orderRequest){

        Erp updateOrder= new Erp(orderRequest.getOf(),orderRequest.getClient(),orderRequest.getLot(),orderRequest.getQteLot(),orderRequest.getQteFabriquer());
      return   orderRepo.updateOrderById(id,updateOrder.getClient() ,updateOrder.getOf()
                ,updateOrder.getLot(),updateOrder.getQteLot() ,updateOrder.getQteFabriquer(),updateOrder.getCreateDate());

    }
}
