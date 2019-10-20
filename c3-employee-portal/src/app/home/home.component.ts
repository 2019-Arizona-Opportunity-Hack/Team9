import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit() {
  }

  public addPersonClick() {
    this._router.navigate(['primaryhousehold']);
  }

  public editPersonClick() {
    this._router.navigate(['membersearch']);
  }

  public reportsClick() {
    this._router.navigate(['reportgenerator']);
  }

}
