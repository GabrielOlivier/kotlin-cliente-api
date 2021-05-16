package br.edu.facec.cliente.resource

import br.edu.facec.cliente.entity.Endereco
import br.edu.facec.cliente.service.EnderecoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
class EnderecoResource(private val service: EnderecoService) {

    @GetMapping("/endereco")
    fun getAll(pageable: Pageable): ResponseEntity<Page<Endereco>> {
        val page = service.findAll(pageable)
        return ResponseEntity.ok(page)
    }

    @GetMapping("/endereco/{id}")
    fun getById(@PathVariable("id") id: UUID): ResponseEntity<Endereco> {
        if (!service.exists(id)) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build()
        }
        val found = service.findById(id)
        return ResponseEntity.ok(found)
    }

    @PostMapping("/endereco")
    fun post(@RequestBody @Valid endereco: Endereco): ResponseEntity<Endereco> {
        val saved = service.save(endereco)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved)
    }

    @PutMapping("/endereco/{id}")
    fun put(@PathVariable("id") id: UUID, @Valid @RequestBody endereco: Endereco): ResponseEntity<Endereco> {
        if (!service.exists(id)) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build()
        }
        val toUpdate = Endereco(id = id, cep = endereco.cep, rua = endereco.rua, numero = endereco.numero, bairro = endereco.bairro, complemento = endereco.complemento, cidadeId = endereco.cidadeId)
        val saved = service.save(toUpdate)
        return ResponseEntity.ok(saved)
    }

    @DeleteMapping("/endereco/{id}")
    fun delete(@PathVariable("id") id: UUID): ResponseEntity<Endereco> {
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