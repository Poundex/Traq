package net.poundex.traq.server.domain


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class Tag
{
	@Id
	@GeneratedValue
	Long id
	String name
	String description

	@ManyToMany
	Set<Tag> metaTags = new HashSet<>()

	boolean hasTag(String s)
	{
		metaTags.find { it.name == s || it.hasTag(s) }
	}
}
