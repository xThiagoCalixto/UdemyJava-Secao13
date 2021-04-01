package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.StatusOrder;

public class Order {

	private Date moment;
	private StatusOrder status;
	
	public Order () {
		
	}
	
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public StatusOrder getStatus() {
		return status;
	}
	public void setStatus(StatusOrder status) {
		this.status = status;
	}

	
	public Order(Date moment, StatusOrder status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	private Client client;
	private List<OrderItem> orderItens = new ArrayList<>();

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItens() {
		return orderItens;
	}
	
	public void addOrderItem (OrderItem orderItem) {
		orderItens.add(orderItem);
	}
	
	public void removeOrderItem (OrderItem orderItem) {
		orderItens.remove(orderItem);
	}
	
	public double total() {
		double soma = 0;
		for (OrderItem c : orderItens) {
			soma += c.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		return "Order [moment=" + moment + ", status=" + status + ", client=" + client.getName() + ", orderItens=" + orderItens
				+ "]" + "Total Compras " + total();
	}

		
	
	
}
