package br.edu.facec.cliente.entity

import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Endereco(
    @Id
    @GeneratedValue
    val id: UUID?,

    @Column(name = "cep")
    @field:NotBlank(message = "Por favor insira seu cep!")
    @field:Length(message = " O CEP deve ter no máximo 8 caracteres", max = 8)
    val cep: String,

    @Column(name = "rua")
    @field:NotBlank(message = "Por favor insira o nome da Rua!")
    @field:Length(message = "O nome da rua deve ter no máximo 100 caracteres", max = 100)
    val rua: String,

    @Column(name = "numero")
    @field:NotBlank(message = "Por favor insira o numero de seu endereço")
    @field:Length(message = "O numero deve ter no máximo 10 caracteres", max = 10)
    val numero: String,

    @Column(name = "bairro")
    @field:NotBlank(message = "Por favor insira o nome de seu bairro!")
    @field:Length(message = "O nome de seu bairro deve ter no máximo 100 caracteres", max = 100)
    val bairro: String,

    @Column(name = "complemento")
    @field:NotBlank(message = "Por favor insira seu complemento!")
    @field:Length(message = "Seu complemento deve ter no máximo 100 caracteres", max = 100)
    val complemento: String,

    @Column(name = "cidade_fk")
    @field:NotNull(message = "Por favor insira o nome de sua cidade!")
    val cidadeId: UUID,

)
