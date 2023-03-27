package modelos;

import Exceptions.ExceptionDescuento;

public class DescuentoPorcentaje implements IDescuento{
	private double monto;
	private double descuentoPorcentaje;
	
	public DescuentoPorcentaje(double monto, double descuentoPorcentaje) {
		super();
		this.monto = monto;
		this.descuentoPorcentaje = descuentoPorcentaje;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getDescuentoPorcentaje() {
		return descuentoPorcentaje;
	}

	public void setDescuentoPorcentaje(double descuentoPorcentaje) {
		this.descuentoPorcentaje = descuentoPorcentaje;
	}

	@Override
	public double calcularDescuento() throws ExceptionDescuento {
		// TODO Auto-generated method stub
		double aux=this.getMonto()-(this.getMonto()*this.getDescuentoPorcentaje()/100);
		if(aux>=this.getMonto()) {
			throw new ExceptionDescuento(this);
		}
		return aux;
	}
	
}
