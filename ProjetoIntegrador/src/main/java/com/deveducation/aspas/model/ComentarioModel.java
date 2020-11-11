package com.deveducation.aspas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_comentario")
public class ComentarioModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_comentario;

	@Column
	@NotEmpty
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date data;
	
	
	//Muitos Comentários podem pertencer a Um usuário
	@ManyToOne
	@JsonIgnoreProperties("comentario")
	private UsuarioModel usuario;
	
	//Muitos Comentários podem pertencer a Uma postagem
	@ManyToOne
	@JsonIgnoreProperties("comentario")
	private PostagemModel postagem;
	
	public PostagemModel getPostagem() {
		return postagem;
	}

	public void setPostagem(PostagemModel postagem) {
		this.postagem = postagem;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public Long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
}