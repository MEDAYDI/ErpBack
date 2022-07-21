package com.example.ordre.Order;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class orderController {
      OrderService orderService ;
      RestTemplate restTemplate = new RestTemplate() ;
      private  String baseUrl="http://localhost:8080";



    public orderController(OrderService orderService  ) {
        this.orderService=orderService;
    }

    @PostMapping("/addmicro")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrderMicro(@RequestBody OrderRequest orderRequest){
        orderService.createOrder(orderRequest);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderRequest>  createOrder(@RequestBody OrderRequest orderRequest){
        orderService.createOrder(orderRequest);
       ResponseEntity<List>  orders = restTemplate.postForEntity(baseUrl+"/api/produit" ,orderRequest,List.class );
       return new ResponseEntity<>(orderRequest,HttpStatus.CREATED) ;

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Response>  updateOrderById(@PathVariable("id") Long id , @RequestBody Response orderRequest){
          restTemplate.put(baseUrl+"/api/produit/{id}",orderRequest,id);
          int res = orderService.updateOrderById(id , orderRequest) ;
           return new ResponseEntity<>(orderRequest , HttpStatus.OK);
    }

    @PutMapping("/updatemicro/{id}")
    public ResponseEntity<Response> updatemicroOrderById(@PathVariable("id") Long id , @RequestBody Response orderRequest){
               int update = orderService.updateOrderById(id , orderRequest) ;
               return new ResponseEntity<>(orderRequest,HttpStatus.OK);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Erp> getAllOrders()  {

        return orderService.getAllOrders();
    }

    @GetMapping("/findId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Erp getOrderById(@PathVariable("id") Long id){
        return  orderService.findOrderById(id);
          }

    @GetMapping("/findOf/{of}")
    @ResponseStatus(HttpStatus.OK)
    public List<Erp> getOrderById(@PathVariable("of") String of){
        return orderService.findOrderByOf(of);
    }

    @GetMapping("/findClient/{client}")
    @ResponseStatus(HttpStatus.OK)
    public List<Erp> findOderByClient(@PathVariable("client") String client){
        return orderService.findOderByClient(client);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteOrderById(@PathVariable("id") Long id){
        orderService.deleteOrderById(id);
        restTemplate.delete(baseUrl+"/api/produit/delete/{id}",id);
        return  new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/delmicro/{id}")
    @ResponseStatus(HttpStatus.OK)
     public ResponseEntity<?> deleteOrdermicroById(@PathVariable("id") Long id ){
        orderService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
