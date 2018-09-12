import {Routes} from "@angular/router";
import {DayViewComponent} from "./day-view/day-view.component";
import {DataService} from "./data.service";

export const ROUTES: Routes = [
	{
		path: '',
		redirectTo: '/day/today',
		pathMatch: 'full'
	},
	{
		path: 'day/today',
		component: DayViewComponent,
		resolve: {
			dayData: DataService
		}
	}
];
