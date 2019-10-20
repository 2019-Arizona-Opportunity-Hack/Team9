import { Component, OnInit, Input } from '@angular/core';
import { Member } from 'src/models/Member';

@Component({
  selector: 'app-member-search-result',
  templateUrl: './member-search-result.component.html',
  styleUrls: ['./member-search-result.component.scss']
})
export class MemberSearchResultComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }

  public memberSelect() {
    console.log('in member select');
  }
}
