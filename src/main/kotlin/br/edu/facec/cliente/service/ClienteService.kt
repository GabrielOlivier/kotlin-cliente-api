package br.edu.facec.cliente.service

import br.edu.facec.cliente.entity.Cliente
import br.edu.facec.cliente.repository.ClienteRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClienteService (private val repository: ClienteRepository){
    fun findAll(pageable: Pageable) = repository.findAll(pageable)

    fun findById(id: UUID): Cliente? = repository.findByIdOrNull(id)

    fun save(cliente: Cliente): Cliente = repository.save(cliente)

    fun exists(id: UUID) = repository.existsById(id)

    fun deleteById(id: UUID) = repository.deleteById(id)
}