import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSpanFormComponent } from './add-span-form.component';

describe('AddSpanFormComponent', () => {
  let component: AddSpanFormComponent;
  let fixture: ComponentFixture<AddSpanFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddSpanFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSpanFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
