import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimaryhouseholdComponent } from './primaryhousehold.component';

describe('PrimaryhouseholdComponent', () => {
  let component: PrimaryhouseholdComponent;
  let fixture: ComponentFixture<PrimaryhouseholdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrimaryhouseholdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrimaryhouseholdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
