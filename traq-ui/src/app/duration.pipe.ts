import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
	name: 'duration'
})
export class DurationPipe implements PipeTransform
{
	transform(value: number, args?: any): any
	{
		let hours: number = Math.floor(value / 60);
		let mins: number = value % 60;
		let r: string = "";
		if (hours !== 0)
			r += "" + hours + "'";
		// if (mins !== 0)
			r += "" + mins + "\"";
		return r;
	}
}
