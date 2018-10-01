import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Tag} from "../timeline-event";

@Component({
	selector: 'app-manage-tags',
	templateUrl: './manage-tags.component.html',
	styleUrls: ['./manage-tags.component.css']
})
export class ManageTagsComponent implements OnInit
{
	tags: Array<Tag>;

	constructor(private activatedRoute: ActivatedRoute)
	{
	}

	ngOnInit()
	{
		this.activatedRoute.data.subscribe(d => this.tags = d['tagData'])
	}

}
