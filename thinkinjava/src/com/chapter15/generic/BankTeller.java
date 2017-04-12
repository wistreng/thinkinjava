package com.chapter15.generic;

import java.util.*;

import net.mindview.util.Generator;

class Customer {
	private static long counter = 1;
	private final long id = counter++;
	private Customer() {};
	public String toString(){
		return ("Customer id: "+id);
	}
	public static Generator<Customer> generator(){
		return new Generator<Customer>(){
			public Customer next(){return new Customer();}
		};
	}
}

class Teller {
	private static long counter = 1;
	private final long id = counter++;
	private Teller() {};
	public String toString(){
		return ("Teller id: "+id);
	}
	public static Generator<Teller> generator = 
		new Generator<Teller>(){
			public Teller next(){return new Teller();}
		};
}


public class BankTeller {
	public static void serve(Teller t, Customer c){
		System.out.println(t+" serves "+c);
	}
	public static void main(String[] args){
		Random rand = new Random(47);
		Queue<Customer> line = new LinkedList<Customer>();
		Generators.fill(line, Customer.generator(), 15);
		List<Teller> tellers = new ArrayList<Teller>();
		//注意下面的generator和上面的generator()的区别
		Generators.fill(tellers, Teller.generator, 5);
		for(Customer c:line)
			serve(tellers.get(rand.nextInt(tellers.size())), c);
	}
}

/**
 * output:
Teller id: 4 serves Customer id: 1
Teller id: 1 serves Customer id: 2
Teller id: 4 serves Customer id: 3
Teller id: 2 serves Customer id: 4
Teller id: 2 serves Customer id: 5
Teller id: 5 serves Customer id: 6
Teller id: 4 serves Customer id: 7
Teller id: 1 serves Customer id: 8
Teller id: 3 serves Customer id: 9
Teller id: 3 serves Customer id: 10
Teller id: 4 serves Customer id: 11
Teller id: 4 serves Customer id: 12
Teller id: 2 serves Customer id: 13
Teller id: 5 serves Customer id: 14
Teller id: 5 serves Customer id: 15
 */
