import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-verify',
  templateUrl: './verify.component.html',
  styleUrls: ['./verify.component.css']
})
export class VerifyComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  goHome() {
    this.router.navigate(['login']);
  }

  goWhoNeeds() {
    this.router.navigate(['whoneeds']);
  }

  goPhoneLookup() {
    this.router.navigate(['phonelookup']);
  }

  get houseHoldName(): any {
    return sessionStorage.getItem('houseHoldName');
  }
}
