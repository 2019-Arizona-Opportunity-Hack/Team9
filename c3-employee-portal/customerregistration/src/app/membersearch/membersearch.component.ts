import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-membersearch',
  templateUrl: './membersearch.component.html',
  styleUrls: ['./membersearch.component.scss']
})
export class MembersearchComponent implements OnInit {
  lastName = '';
  dateOfBirth = '';

  constructor() { }

  ngOnInit() {
  }

  public memberSearch() {
    console.log("searching...");
  }

}
