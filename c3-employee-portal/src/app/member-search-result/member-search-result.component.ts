import { Component, OnInit, Input } from '@angular/core';
import { Member } from 'src/models/member';
import {Router} from '@angular/router';

@Component({
  selector: 'app-member-search-result',
  templateUrl: './member-search-result.component.html',
  styleUrls: ['./member-search-result.component.scss']
})
export class MemberSearchResultComponent implements OnInit {
  @Input() result: Member;

  constructor(private router: Router) { }

  ngOnInit() {}

  memberSelect(id) {
    this.router.navigate(['editmember']);
  }
}
