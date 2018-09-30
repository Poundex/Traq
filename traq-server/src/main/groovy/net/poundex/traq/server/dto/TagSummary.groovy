package net.poundex.traq.server.dto

import groovy.transform.Canonical

@Canonical
class TagSummary implements Dto
{
	List<TagSummaryEntry> tagSummaryEntries

	@Canonical
	static class TagSummaryEntry implements Dto
	{
		TagDto tag
		Long duration
	}
}
