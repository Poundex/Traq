package net.poundex.traq.server.web

import net.poundex.traq.server.dao.TagRepository
import net.poundex.traq.server.dto.DtoService
import net.poundex.traq.server.dto.TagDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tag")
class TagController
{
	private final TagRepository tagRepository
	private final DtoService dtoService

	TagController(TagRepository tagRepository, DtoService dtoService)
	{
		this.tagRepository = tagRepository
		this.dtoService = dtoService
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
}
