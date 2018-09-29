package net.poundex.traq.server.dao

import net.poundex.traq.server.domain.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository extends JpaRepository<Tag, Long>
{
	Iterable<Tag> findAllByNameIn(Collection<String> names)
}
