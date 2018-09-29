package net.poundex.traq.server.dto

import groovy.transform.Canonical

@Canonical
class TagDto implements Dto
{
	String name
	String description
}
