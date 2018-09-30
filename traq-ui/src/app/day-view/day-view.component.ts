import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Day} from "../day";

@Component({
	selector: 'app-day-view',
	templateUrl: './day-view.component.html',
	styleUrls: ['./day-view.component.css']
})
export class DayViewComponent implements OnInit
{

	date = new Date();
	day: Day;

	constructor(private route: ActivatedRoute, private router: Router) { }

	ngOnInit(): void
	{
		this.route.data.subscribe(d => {
			console.log(d);
			this.day = d['dayData'];
		});
		this.route.paramMap.subscribe((params) => {
			let dp: string = params.get("date");
			this.date = dp === "today" ? new Date() : new Date(dp);
		})
	}

	get minusOneDaysAgo(): string
	{
		return new Date(new Date().setDate(this.date.getDate() - 1)).toISOString().substr(0, 10);
	}

	get plusOneDay(): string
	{
		return new Date(new Date().setDate(this.date.getDate() + 1)).toISOString().substr(0, 10);
	}

	onDateChanged(event: string): void
	{
		// console.log(event);
		if (!event || event === "")
			event = "today";
		this.router.navigate(["/day", event])
	}
}
