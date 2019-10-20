import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { ApiService } from '../api.service';
import {Router} from '@angular/router';

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
      sessionStorage.setItem('houseHoldName', 'Jesse Coddington');

      this.router.navigate(['verify']);
      //
      // this.apiService.lookupByPhoneNumber(this.phoneNumber)
      //   .subscribe((data) => {
      //
      //   console.log(data);
      //
      //   sessionStorage.setItem('houseHoldName', 'Jesse Coddington');
      //
      //   window.location.href = 'verify';
      // });
    } else {
      alert('Please enter a valid phone number.');
    }
  }
}
