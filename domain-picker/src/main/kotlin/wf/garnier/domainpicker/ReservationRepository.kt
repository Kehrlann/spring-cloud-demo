package wf.garnier.domainpicker

import org.springframework.data.repository.PagingAndSortingRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

interface ReservationRepository: PagingAndSortingRepository<Reservation, Long>

@Entity
data class Reservation(@GeneratedValue @Id val id: Long = 0L, val domain: String = "")