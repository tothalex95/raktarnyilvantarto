package hu.uni.miskolc.iit.swtest.registrar.persist.mysql.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import hu.uni.miskolc.iit.swtest.registrar.model.Order;


public interface OrderMapper {

	public Collection<Order> selectOrders();
	
	public Collection<Order> selectOrdersByOrderId(int orderId);
	
	public Collection<Order> selectOrdersByProductId(int product);
	
	public Collection<Order> selectOrdersByCustomerID(int customer);
	
	public Collection<Order> selectOredersByCount(int count);
	
	//public Order selectOrdersById(int id);
	
	//public void updateOrder(@Param("order") Order order);
	
	public void deleteOrder(@Param("order") Order order);	
}