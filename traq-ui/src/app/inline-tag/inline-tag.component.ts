import {Component, Input, OnInit} from '@angular/core';
import {Tag} from "../timeline-event";

@Component({
	selector: 'inline-tag',
	templateUrl: './inline-tag.component.html',
	styleUrls: ['./inline-tag.component.css']
})
export class InlineTagComponent implements OnInit
{
	@Input()
	asWritten: string;

	@Input()
	tagData: Array<Tag>;
	tag: Tag;

	constructor() {}

	ngOnInit()
	{
		let findMe: string = this.asWritten.substr(1).toLowerCase();
		console.log(this.tagData, findMe);
		this.tag = this.tagData.find(t => t.name === findMe);
	}
}
