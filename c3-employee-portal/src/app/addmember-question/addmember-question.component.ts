import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addmember-question',
  templateUrl: './addmember-question.component.html',
  styleUrls: ['./addmember-question.component.css']
})
export class AddmemberQuestionComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  public onYes() {
    this.router.navigate(['addmembers']);
  }

  public onNo() {
    this.router.navigate(['success']);
  }
}
