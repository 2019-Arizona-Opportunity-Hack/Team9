import { Component, OnInit } from '@angular/core';
import { Caregiver } from '../../models/Caregiver';
import { Router } from '@angular/router';

@Component({
  selector: 'app-primaryhousehold',
  templateUrl: './primaryhousehold.component.html',
  styleUrls: ['./primaryhousehold.component.scss']
})
export class PrimaryhouseholdComponent implements OnInit {
  public caregiver: Caregiver;

  constructor(private _router: Router) { }

  ngOnInit() {
    this.caregiver = new Caregiver();
  }

  public onSubmit() {
    this._router.navigate(['addmemberquestion']);
  }
}
