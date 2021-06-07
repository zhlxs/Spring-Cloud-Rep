package com.boot.mall.test0530;

public class Order<T>
{
	String orderName;

	int orderId;

	T t;

	public Order()
	{

	}

	public Order(String orderName, int orderId, T t)
	{
		this.orderName = orderName;
		this.orderId = orderId;
		this.t = t;
	}

	public T getT()
	{
		return t;
	}

	public void setT(T t)
	{
		this.t = t;
	}

	@Override
	public String toString()
	{
		return "Order{" + "orderName='" + orderName + '\'' + ", orderId=" + orderId + ", t=" + t + '}';
	}
}
