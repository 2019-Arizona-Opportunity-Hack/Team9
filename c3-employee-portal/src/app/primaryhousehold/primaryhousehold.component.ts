import { Component, OnInit } from '@angular/core';
import { Caregiver } from '../../models/caregiver';
import { Router } from '@angular/router';
import { Address } from 'src/models/address';
import { Person } from 'src/models/person';
import { C3ApiService } from '../c3-api.service';

@Component({
  selector: 'app-primaryhousehold',
  templateUrl: './primaryhousehold.component.html',
  styleUrls: ['./primaryhousehold.component.css']
})
export class PrimaryhouseholdComponent implements OnInit {
  public caregiver: Caregiver;

  constructor(private _router: Router, private c3services: C3ApiService) { }

  ngOnInit() {
    this.caregiver = new Caregiver();
    this.caregiver.person = new Person();
    this.caregiver.address = new Address();
  }

  public onSubmit() {
    this.c3services.addFamily(this.caregiver).subscribe();
    sessionStorage.setItem('currentCaregiver', JSON.stringify(this.caregiver, null, 4));
    this._router.navigate(['addmemberquestion']);
  }
}
