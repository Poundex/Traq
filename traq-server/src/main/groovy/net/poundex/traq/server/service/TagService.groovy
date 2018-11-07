package net.poundex.traq.server.service

import net.poundex.traq.server.dao.TagRepository
import net.poundex.traq.server.domain.Tag
import org.springframework.stereotype.Service

@Service
class TagService
{
	private final TagRepository tagRepository

	TagService(TagRepository tagRepository)
	{
		this.tagRepository = tagRepository
	}

	List<Tag> findOrCreateAllByText(List<String> tagTexts)
	{
		List<String> tagNames = tagTexts*.toLowerCase()
		List<Tag> found = tagRepository.findAllByNameIn(tagNames)
		tagNames.removeAll(found*.name)
		List<Tag> created = tagNames.collect {
			tagRepository.save(new Tag(name: it))
		}
		return found + created
	}

	Tag updateTag(Tag tag)
	{
		List<String> tagTexts = tag.description.findAll("#[A-Za-z0-9_-]+")*.replace('#', '')
		if(tag.metaTags == null)
			tag.metaTags = new HashSet<>()
		tag.metaTags.clear()
		tag.metaTags.addAll(findOrCreateAllByText(tagTexts))
		return tagRepository.save(tag)
	}
}
