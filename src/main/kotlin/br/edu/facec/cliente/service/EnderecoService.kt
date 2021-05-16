package br.edu.facec.cliente.service

import br.edu.facec.cliente.entity.Endereco
import br.edu.facec.cliente.repository.EnderecoRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class EnderecoService(private val repository: EnderecoRepository) {

    fun findAll(pageable: Pageable) = repository.findAll(pageable)

    fun findById(id: UUID): Endereco? = repository.findByIdOrNull(id)

    fun save(endereco: Endereco): Endereco = repository.save(endereco)

    fun exists(id: UUID) = repository.existsById(id)

    fun deleteById(id: UUID) = repository.deleteById(id)

}