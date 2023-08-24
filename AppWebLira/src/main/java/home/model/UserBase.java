package home.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class UserBase {
	

	private String name;
	@Id
	private String email;
	private String telefono;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private Roles rol=Roles.ROLE_USER;
	@JsonIgnore
	@OneToMany
	private List<Chat> chats=new ArrayList<>();
	
	public UserBase(String name, String email, String telefono, String password) {
		super();
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
	}
	
	public UserBase(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public UserBase() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRol() {
		return rol;
	}
	public void setRol(Roles rol) {
		this.rol = rol;
	}
	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	@Override
	public String toString() {
		return "UserBase [name=" + name + ", email=" + email + ", telefono=" + telefono + ", password="
				+ password + ", rol=" + rol + ", chats=" + chats + "]";
	}
	
	

	
	
	
	
}
