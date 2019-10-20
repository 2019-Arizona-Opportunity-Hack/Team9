import { Component, OnInit } from '@angular/core';
import { Caregiver } from '../../models/caregiver';
import { Router } from '@angular/router';

@Component({
  selector: 'app-primaryhousehold',
  templateUrl: './primaryhousehold.component.html',
  styleUrls: ['./primaryhousehold.component.css']
})
export class PrimaryhouseholdComponent implements OnInit {
  public caregiver: Caregiver;

  constructor(private router: Router) { }

  ngOnInit() {
    this.caregiver = new Caregiver();
  }

  public onSubmit() {
    this.router.navigate(['addmemberquestion']);
  }
}
