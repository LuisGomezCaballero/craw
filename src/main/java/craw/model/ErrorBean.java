package craw.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "errorBean")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorBean {

    @XmlElement
	private Boolean exito;

    @XmlElement
	private String descripcion;

	public ErrorBean() {
	}

	public ErrorBean(Boolean exito, String descripcion) {
		this.exito = exito;
		this.descripcion = descripcion;
	}

	public Boolean getExito() {
		return exito;
	}

	public void setExito(Boolean exito) {
		this.exito = exito;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ErrorBean [exito=" + exito + ", descripcion=" + descripcion + "]";
	}

}
