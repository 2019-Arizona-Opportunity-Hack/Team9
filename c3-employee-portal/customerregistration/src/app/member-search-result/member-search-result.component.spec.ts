import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberSearchResultComponent } from './member-search-result.component';

describe('MemberSearchResultComponent', () => {
  let component: MemberSearchResultComponent;
  let fixture: ComponentFixture<MemberSearchResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemberSearchResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberSearchResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
