import {Component, Input, OnInit} from '@angular/core';
import {Day} from "../day";

@Component({
	selector: 'app-day-stats',
	templateUrl: './day-stats.component.html',
	styleUrls: ['./day-stats.component.css']
})
export class DayStatsComponent implements OnInit
{
	@Input()
	day: Day;

	constructor() { }

	ngOnInit() { }
}
