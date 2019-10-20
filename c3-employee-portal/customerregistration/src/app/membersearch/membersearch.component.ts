import { Component, OnInit } from '@angular/core';
import { Member } from 'src/models/Member';

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
    this.results.push(new Member());
  }

}
