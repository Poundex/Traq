import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TagDataService} from "../tag-data.service";
import { switchMap } from 'rxjs/operators';

@Component({
	selector: 'app-edit-tag-form',
	templateUrl: './edit-tag-form.component.html',
	styleUrls: ['./edit-tag-form.component.css']
})
export class EditTagFormComponent implements OnInit
{
	constructor(private activatedRoute: ActivatedRoute, private tagDataService: TagDataService) { }

	ngOnInit()
	{
		this.activatedRoute.paramMap.pipe(switchMap(params => {
			let id = params.get("id");
			if(id) return this.tagDataService.getTag(+id);
		})).subscribe(tag => {
			console.log(tag);
		});
	}

}
