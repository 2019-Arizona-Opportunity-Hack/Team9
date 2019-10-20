import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportServiceSelectorComponent } from './report-service-selector.component';

describe('ReportServiceSelectorComponent', () => {
  let component: ReportServiceSelectorComponent;
  let fixture: ComponentFixture<ReportServiceSelectorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportServiceSelectorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportServiceSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
