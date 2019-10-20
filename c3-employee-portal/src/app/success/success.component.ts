import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.scss']
})
export class SuccessComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit() {
  }

  public restartClick() {
    this._router.navigate(['home']);
  }
}
