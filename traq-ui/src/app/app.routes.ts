import {Routes} from "@angular/router";
import {DayViewComponent} from "./day-view/day-view.component";
import {DayDataService} from "./day-data.service";
import {AddSpanFormComponent} from "./add-span-form/add-span-form.component";
import {AddPointFormComponent} from "./add-point-form/add-point-form.component";
import {ManageComponent} from "./manage/manage.component";
import {ManageTagsComponent} from "./manage-tags/manage-tags.component";
import {TagDataService} from "./tag-data.service";
import {EditTagFormComponent} from "./edit-tag-form/edit-tag-form.component";

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
			dayData: DayDataService
		}
	},
	{
		path: 'addSpan/:date',
		component: AddSpanFormComponent,
	},
	{
		path: 'addPoint/:date',
		component: AddPointFormComponent
	},
	{
		path: 'manage',
		component: ManageComponent,
		children: [
			{
				path: 'tags/edit/:id',
				component: EditTagFormComponent
			},
			{
				path: 'tags',
				component: ManageTagsComponent,
				resolve: {
					tagData: TagDataService
				}
			}
		]
	}
];
