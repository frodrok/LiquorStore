package se.groupone.webshop.interfaces;

import se.groupone.webshop.model.Order;

public interface OrderRepository extends CrudRepository<Order, String> {
    /* example getOrderByStatus, cancelOrder(String id); */
}