import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportDatesSelectorComponent } from './report-dates-selector.component';

describe('ReportDatesSelectorComponent', () => {
  let component: ReportDatesSelectorComponent;
  let fixture: ComponentFixture<ReportDatesSelectorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportDatesSelectorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportDatesSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
