package se.bastagruppen.webshop.interfaces;

import se.bastagruppen.webshop.model.Order;

public interface OrderRepository extends CrudRepository<Order> {
    /* example getOrderByStatus, cancelOrder(String id); */
}