package modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exceptions.ExceptionDescuento;


public class Compra {
	private double total;
	private List<Item> items;
	private LocalDateTime fecha;
	private IDescuento descuento;
	
	public Compra() {
		this.items = new ArrayList<Item>();
		this.fecha = LocalDateTime.now();
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	public IDescuento getDescuento() {
		return descuento;
	}

	public void setDescuento(IDescuento descuento) {
		this.descuento = descuento;
	}
	
	public void agregarItem(Item it) {
		this.items.add(it);
	}
	
	public void removeItem(Item it) {
		this.items.remove(it);
	}
	
	public void aplicarDescuento() {
		double aux=0;
		try {
			aux = this.descuento.calcularDescuento();
			if(aux>0) {
				this.setTotal(aux);
			}
		} catch (ExceptionDescuento e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error el descuento no puede ser menor o igual a 0");
		}
	}

	public String calcularTotalCompra() {
		Iterator<Item> item=this.getItems().iterator();
		while(item.hasNext()) {
			Item it=(Item) item.next();
			this.total+=Double.parseDouble(it.calcularTotal());
		}
		return String.valueOf(this.getTotal());
		
		
		/*for(int i=0;i<this.getItems().length;i++) {
			Item it=this.getItems()[i];
			if(it!=null) {
				this.total+=Double.parseDouble(it.calcularTotal());
			}
		}
		return String.valueOf(this.getTotal());*/
	}
	
	
	
	
	
	
}
