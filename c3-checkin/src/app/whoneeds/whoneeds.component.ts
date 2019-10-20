import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-whoneeds',
  templateUrl: './whoneeds.component.html',
  styleUrls: ['./whoneeds.component.css']
})
export class WhoneedsComponent implements OnInit {
  selected = [];
  members = [];

  constructor(private router: Router) {
    this.members = JSON.parse(sessionStorage.getItem('memberLookup'));
  }

  ngOnInit() { }

  select(member) {
    if (this.selected.includes(member)) {
      this.selected.splice(this.selected.indexOf(member), 1);
    } else {
      this.selected.push(member);
    }
  }

  isActive(member) {
    return this.selected.includes(member);
  }

  goHome() {
    this.router.navigate(['login']);
  }

  onClick() {
    if (this.selected.length > 0) {
      sessionStorage.setItem('whoNeeds', JSON.stringify(this.selected, null, 4));

      this.router.navigate(['services']);
    } else {
      alert('Please select who needs services.');
    }
  }
}
