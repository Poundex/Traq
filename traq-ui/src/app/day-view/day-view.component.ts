import { Component, OnInit } from '@angular/core';
import {TimelineEvent} from "../timeline-event";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-day-view',
  templateUrl: './day-view.component.html',
  styleUrls: ['./day-view.component.css']
})
export class DayViewComponent implements OnInit {

	date = new Date();
	data: Array<TimelineEvent> = [];

	constructor(private route: ActivatedRoute) {
	}

	ngOnInit(): void {
		this.route.data.subscribe(d =>{
			console.log(d);
			this.data = d['dayData'];
		});
	}

}
