package net.poundex.traq.server.web

import net.poundex.traq.server.dao.TagRepository
import net.poundex.traq.server.domain.Tag
import net.poundex.traq.server.dto.DtoService
import net.poundex.traq.server.dto.TagDto
import net.poundex.traq.server.service.TagService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tag")
class TagController
{
	private final TagRepository tagRepository
	private final DtoService dtoService
	private final TagService tagService

	TagController(TagRepository tagRepository, DtoService dtoService, TagService tagService)
	{
		this.tagRepository = tagRepository
		this.dtoService = dtoService
		this.tagService = tagService
	}

	@GetMapping
	Iterable<TagDto> findAll()
	{
		return dtoService.toDtos(tagRepository.findAll(), TagDto)
	}

	@GetMapping("/{id}")
	TagDto find(@PathVariable Long id)
	{
		return dtoService.toDto(tagRepository.findById(id).orElse(null), TagDto)
	}

	@PutMapping("/{id}")
	TagDto update(@PathVariable Long id, @RequestBody TagDto tagDto)
	{
		Tag tag = tagRepository.findById(id).orElseThrow( { new NotFoundException(Tag, id) })
		tagDto.apply(tag)
		return dtoService.toDto(tagService.updateTag(tag), TagDto)
	}
}
