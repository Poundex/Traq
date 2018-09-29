package net.poundex.traq.server.domain


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Tag
{
	@Id
	@GeneratedValue
	Long id
	String name
	String description
}
