import {Component, Input, OnInit} from '@angular/core';

@Component({
	selector: 'icon',
	templateUrl: './feather-icon.component.html',
	styleUrls: ['./feather-icon.component.css']
})
export class FeatherIconComponent implements OnInit
{
	@Input()
	size: number = 18;

	@Input()
	iconName: string;

	constructor()
	{
	}

	ngOnInit()
	{
	}

	get sizeStyle(): string
	{
		let s: string = "width: " + this.size + "px; height: " + this.size + "px";
		console.log(s);
		return s;
	}

}
