package home.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Mensaje")
public class Mensajes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fecha;
	private String texto;
	@ManyToOne
	private UserBase usuarioEmisor;
	@ManyToOne
	private Chat conversacion;
	
	public Mensajes(String texto, UserBase usuarioEmisor, Chat conversacion) {
		super();
		this.fecha = new Date();
		this.texto = texto;
		this.usuarioEmisor = usuarioEmisor;
		this.conversacion = conversacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public UserBase getUsuarioEmisor() {
		return usuarioEmisor;
	}

	public void setUsuarioEmisor(UserBase usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}

	public Chat getConversacion() {
		return conversacion;
	}

	public void setConversacion(Chat conversacion) {
		this.conversacion = conversacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensajes other = (Mensajes) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Mensajes [id=" + id + ", fecha=" + fecha + ", texto=" + texto + ", usuarioEmisor=" + usuarioEmisor
				+ ", conversacion=" + conversacion + "]";
	}

	
	
	
	
}
