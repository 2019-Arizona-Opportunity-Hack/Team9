import { Component, OnInit } from '@angular/core';
import { Member } from '../../models/member';

@Component({
  selector: 'app-addmember',
  templateUrl: './addmember.component.html',
  styleUrls: ['./addmember.component.scss']
})
export class AddmemberComponent implements OnInit {
  public member: Member;

  constructor() { }

  ngOnInit() {
    this.member = new Member();
  }
}
