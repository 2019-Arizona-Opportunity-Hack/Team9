import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditmemberComponent } from './editmember.component';

describe('EditmemberComponent', () => {
  let component: EditmemberComponent;
  let fixture: ComponentFixture<EditmemberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditmemberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditmemberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
