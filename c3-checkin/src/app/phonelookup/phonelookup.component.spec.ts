import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhonelookupComponent } from './phonelookup.component';

describe('PhonelookupComponent', () => {
  let component: PhonelookupComponent;
  let fixture: ComponentFixture<PhonelookupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhonelookupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhonelookupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
