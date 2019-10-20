import {AfterViewInit, Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-thanks',
  templateUrl: './thanks.component.html',
  styleUrls: ['./thanks.component.css']
})
export class ThanksComponent implements OnInit, AfterViewInit {

  constructor() { }

  ngOnInit() {
    sessionStorage.clear();
  }

  ngAfterViewInit(): void {
    setInterval(this.myTimer, 5000);
  }

  myTimer() {
    window.location.href = '/login';
  }
}
