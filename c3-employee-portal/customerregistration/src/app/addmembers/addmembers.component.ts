import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Member } from 'src/models/Member';

@Component({
  selector: 'app-addmembers',
  templateUrl: './addmembers.component.html',
  styleUrls: ['./addmembers.component.scss']
})
export class AddmembersComponent implements OnInit {
  members: Member[] = [];

  constructor(private _router: Router) { }

  ngOnInit() {
    this.members.push(new Member());
  }

  public onSubmitMembers() {
    this._router.navigate(['success']);
  }

  public onAddAnother() {
    this.members.push(new Member());
  }
}
