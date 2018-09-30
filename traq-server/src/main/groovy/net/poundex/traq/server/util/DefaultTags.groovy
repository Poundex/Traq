package net.poundex.traq.server.util

import net.poundex.traq.server.dao.TagRepository
import net.poundex.traq.server.domain.Tag
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DefaultTags implements CommandLineRunner
{
	private final static Tag NOPROD = new Tag(name: "noprod")
	private final static Tag NOACCOUNT = new Tag(name: "noaccount", metaTags: [NOPROD])

	private final TagRepository tagRepository

	DefaultTags(TagRepository tagRepository)
	{
		this.tagRepository = tagRepository
	}

	@Override
	void run(String... args) throws Exception
	{
		[NOPROD, NOACCOUNT].each { t ->
			tagRepository.findByName(t.name).onEmpty {
				tagRepository.save(t)
			}
		}
	}
}
