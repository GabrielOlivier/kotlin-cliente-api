package br.edu.facec.cliente.entity

import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Cliente(
    @Id
    @GeneratedValue
    val id: UUID?,

    @Column(name = "cliente")
    @field:NotBlank(message = "Não esqueça de informar o nome do Cliente!")
    @field:Length(message = "O nome do cliente deve ter um limite de 100 caracteres", max = 100)
    val nCliente: String,

    @Column(name = "sexo")
    @Enumerated(value = EnumType.STRING)
    @field:NotBlank(message = "Seu Sexo é FEMINO ou MASCULINO?")
    @field:Length(message = " Informe no máximo 9 caracteres", max = 9)
    val sexo: Sexo,

    @Column(name = "documento")
    @field:NotBlank(message = "Informe seu CPF por favor!")
    @field:Length(message = "Seu CPF deve ter no maximo 14 caracteres", max = 14 )
    val CPF: String,

    @Column(name = "endereco_fk")
    @field:NotNull(message = "É preciso inserir o endereço!")
    @ManyToOne
    val enderecoId: UUID,


)
