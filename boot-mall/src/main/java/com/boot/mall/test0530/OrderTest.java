package com.boot.mall.test0530;

import java.util.List;

public class OrderTest
{
	public void test1()
	{
		Order order = new Order();
		order.setT(1);
		order.setT("a");

		Order<String> order1 = new Order<String>("A", 1, "a");
		order1.setT("b");

		//通配符?
		List<Object> list1 = null;
		List<String> list2 = null;
		List<?> list = null;//公共的父类

		//有限制条件的通配符
		List<? extends Person> list_1 = null;//Person的子类
		List<? super Person> list_2 = null;//上限
	}
}
