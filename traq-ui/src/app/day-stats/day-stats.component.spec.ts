import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DayStatsComponent } from './day-stats.component';

describe('DayStatsComponent', () => {
  let component: DayStatsComponent;
  let fixture: ComponentFixture<DayStatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DayStatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DayStatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
