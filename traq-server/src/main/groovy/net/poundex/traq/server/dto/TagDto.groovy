package net.poundex.traq.server.dto

import groovy.transform.Canonical
import net.poundex.traq.server.domain.Tag

@Canonical
class TagDto implements Dto
{
	Long id
	String name
	String description
	Set<TagDto> metaTags

	void apply(Tag tag)
	{
		tag.name = this.name
		tag.description = this.description
	}
}
