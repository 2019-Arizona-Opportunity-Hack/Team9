import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-editmember',
  templateUrl: './editmember.component.html',
  styleUrls: ['./editmember.component.scss']
})
export class EditmemberComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() { }

  public onSubmit() {
    this.router.navigate(['success']);
  }
}
