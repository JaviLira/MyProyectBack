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

@Entity
@Table(name="Chat")
public class Chat {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany
	private List<Mensajes> listapedidos=new ArrayList<>();
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


	public List<Mensajes> getListapedidos() {
		return listapedidos;
	}


	public void setListapedidos(List<Mensajes> listapedidos) {
		this.listapedidos = listapedidos;
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
		return "Chat [id=" + id + ", listapedidos=" + listapedidos + ", listaUsuarios=" + listaUsuarios + "]";
	}
	
	
	
	
	
	

}
