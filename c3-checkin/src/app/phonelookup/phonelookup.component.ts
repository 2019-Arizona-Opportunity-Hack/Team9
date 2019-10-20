import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { ApiService } from '../api.service';
import {Router} from '@angular/router';
import {Service} from '../../models/service';
import {Member} from '../../models/member';

@Component({
  selector: 'app-phonelookup',
  templateUrl: './phonelookup.component.html',
  styleUrls: ['./phonelookup.component.css']
})
export class PhonelookupComponent implements OnInit {
  phoneNumber: any = '';
  registerForm: FormGroup;

  numbers = [
    1, 2, 3, 4, 5, 6, 7, 8, 9, 0
  ];

  constructor(private formBuilder: FormBuilder, private apiService: ApiService, private router: Router) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      phoneNumber: ['', Validators.required]
    });
  }

  get f() { return this.registerForm.controls; }

  backspace() {
    this.phoneNumber = this.phoneNumber.substring(0, this.phoneNumber.length - 1);
  }

  select(selNumber) {
    if (this.phoneNumber.length < 10) {
      this.phoneNumber = this.phoneNumber + '' + selNumber;
    }
  }

  get getPhoneNumber(): any {
    return this.phoneNumber;
  }

  goHome() {
    this.router.navigate(['login']);
  }

  onSubmit() {
    if (this.phoneNumber.length === 10) {
      const members = [];

      this.apiService.lookupByPhoneNumber(this.phoneNumber)
        .subscribe((data) => {
          // @ts-ignore
          if (data.length > 0) {
            sessionStorage.setItem('houseHoldName', data[0].caregiver.person.first_name + ' ' + data[0].caregiver.person.last_name);

            members.push(
              new Member(
                data[0].caregiver.caregiver_id,
                data[0].caregiver.person.first_name + ' ' + data[0].caregiver.person.last_name
              )
            );

            let i;
            // @ts-ignore
            for (i = 0; i < data[0].dependents.length; i++) {
              members.push(
                new Member(
                  data[0].dependents[i].dependent_id,
                  data[0].dependents[i].person.first_name + ' ' + data[0].dependents[i].person.last_name
                )
              );
            }

            sessionStorage.setItem('memberLookup', JSON.stringify(members, null, 4));
          }
          this.router.navigate(['verify']);
        });
    } else {
      alert('Please enter a valid phone number.');
    }
  }
}
