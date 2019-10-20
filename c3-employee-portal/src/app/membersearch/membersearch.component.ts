import { Component, OnInit } from '@angular/core';
import { Member } from 'src/models/member';

@Component({
  selector: 'app-membersearch',
  templateUrl: './membersearch.component.html',
  styleUrls: ['./membersearch.component.scss']
})
export class MembersearchComponent implements OnInit {
  lastName = '';
  dateOfBirth = '';
  results: Member[] = [];

  constructor() { }

  ngOnInit() {
  }

  public memberSearch() {
    this.results = [];
    const member = new Member();
    member.lastName = 'test';
    member.dateOfBirth = new Date('1/1/2018');
    this.results.push(member);

    const member2 = new Member();
    member2.lastName = 'test2';
    member2.dateOfBirth = new Date('2/2/2018');
    this.results.push(member2);
  }

}
