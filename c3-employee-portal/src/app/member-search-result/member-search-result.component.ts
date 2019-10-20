import { Component, OnInit, Input } from '@angular/core';
import { Member } from 'src/models/member';

@Component({
  selector: 'app-member-search-result',
  templateUrl: './member-search-result.component.html',
  styleUrls: ['./member-search-result.component.scss']
})
export class MemberSearchResultComponent implements OnInit {
  @Input() result: Member;

  constructor() { }

  ngOnInit() {
  }

  public memberSelect(lastName) {
    console.log('in member select: ' + lastName);
  }
}
