import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import {TimelineEvent} from "./timeline-event";
import {Day} from "./day";

@Injectable({
	providedIn: 'root'
})
export class DataService implements Resolve<Day>
{
	constructor(private http: HttpClient) { }

	resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Day>
	{
		return this.http.get<Day>("http://localhost:8080/day", {
			params: { date: route.paramMap.get("date") }
		});
	}

	saveEvent(event: TimelineEvent, span: boolean): Observable<any>
	{
		// console.log(event);
		return this.http.post("http://localhost:8080/" + (span ? "span" : "point"), event);
	}
}
