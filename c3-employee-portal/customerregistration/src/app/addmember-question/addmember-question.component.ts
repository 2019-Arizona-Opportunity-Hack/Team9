import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addmember-question',
  templateUrl: './addmember-question.component.html',
  styleUrls: ['./addmember-question.component.scss']
})
export class AddmemberQuestionComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit() {
  }

  public onYes() {
    this._router.navigate(['addmembers']);
  }

  public onNo() {
    this._router.navigate(['success']);
  }
}
