package br.edu.facec.cliente.repository

import br.edu.facec.cliente.entity.Cliente
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*
interface ClienteRepository : PagingAndSortingRepository<Cliente, UUID>
 {

}