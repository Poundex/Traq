import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TagDataService} from "../tag-data.service";
import { switchMap } from 'rxjs/operators';
import {Tag} from "../timeline-event";

@Component({
	selector: 'app-edit-tag-form',
	templateUrl: './edit-tag-form.component.html',
	styleUrls: ['./edit-tag-form.component.css']
})
export class EditTagFormComponent implements OnInit
{
	public tag: Tag = { id: null, name: "", description: "", metaTags: [] };

	constructor(private activatedRoute: ActivatedRoute, private tagDataService: TagDataService, private router: Router) { }

	ngOnInit()
	{
		this.activatedRoute.paramMap.pipe(switchMap(params => {
			let id = params.get("id");
			if(id) return this.tagDataService.getTag(+id);
		})).subscribe(tag => {
			this.tag = tag;
		});
	}

	onSubmit(): void
	{
		this.tagDataService.updateTag(this.tag).subscribe((val) => {
			console.log("The val: ", val);
			return this.router.navigate(["/manage/tags"]);
		});
	}
}
