import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {ROUTES} from "./app.routes";
import {HttpClientModule} from "@angular/common/http";
import {DataService} from "./data.service";
import { DayViewComponent } from './day-view/day-view.component';
import {AngularFontAwesomeModule} from "angular-font-awesome";
import { DurationPipe } from './duration.pipe';
import { AddSpanFormComponent } from './add-span-form/add-span-form.component';
import { AddPointFormComponent } from './add-point-form/add-point-form.component';
import { AddEventFormComponent } from './add-event-form/add-event-form.component';
import { FeatherIconComponent } from './feather-icon/feather-icon.component';
import { InlineTagComponent } from './inline-tag/inline-tag.component';

@NgModule({
  declarations: [
    AppComponent,
    DayViewComponent,
    DurationPipe,
    AddSpanFormComponent,
    AddPointFormComponent,
    AddEventFormComponent,
    FeatherIconComponent,
    InlineTagComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    RouterModule.forRoot(ROUTES),
    HttpClientModule,
	  AngularFontAwesomeModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
