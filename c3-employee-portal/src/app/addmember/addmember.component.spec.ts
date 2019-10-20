import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { Member } from '../../models/member';
import { AddmemberComponent } from './addmember.component';

describe('AddmemberComponent', () => {
  let component: AddmemberComponent;
  let fixture: ComponentFixture<AddmemberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddmemberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddmemberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
