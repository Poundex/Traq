import {Routes} from "@angular/router";
import {DayViewComponent} from "./day-view/day-view.component";
import {DataService} from "./data.service";
import {AddSpanFormComponent} from "./add-span-form/add-span-form.component";
import {AddPointFormComponent} from "./add-point-form/add-point-form.component";

export const ROUTES: Routes = [
	{
		path: '',
		redirectTo: '/day/today',
		pathMatch: 'full'
	},
	{
		path: 'day/:date',
		component: DayViewComponent,
		resolve: {
			dayData: DataService
		}
	},
	{
		path: 'addSpan/:date',
		component: AddSpanFormComponent,
	},
	{
		path: 'addPoint/:date',
		component: AddPointFormComponent
	}
];
