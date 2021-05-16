package br.edu.facec.cliente.repository

import br.edu.facec.cliente.entity.Endereco
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface EnderecoRepository : PagingAndSortingRepository<Endereco, UUID> {

}