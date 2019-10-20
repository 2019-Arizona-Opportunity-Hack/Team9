import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WhoneedsComponent } from './whoneeds.component';

describe('WhoneedsComponent', () => {
  let component: WhoneedsComponent;
  let fixture: ComponentFixture<WhoneedsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WhoneedsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WhoneedsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
