import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Tag} from "./timeline-event";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
	providedIn: 'root'
})
export class TagDataService implements Resolve<Array<Tag>>
{
	constructor(private http: HttpClient)
	{
	}

	resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Array<Tag>> | Promise<Array<Tag>> | Array<Tag>
	{
		return this.http.get<Array<Tag>>("http://localhost:8080/tag");
	}

	getTag(id: number)
	{
		return this.http.get<Tag>("http://localhost:8080/tag/" + id);
	}

	updateTag(tag: Tag): Observable<any>
	{
		return this.http.put("http://localhost:8080/tag/" + tag.id, tag);
	}
}
