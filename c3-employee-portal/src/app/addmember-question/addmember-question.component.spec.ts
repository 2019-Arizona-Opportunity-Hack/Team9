import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddmemberQuestionComponent } from './addmember-question.component';

describe('AddmemberQuestionComponent', () => {
  let component: AddmemberQuestionComponent;
  let fixture: ComponentFixture<AddmemberQuestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddmemberQuestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddmemberQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
