package home.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="chat")
public class Chat {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnore
	@OneToMany
	private List<Mensajes> listaMensajes=new ArrayList<>();
	@JsonIgnore
	@ManyToMany
	private List<UserBase> listaUsuarios=new ArrayList<>();
	
	public Chat() {
		super();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Mensajes> getListaMensajes() {
		return listaMensajes;
	}


	public void setListaMensajes(List<Mensajes> listapedidos) {
		this.listaMensajes = listapedidos;
	}


	public List<UserBase> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public void setListaUsuarios(List<UserBase> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
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
		Chat other = (Chat) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Chat [id=" + id + ", listaMensajes=" + listaMensajes + ", listaUsuarios=" + listaUsuarios + "]";
	}
	
	
	
	
	
	

}
