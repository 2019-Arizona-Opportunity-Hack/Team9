import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-thanks',
  templateUrl: './thanks.component.html',
  styleUrls: ['./thanks.component.css']
})
export class ThanksComponent implements OnInit, AfterViewInit {

  constructor(private router: Router) { }

  ngOnInit() {
    sessionStorage.clear();
  }

  ngAfterViewInit(): void {
    setInterval(this.myTimer, 5000);
  }

  myTimer() {
    this.router.navigate(['login']);
  }
}
