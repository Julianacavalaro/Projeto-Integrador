package com.deveducation.aspas.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_postagem")
public class PostagemModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_postagem;
	
	@Column
	@NotEmpty(message = "Digite o titulo da postagem")
	private String titulo;
	
	@Column
	@NotEmpty(message = "Digite a descrição")
	private String descricao;
	
	@Column
	private String imagem;
	
	@Column
	private String video;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date data_postagem;
	
	//Muitas postagens podem ser feitas sobre Um tema
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;
	
	//Muitas postagens podem ser feitas por Um Usuário
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private UsuarioModel usuario;
	
	//Uma postagem pode ter Vários comentários
	@OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("postagem")
	private List<ComentarioModel> comentario;
	

	public List<ComentarioModel> getComentario() {
		return comentario;
	}

	public void setComentario(List<ComentarioModel> comentario) {
		this.comentario = comentario;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}

	public Long getId_postagem() {
		return id_postagem;
	}

	public void setId_postagem(Long id_postagem) {
		this.id_postagem = id_postagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Date getData_postagem() {
		return data_postagem;
	}

	public void setData_postagem(Date data_postagem) {
		this.data_postagem = data_postagem;
	}
	
	

}