import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import {TimelineEvent} from "./timeline-event";

@Injectable({
	providedIn: 'root'
})
export class DataService implements Resolve<Array<TimelineEvent>>
{
	constructor(private http: HttpClient) { }

	resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Array<TimelineEvent>>
	{
		return this.http.get<Array<TimelineEvent>>("http://localhost:8080/event", {
			params: { date: route.paramMap.get("date") }
		});
	}

	saveEvent(event: TimelineEvent, span: boolean): Observable<any>
	{
		// console.log(event);
		return this.http.post("http://localhost:8080/ " + (span ? "span" : "point"), event);
	}
}
