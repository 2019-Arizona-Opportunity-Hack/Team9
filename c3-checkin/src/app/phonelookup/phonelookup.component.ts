import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Service} from '../../models/service';

@Component({
  selector: 'app-phonelookup',
  templateUrl: './phonelookup.component.html',
  styleUrls: ['./phonelookup.component.css']
})
export class PhonelookupComponent implements OnInit {
  phoneNumber: any = '';
  registerForm: FormGroup;
  submitted = false;

  numbers = [
    1, 2, 3, 4, 5, 6, 7, 8, 9, 0
  ];

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      phoneNumber: ['', Validators.required]
    });
  }

  get f() { return this.registerForm.controls; }

  select(selNumber) {
    if (this.phoneNumber.length < 10) {
      this.phoneNumber = this.phoneNumber + '' + selNumber;
    }
  }

  get getPhoneNumber(): any {
    return this.phoneNumber;
  }

  onSubmit() {
    if (this.phoneNumber.length === 10) {
      this.submitted = true;

      sessionStorage.setItem('houseHoldName', 'Jesse Coddington');

      window.location.href = '/verify';
    } else {
      alert('Please enter a valid phone number.');
    }
  }
}
