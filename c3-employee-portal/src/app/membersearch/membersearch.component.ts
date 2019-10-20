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
    member.id = '1';
    member.firstName = 'Dennis';
    member.lastName = 'Kertis';
    member.dateOfBirth = '02/02/2018';
    this.results.push(member);
  }
}
