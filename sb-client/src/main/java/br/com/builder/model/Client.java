package br.com.builder.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "client")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 613170126577551509L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	@Column(name = "email", length = 50)
	private String email;
	@Column(name = "idade", length = 3)
	private String idade;
	@Column(name = "data_cadastro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();
	
	public String getDataCadastro() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return dataCadastro != null ? df.format(dataCadastro) : ""; 
	}
	

}
