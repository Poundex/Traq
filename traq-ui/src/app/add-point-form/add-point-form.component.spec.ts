import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPointFormComponent } from './add-point-form.component';

describe('AddPointFormComponent', () => {
  let component: AddPointFormComponent;
  let fixture: ComponentFixture<AddPointFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddPointFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPointFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
