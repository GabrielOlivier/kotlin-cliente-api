package br.edu.facec.cliente.resource

import br.edu.facec.cliente.entity.Cliente
import br.edu.facec.cliente.service.ClienteService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
class ClienteResource(val service: ClienteService) {

    @GetMapping("/cliente")
    fun getAll(pageable: Pageable): ResponseEntity<Page<Cliente>> {
        val page = service.findAll(pageable)
        return ResponseEntity.ok(page)
    }

    @GetMapping("/cliente/{id}")
    fun getById(@PathVariable("id") id: UUID): ResponseEntity<Cliente> {
        val found = service.findById(id)
        return ResponseEntity.ok(found)
    }

    @PostMapping("/cliente")
    fun post(@Valid @RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        val saved = service.save(cliente)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(saved)
    }

    @PutMapping("/cliente/{id}")
    fun put(@PathVariable("id") id: UUID, @Valid @RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        if (!service.exists(id)) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build()
        }
        val toUpdate = Cliente(id = id, nCliente = cliente.nCliente, CPF = cliente.CPF, sexo = cliente.sexo, enderecoId = cliente.enderecoId)
        val saved = service.save(toUpdate)
        return ResponseEntity.ok(saved)
    }

    @DeleteMapping("/cliente/{id}")
    fun delete(@PathVariable("id") id: UUID): ResponseEntity<Cliente> {
        if (!service.exists(id)) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build()
        }
        service.deleteById(id)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()

    }

}